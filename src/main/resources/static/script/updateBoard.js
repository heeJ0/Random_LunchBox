// 게시글 수정
let requestData = {
    "board_code" : $("#boardcode").val()
}
$.ajax({
    url: "/loadBoard",
    type: "POST",
    data: JSON.stringify(requestData),
    contentType: "application/json",
    success: function (result) {
        $("#title").val(result.title);
        $("#content").val(result.contents);
    },
    error: function (result) {
        alert("우에에엥ㅠㅠ")
    }
})

function update(){
    let requestData = {
        "title": $("#title").val(),
        "contents": $("#content").val(),
        "board_code": $("#boardcode").val()
    }

    $.ajax({
        url:"/updateBoard",
        type: "POST",
        data: JSON.stringify(requestData),
        contentType: "application/json",
    }).done(result =>{
        if(result == true)
            alert("게시글 수정 완료")
        else
            alert("게시글 수정 실패")
        location.href = '/board';
    }).fail(error =>{
        console.log(error.responseText);
    })

}