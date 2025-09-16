<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel = "stylesheet" href="css/board.css">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>Green</title>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
</head>
<body>
<%
    Object log = session.getAttribute("log");
    Object logId = session.getAttribute("logId");
    Object userName = session.getAttribute("userName");

    String pageTemp = (String)request.getParameter("page");

%>
<input type="hidden" id="hide" value="<%=pageTemp%>">
<c:import url = "/WEB-INF/views/header.jsp"/>
<div id = "content">
    <h1 style ="text-align: center;">게시판</h1>
    <%
        if(log != null){
    %>
    <button id = "ok" onclick="location.href='/boardWrite'">게시글 작성</button>
    <%}%>
    <input type = "hidden" id = "userId" value = <%=logId%> >
    <input type = "hidden" id = "userName" value = <%=userName%> >
    <section id = "boardList" style="color: black">
        <%--        해당 섹션에 게시글 태그 추가--%>
        <table border="1px">
            <thead>
            <tr><td>no</td><td>제목</td><td>작성자</td><td>조회수</td><td>게시일</td><td>수정일</td></tr>
            <tr id= "head_tr">
                <td>공지</td>
                <td><a id="head_title" style="color:black;"></a></td>
                <td id="head_name"> </td>
                <td id="head_view"> </td>
                <td id="head_date"> </td>
                <td id="head_modified"> </td>
            </tr>
            </thead>
            <tbody id ="here">
            </tbody>
        </table>
    </section>
</div>
<div id="btHere"></div>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/board.js?ver=1"></script>
</body>
</html>