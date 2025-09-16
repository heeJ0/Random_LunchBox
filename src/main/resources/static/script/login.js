function login(){

    const requestData = {
        "id": $("#id").val(),
        "pw": $("#pw").val()
    }
    $.ajax({
        url: "/login",
        type: "post",
        data: JSON.stringify(requestData),
        contentType: "application/json",
        success: function (result) {
            if(result === "/") {
                alert("로그인 성공!")
                location.href='/';
            }
            else{
                alert("아이디와 비밀번호를 다시 확인하고 입력해주세요.")
                location.href='/login';
            }

        },
        error: function (result) {
            alert("아이디와 비밀번호를 다시 확인하고 입력해주세요.")
            location.href='/login';
        }
    })
}
function professorLogin(){

    const requestData = {
        "id": $("#id").val(),
        "pw": $("#pw").val()
    }
    $.ajax({
        url: "/ProfessorLogin",
        type: "post",
        data: JSON.stringify(requestData),
        contentType: "application/json",
        success: function (result) {
            if(result === "/") {
                alert("로그인 성공!")
                location.href='/';
            }
            else{
                alert("아이디와 비밀번호를 다시 확인하고 입력해주세요.")
                location.href='/login';
            }
        },
        error: function (result) {
            alert("아이디와 비밀번호를 다시 확인하고 입력해주세요.")
            location.href='/login';
        }
    })
}


function checkOnlyOne(element) {

    const checkboxes
        = document.getElementsByName("userCheck");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    element.checked = true;
}