let logCode = String($("#code").val());
const requestData = {
    "userCode" : $("#code").val() // user_code아님
}
$.ajax({
    url: "/getTodo",
    type: "post",
    data: JSON.stringify(requestData),
    contentType: "application/json",
    success: function (result) {
        const todoList = document.querySelector('#todoList');
        todoList.innerHTML = "";
        // document.querySelector('#contents');
        //<input type ="hidden" id ="code" value ="<%=log%>">
        let hidden = document.createElement('input');
        hidden.setAttribute("type","hidden");
        hidden.setAttribute("id","code");
        hidden.setAttribute("value",`${logCode}`);
        $("#todoList").append(hidden);
        if(result.length === 0){
            $("#list").innerText = "todo 리스트를 추가해보세요.";
        }
        else{
            for(let i = 0; i<result.length; i++){

                let label = document.createElement('label');
                let br = document.createElement('br');
                let content = document.createElement('span');
                let checkbox = document.createElement('input');
                let delBtn = document.createElement('button');
                checkbox.setAttribute("type","checkbox");
                content.setAttribute("id", i+1);
                checkbox.setAttribute("onclick","checkClick(event)");
                if(result[i].checked == 'Y'){
                    checkbox.setAttribute("checked","checked");
                    content.setAttribute("style","text-decoration:line-through; color:gray;");
                }
                let stringi = String(result[i].todoCode);
                checkbox.setAttribute("value",`${stringi}`);
                checkbox.setAttribute("id","checkbox"+i);
                checkbox.setAttribute("name","done");
                content.innerText = `${i+1}. ` + result[i].contents;
                label.appendChild(content);
                label.appendChild(checkbox);
                //label.appendChild(br);
                delBtn.setAttribute("onclick","delTodo(event)");
                delBtn.setAttribute("value",`${stringi}`);
                delBtn.innerText = "삭제";
                delBtn.setAttribute("id",`${stringi}`);

                $("#todoList").append(label,delBtn,br);
            }
        }
    },
    error: function (result) {
        alert("error");
    }
})

// TODO
function  todoList() {
    let logCode = String($("#code").val());
    const requestData = {
        "userCode": $("#code").val() // user_code아님
    }
    $.ajax({
        url: "/getTodo",
        type: "post",
        data: JSON.stringify(requestData),
        contentType: "application/json",
        success: function (result) {
            const todoList = document.querySelector('#todoList');
            todoList.innerHTML = "";
            // document.querySelector('#contents');
            //<input type ="hidden" id ="code" value ="<%=log%>">
            let hidden = document.createElement('input');
            hidden.setAttribute("type", "hidden");
            hidden.setAttribute("id", "code");
            hidden.setAttribute("value", `${logCode}`);
            $("#todoList").append(hidden);
            if (result.length === 0) {
                $("#list").innerText = "todo 리스트를 추가해보세요.";
            } else{
                for(let i = 0; i<result.length; i++){

                    let label = document.createElement('label');
                    let br = document.createElement('br');
                    let content = document.createElement('span');
                    let checkbox = document.createElement('input');
                    let delBtn = document.createElement('button');
                    checkbox.setAttribute("type","checkbox");
                    content.setAttribute("id", i+1);
                    checkbox.setAttribute("onclick","checkClick(event)");
                    if(result[i].checked == 'Y'){
                        checkbox.setAttribute("checked","checked");
                        content.setAttribute("style","text-decoration:line-through; color:gray;");
                    }
                    let stringi = String(result[i].todoCode);
                    checkbox.setAttribute("value",`${stringi}`);
                    checkbox.setAttribute("id","checkbox"+i);
                    checkbox.setAttribute("name","done");
                    content.innerText = `${i+1}. ` + result[i].contents;
                    label.appendChild(content);
                    label.appendChild(checkbox);
                    //label.appendChild(br);

                    delBtn.setAttribute("onclick","delTodo(event)");
                    delBtn.setAttribute("value",`${stringi}`);
                    delBtn.innerText = "삭제";
                    delBtn.setAttribute("id",`${stringi}`);

                    $("#todoList").append(label,delBtn,br);
                }
            }
        },
        error: function (result) {
            alert("error");
        }
    })
}
function addTodo(){
    const requestData = {
        "userCode" : $("#code").val(),
        "contents" : $("#contents").val(),
        "checked" : 'N'
    }
    $.ajax({
        url: "/addTodo",
        type: "post",
        data: JSON.stringify(requestData),
        contentType: "application/json",
        success: function (result) {
            todoList();
        },
        error: function (result) {
            alert("error");
        }
    })
}

function delTodo(event) {
    let todoCode = event.target.value;

    const requestData = {
        // "userCode": $("#code").val(),
        "todoCode": todoCode
    }
    $.ajax({
        url: "/delTodo",
        type: "delete",
        data: JSON.stringify(requestData),
        contentType: "application/json",
        success: function (result) {
            todoList();
        },
        error: function (result) {
            console.log("del error");
        }
    })
}
function checkClick(event)  {
    let todoCode = event.target.value;
    if(event.target.checked)  {
        const requestData = {
            "userCode" : $("#code").val(),
            "todoCode" : todoCode
        }
        $.ajax({
            url: "/checkTodoY",
            type: "post",
            data: JSON.stringify(requestData),
            contentType: "application/json",
        }).done(result =>{
            todoList();
        })
    }else {
        const requestData = {
            "userCode" : $("#code").val(),
            "todoCode" : todoCode
        }
        $.ajax({
            url: "/checkTodoN",
            type: "post",
            data: JSON.stringify(requestData),
            contentType: "application/json",
        }).done(result =>{
            todoList();
        })
    }
}
function checkEnter(){
    if(window.event.keyCode ==13){
        addTodo();
    }
}