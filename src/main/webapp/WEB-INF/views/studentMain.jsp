<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<html>
<head>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <link rel = "stylesheet" href = "css/studentMain.css">
    <title>Green</title>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%
    String logId = String.valueOf(session.getAttribute("logId"));
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
<section>
    <form>
        <input type ="hidden" id = "stLog" value="<%=logId%>">
    </form>
    <h1 style="text-align: center"> < 내 정보 > </h1>
    <div id = "id">ID : &nbsp;</div>
    <div id = "name">NAME : &nbsp;</div>
    <div id = "birth">BIRTH : &nbsp;</div>
    <div id = "major">MAJOR : &nbsp;</div>
    <div id = "address">ADDRESS : &nbsp;</div>
    <div id = "mobile">MOBILE : &nbsp;</div>
    <button onclick="location.href='/updateInfo'">UPDATE</button>
</section>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/stuMypage.js"></script>
</body>
</html>