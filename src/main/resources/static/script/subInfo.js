$.ajax({
    url : "/majorList",
    type : "POST",
    data : JSON.stringify(),
    contentType : "application/json"
}).done(result =>{

    for(let i=0; i<result.length; i++){
        let option = document.createElement("option");
        option.setAttribute("value", result[i]);
        option.innerText = result[i];
        $('#major').append(option);
    }
}).fail(erorr =>{
    console.log(erorr.responseText);
})
const  requestData = {
    "major" : "컴퓨터공학"
}
$.ajax({
    url : "/getSub",
    type : "POST",
    data : JSON.stringify(requestData),
    contentType : "application/json"
}).done(result =>{

    $("#subject").find("section").remove();
    $("#subject").find("h1").remove();
    for(let i=0; i<result.length; i++){
        //섹션 만들기
        let section = document.createElement("section");
        //  let division = document.querySelector("#textInfo");
        section.setAttribute("value", result[i].title);
        section.setAttribute("class","sub")

        let img = document.createElement("img");
        img.setAttribute("src",result[i].thumbnail);
        //img.setAttribute("style","width:100%; height:100%;");

        let div = document.createElement("div");
        div.setAttribute("class","info");
        //div (title명)
        let div_title = document.createElement("div");
        //div_title.setAttribute("style","font-size:35px; ");
        div_title.setAttribute("id","title");
        div_title.innerText = "강의명 : "+result[i].title;
        // 교수명
        let div_p_name = document.createElement("div");
        div_p_name.setAttribute("id","name");
        div_p_name.innerText = "담당 교수 : "+result[i].p_name;
        // 강의시간
        let div_runtime = document.createElement("div");
        div_runtime.innerText = "강의 시간 : "+result[i].runtime +"시간";
        div_runtime.setAttribute("id","runtime");
        // 강의소개
        let div_content = document.createElement("div");
        div_content.setAttribute("id","textInfo");
        div_content.innerText = "강의 소개 : "+ result[i].content;
        let br = document.createElement("br");
        section.appendChild(img);
        div.append(div_title);
        div.append(div_p_name);
        // div.append(div_runtime,br);
        div.append(div_runtime);
        div.append(div_content);
        section.appendChild(div);

        $("#subject").append(section);
    }

}).fail(erorr =>{
    console.log(erorr.responseText);
})

function callSub(){
    const  requestData = {
        "major" : $("#major").val()
    }
    $.ajax({
        url : "/getSub",
        type : "POST",
        data : JSON.stringify(requestData),
        contentType : "application/json"
    }).done(result =>{

        $("#subject").find("section").remove();
        $("#subject").find("h1").remove();
        for(let i=0; i<result.length; i++){
            //섹션 만들기
            let section = document.createElement("section");
            //  let division = document.querySelector("#textInfo");
            section.setAttribute("value", result[i].title);
            section.setAttribute("class","sub")

            let img = document.createElement("img");
            img.setAttribute("src",result[i].thumbnail);
            //img.setAttribute("style","width:100%; height:100%;");

            let div = document.createElement("div");
            div.setAttribute("class","info");
            //div (title명)
            let div_title = document.createElement("div");
            //div_title.setAttribute("style","font-size:35px; ");
            div_title.setAttribute("id","title");
            div_title.innerText = "강의명 : "+result[i].title;
            // 교수명
            let div_p_name = document.createElement("div");
            div_p_name.setAttribute("id","name");
            div_p_name.innerText = "담당 교수 : "+result[i].p_name;
            // 강의시간
            let div_runtime = document.createElement("div");
            div_runtime.innerText = "강의 시간 : "+result[i].runtime +"시간";
            div_runtime.setAttribute("id","runtime");
            // 강의소개
            let div_content = document.createElement("div");
            div_content.setAttribute("id","textInfo");
            div_content.innerText = "강의 소개 : "+ result[i].content;
            let br = document.createElement("br");
            section.appendChild(img);
            div.append(div_title);
            div.append(div_p_name);
            // div.append(div_runtime,br);
            div.append(div_runtime);
            div.append(div_content);
            section.appendChild(div);

            $("#subject").append(section);
        }

    }).fail(erorr =>{
        console.log(erorr.responseText);
    })
}