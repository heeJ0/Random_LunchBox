<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <link rel = "stylesheet" href="css/todo.css">
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <title>Green</title>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%
    //    session.setAttribute("log",7770);
//    int log = (int)session.getAttribute("log");
    Object log = session.getAttribute("log");
    Object logId = session.getAttribute("logId");
%>
<aside id="aside1">
    <%--    어사이드에 성적조회 / 시간표조회 / 투두리스트조회 이동--%>
    <%--    <button onclick = "location.href='/todo'">TODO 리스트</button>--%>

    <a style = "color:black;" href = "/todo">&nbsp;· TODO LIST</a><br>
    <a style = "color:black;" href = "/scoreView">&nbsp;· 성적 조회 </a><br>
    <a style = "color:black;" href = "/leave">&nbsp;· 회원 탈퇴 </a><br>

</aside>
<aside id="aside2">

</aside>
<h2 id = "userName">< <%=logId%> 님의 TODO LIST ></h2>
<section id = "list">
    <div id= "todoList">

    </div>
    <form id ="addTodoList">
        <input type ="hidden" id ="code" value ="<%=log%>">
        <input type="text" id="contents" name="contents" onkeyup="checkEnter()" autofocus/>
        <button onclick="addTodo()" style="height:35px; width:35px;">+</button>
    </form>
</section>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/todo.js"></script>
</body>
</html>