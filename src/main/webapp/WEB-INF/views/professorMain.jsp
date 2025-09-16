<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<html>
<head>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <link rel = "stylesheet" href = "css/professorMain.css">
    <title>Professer Mypage</title>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%
    String log = String.valueOf(session.getAttribute("log"));
    if(log == null){
        out.print("<script>alert('로그인 후 이용가능합니다'); location.href='/login';</script>");
        //        로그 없으면 로그인페이지로 이동
    }
%>
<aside>
    <%--    어사이드에 강의정보(성적입력)--%>

    <a id="menu_l" style = "color:black;" onclick=" getInfo()">&nbsp;· 강의정보</a><br>

</aside>
<section id="pagedefault">
</section>
<section id="classinfo" style="display: none">
    <span>강의명 : <p id="title_name"></p></span>
    <form>
        <table>
            <input type ="hidden" id = "stLog" value="<%=log%>">
            <thead>
            <tr><td id="stucode">학생코드</td><td id="major">전공</td><td id="name">이름</td><td id="level">학년</td><td id="score">성적</td><td id="s_grade">학점</td></tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <input id="saveBT" type="button" value="저장하기" onclick="setScore()">
    </form>
</section>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/professorMain.js"></script>
</body>
</html>