<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel = "stylesheet" href="css/write.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>Green</title>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
</head>
<body>
<%
    Object log = session.getAttribute("log");

    Object userName = session.getAttribute("userName");
%>
<c:import url = "/WEB-INF/views/header.jsp"/>
<form id = "writeForm">
    <input type = "hidden" id = "userName" value = <%=userName%> >
    <input type = "text" id = "title" name = "title" placeholder="제목을 입력하세요." required><br>
    <textarea name = "content" id = "content" placeholder="내용을 입력하세요." required></textarea><br>
    <div id = "buttons">
    <input type ="button" value = "작성하기" id = "submit" onclick="boardW()">
    <input type = "button" value = "뒤로가기" id = "back" onclick="location.href = '/board'">
    </div>
    <input type = "hidden" id = "usercode" value ="<%=log%>">
</form>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/board.js?ver=123"></script>
</body>
</html>
