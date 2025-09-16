<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <link rel = "stylesheet" href="css/scoreView.css">
    <title>Green</title>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%
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

<section id = "scoreList">
    <h2>< <%=logId%> 님의 성적></h2><br>
    <form>
        <input type ="hidden" id ="code" value ="<%=log%>">
    </form>
</section>

<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/scoreView.js"></script>
</body>
</html>