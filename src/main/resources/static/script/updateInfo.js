let requestData = {
    "id" : $("#id").val(),
}
$.ajax({
    url : "/user",
    type : "POST",
    data : JSON.stringify(requestData),
    contentType : "application/json"
}).done(result =>{

    let form = document.getElementById("userInfo");

    //userCode 넣어주기
    let userCode = document.getElementById("userCode");
    userCode.setAttribute("value", result.usercode);


    //id 넣어주기
    let id = document.getElementById("id");
    id.setAttribute("value", result.id);

    //name 넣어주기
    let name = document.getElementById("name");
    name.setAttribute("value", result.name);

    //birth 넣어주기
    let birth = document.getElementById("birth");
    birth.setAttribute("value", result.birth.substring(0,10));

    //major 넣어주기
    let major = document.getElementById("major");
    major.setAttribute("value", result.major);

    //pw & repw 넣어주기
    let pw = document.getElementById("pw");
    let repw = document.getElementById("repw");
    pw.setAttribute("value", result.pw);
    repw.setAttribute("value", result.pw);

    //address 넣어주기
    let address = document.getElementById("address");
    address.setAttribute("value", result.address);

    //mobile 넣어주기
    let mobile = document.getElementById("mobile");
    mobile.setAttribute("value", result.mobile);

    //mobile 넣어주기
    let gender = document.getElementById("gender");
    gender.setAttribute("value", result.gender);


    // $('#form').append(option);

}).fail(erorr =>{
    console.log(erorr.responseText);
})

function updateUserInfo(){
    let pw=$("#pw").val();
    let repw=$("#repw").val();
    if(pw===repw && pw !==""){
        let requestData = {
            "usercode" : $("#userCode").val(),
            "grade" :$("#grade").val(),
            "name" : $("#name").val(),
            "id" : $("#id").val(),
            "pw" : $("#pw").val(),
            "address" : $("#address").val(),
            "mobile" :$("#mobile").val(),
            "gender" :$("#gender").val(),
            "birth" :$("#birth").val(),
            "major" :$("#major").val()
        }
        $.ajax({
            url :"/updateUser",
            type: "post",
            data: JSON.stringify(requestData),
            contentType: "application/json"
        }).done(result =>{

            if(result == true) {
                alert("수정완료");
                location.href="/studentMain";
            }
            else{
                alert("수정실패");
                location.href="/updateInfo";
            }
        }).fail(erorr =>{
            console.log(erorr.responseText);
        })
    }
    else{
        alert("비밀번호를 확인하고 다시 입력해주세요.");

    }

}