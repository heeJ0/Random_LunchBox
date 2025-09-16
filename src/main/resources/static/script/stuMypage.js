let requestData = {
    "id" : $("#stLog").val()
}

$.ajax({
    url : "/user",
    type : "POST",
    data : JSON.stringify(requestData),
    contentType : "application/json"
}).done(result =>{
    let id = document.getElementById("id");
    let name = document.getElementById("name");
    let birth = document.getElementById("birth");
    let major = document.getElementById("major");
    let address = document.getElementById("address");
    let mobile = document.getElementById("mobile");
    id.innerText += result.id;
    name.innerText += result.name;
    let dateSplit = result.birth.split("-");
    let day = dateSplit[2].split("T");
    let intDay = parseInt(day);
    if((intDay) < 10){
        birth.innerText += dateSplit[0] + "년 " + dateSplit[1] + "월 0" +(intDay) +"일";
    }else{
        birth.innerText += dateSplit[0] + "년 " + dateSplit[1] + "월 " +(intDay+1) +"일";
    }
    major.innerText += result.major;
    address.innerText += result.address;
    mobile.innerText +=
        result.mobile;
})