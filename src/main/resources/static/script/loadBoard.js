//게시글 불러오기 + 삭제

let requestData = {
    "board_code" : $("#boardcode").val(),
    "view_cnt" : $("#view_cnt").val()
}
$.ajax({
    url:"/loadBoard",
    type:"POST",
    data: JSON.stringify(requestData),
    contentType: "application/json",
    success: function(result) {

        $("#title2").val(result.title);
        $("#content2").val(result.contents);
        if (String(result.usercode) === $("#usercode2").val()) {
            $('#buttons').append(
                $(document.createElement('input')).prop({
                    type:'submit',
                    id:'submit2',
                    value:'수정하기'
                })
            );
            $('#buttons').append(
                $(document.createElement('input')).prop({
                    type: 'button',
                    id: 'delete2',
                    value: '삭제하기'
                })
            );
            $("#delete2").click(function(){
                deleteBoard()
            })
        }
    },
    error: function (result) {
        alert("시스템 에러 발생\n관리자 문의 바랍니다.");
    }
})

// 조회수 올려주기
let requestData2 = {
    "boardcode" :$('#boardcode').val()
}
$.ajax({
    url : "/viewcount",
    type: "PUT",
    data: JSON.stringify(requestData),
    contentType: "application/json",
    success: function(result){},
    error: function(result){
        alert('조회수 갱신 실패')
    }
})

function deleteBoard(){
    let requestData = {
        "board_code": $("#boardcode").val()
    }
    $.ajax({
        url:"/deleteBoard",
        type: "POST",
        data: JSON.stringify(requestData),
        contentType: "application/json",
        success: function(result){
            alert("게시글 삭제 완료")
            location.href = "/board";
        },
        error: function(result){
            alert("게시글 삭제 실패")
        }
    })
}