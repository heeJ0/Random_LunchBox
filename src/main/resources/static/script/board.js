//공지사항 불러오기
$.ajax({
    url:"/getNotice",
    type:"POST",
    data: JSON.stringify(),
    contentType: "application/json",
    success: function(result){
        $("#head_title").attr("href", "/boardView?boardcode=" + result.board_code + "&view_cnt=" + result.view_cnt+"");
        $("#head_title").text(result.title)
        $("#head_name").text("< 교수 >"+result.name)
        $("#head_view").text(result.view_cnt)
        $("#head_date").text(result.createdAt.substring(0, 10))
        $("#head_modified").text(result.modifiedAt.substring(0, 10))
    },
    error: function(result){

    }
})


//페이지계산 준비
let pageTemp = $("#hide").val();
let totalCnt;
let totalPage ;

let pageSize = 10;
let start;
let end;
let pageNum = 0;

let pageStart = 1;
let pageEnd;
//total Cnt
$.ajax({
    url : "/getCnt",
    type : "POST",
    data : JSON,
    contentType : "application/json"
}).done(result =>{
    // 페이지 계산
    if(pageTemp === "null"){
        pageTemp = 1;
    }
    totalCnt = result;
    totalPage = totalCnt / 10 + (totalCnt % 10 > 0 ? 1 : 0);

    if (pageTemp == 1) {
        start = 1;
        pageNum = 1;
        pageStart = 1;
        end = 10;
    } else {
        pageNum = pageTemp;
        start = (pageNum - 1) * 10 + 1; // 1/1 , 2/11, 3/21 => x-1*10+1??
    }

    if(pageNum == start){
        pageStart = (pageNum - 1) * 10 + 1; // 1/1 2/6 3/11
        end = pageNum * 10; //
    }


    pageEnd =  pageStart * 10;
    if (pageEnd > totalPage) {
        pageEnd = totalPage;
    }
    list(start);

}).fail(erorr =>{
})

function list(start) {
// 게시글 조회
    $.ajax({
        url: "/readList",
        type: "POST",
        data: {
            "start" : start
        },
        success: function (result) {
            for (let i = 0; i < result.length; i++) {
                let tr = document.createElement("tr");
                let no = document.createElement("td");

                // title 앵커로 감싸주기
                let a = document.createElement("a");
                a.setAttribute("href", "/boardView?boardcode=" + result[i].board_code + "&view_cnt=" + result[i].view_cnt);
                a.setAttribute("style", "color:black");
                let title = document.createElement("td");
                let user = document.createElement("td");

                let cA = document.createElement("td");
                let mA = document.createElement("td");
                let view = document.createElement("td");
                // no, title, user, cA, mA , +viewCnt

                no.innerText = i + start;

                // title.innerText = result[i].title;
                a.innerText = result[i].title;
                title.append(a);
                // <td><a>title.innerText<a></td>
                if(result[i].usercode <100){
                    user.innerText = "< 교수 >" +result[i].name;
                }
                else{
                    user.innerText = result[i].name;
                }

                let subCA = result[i].createdAt.substring(0, 10);
                cA.innerText = subCA;
                let subMA = result[i].modifiedAt.substring(0, 10);
                mA.innerText = subMA;
                view.innerText = result[i].view_cnt;

                tr.append(no);
                tr.append(title);
                tr.append(user);
                tr.append(view);
                tr.append(cA);
                tr.append(mA);
                $("#here").append(tr);
            }
            makebt();
        }
        , error: function (result) {

        }
    })
}

// 게시글 작성
function boardW(){
    let grade_get = "S";
    if($("#usercode").val().length == 2){
        grade_get = "F";
    }
    let requestData = {
        "title" : $("#title").val(),
        "contents" : $("#content").val(),
        "usercode" : $("#usercode").val(),
        "grade" : grade_get,
        "name" : $("#userName").val()
    }

    if($("#title").val() == "" || $("#content").val()=="") alert("게시글을 작성해주세요.")
    else{
        $.ajax({
            url:"/boardWrite",
            type:"POST",
            data: JSON.stringify(requestData),
            contentType: "application/json",
            success: function(result){
                alert("게시글이 작성되었습니다.")
                location.href="/board";
            },
            error: function(result){

            }
        })
    }
}

//페이지 버튼 생성
function makebt() {
    if (pageStart > pageSize) {
        let before = document.createElement("a");
        before.setAttribute("value","이전");
        before.setAttribute("href","/board?page="+(pageStart-1));
        $("#btHere").append(before);


    }
    let spans = document.createElement("span")
    spans.setAttribute("class", "spans")
    for (let i = pageStart; i <= pageEnd; i++) {
        let nums = document.createElement("a")
        nums.innerText = i;
        nums.setAttribute("href", "/board?page="+i);
        spans.append(nums);
    }
    $("#btHere").append(spans);
    if (pageEnd < totalPage) {
        let after = document.createElement("a");
        after.setAttribute("value","다음");
        after.setAttribute("href","/board?page="+(pageStart+1));
        $("#btHere").append(after);
    }
}

