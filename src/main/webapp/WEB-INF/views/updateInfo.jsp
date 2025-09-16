<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<html>
<head>
    <title>Green</title>
    <link rel = "stylesheet" href="css/updateInfo.css">
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%String logId = String.valueOf(session.getAttribute("logId"));
%>
회원정보수정
<%--전화번호, 주소 , 비밀번호 --%>
<aside id="aside1">
    <%--    어사이드에 성적조회 / 시간표조회 / 투두리스트조회 이동--%>
    <%--    <button onclick = "location.href='/todo'">TODO 리스트</button>--%>

    <a style = "color:black;" href = "/todo">&nbsp;· TODO LIST</a><br>
    <a style = "color:black;" href = "/scoreView">&nbsp;· 성적 조회 </a><br>
    <a style = "color:black;" href = "/leave">&nbsp;· 회원 탈퇴 </a><br>

</aside>
<aside id="aside2">

</aside>
<form id="userInfo">
    <h1>회원정보 수정</h1><br><br>
    이름<br>
    <input type = "text" name = "name" id ="name" required  readonly><br><br>
    생년월일<br>
    <input type = "text" name = "birth" id ="birth" required readonly><br><br>
    학과<br>
    <input type = "text" name = "major" id ="major" required readonly><br><br>
    아이디<br>
    <input type = "text" name = "id" id = "id" required value="<%=logId%>" readonly><br><br>
    비밀번호 < 수정가능 ><br>
    <input type = "password" name = "pw" id = "pw" required><br><br>
    비밀번호 재확인 < 수정가능 ><br>
    <input type = "password" name = "repw" id = "repw" required><br><br>
    주소 < 수정가능 > <br>
    <input type="text" id="address" placeholder="주소"><br><br>
    휴대전화 < 수정가능 > <br>
    <input type = "text" name ="mobile" id = "mobile" required placeholder="010-0000-0000" ><br><br>
    <%-- 성별--%>
    <input type="hidden" name="gender" id="gender" >
    <%--   userCode--%>
    <input type="hidden" name="userCode" id="userCode" >

    <input type="button"id = "update" value="수정하기" onclick="updateUserInfo()">

</form>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/updateInfo.js"></script>

</body>
</html>