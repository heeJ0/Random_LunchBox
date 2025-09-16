let logCode = String($("#code").val());
const requestData = {
    "usercode" : $("#code").val()
}
$.ajax({
    url: "/getScores",
    type: "post",
    data: JSON.stringify(requestData),
    contentType: "application/json",
    success: function (result) {
        const title = document.querySelector('h2');
        // scoreList.innerHTML = "";
        //<input type ="hidden" id ="code" value ="<%=log%>">
        let hidden = document.createElement('input');
        hidden.setAttribute("type","hidden");
        hidden.setAttribute("id","code");
        hidden.setAttribute("value",`${logCode}`);
        $("#scoreList").append(hidden);
        if(result.length === 0){
            title.innerText = "수강내역이 없습니다.";
        }
        else{
            for(let i = 0; i<result.length; i++){
                let sub = document.createElement('div');
                sub.setAttribute("id","sub");
                let subtitle = document.createElement('span');
                subtitle = result[i].title;
                let subScore = document.createElement('span');
                subScore.innerText = result[i].score;
                let grade = document.createElement('span');
                if(result[i].score >= 90 && result[i].score <= 100){
                    grade.innerText = "A";
                }
                else if(result[i].score >= 80 && result[i].score < 90){
                    grade.innerText = "B";
                }
                else if(result[i].score >= 70 && result[i].score < 80){
                    grade.innerText = "C";
                }
                else if(result[i].score >=60 && result[i].score < 70){
                    grade.innerText = "D";
                }
                else if(result[i].score >=1 && result[i].score < 60){
                    grade.innerText = "F";
                }
                else{
                    grade.innerText = "산출 전";
                }

                if(result[i].score > 60 && result[i].score%10 >= 7 || result[i].score == 100){
                    grade.innerText += "+";
                }
                sub.append(subtitle,": ",subScore,"점    |   ","학점: ",grade);
                $("#scoreList").append(sub);
            }
        }
    },
    error: function (result) {
        alert("error");
    }
})