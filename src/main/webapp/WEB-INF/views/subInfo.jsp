<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Green</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <link rel = "stylesheet" href="css/subInfo.css">
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<select id="major" onchange="callSub()">

</select>
<section id="subject" >
    <%--    <h1 id="msg" style="text-align: center; justify-content: center;">학과를 선택해주세요.</h1>--%>
</section>
<aside id="aside1"></aside>
<aside id="aside2"></aside>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/subInfo.js"></script>
</body>
</html>