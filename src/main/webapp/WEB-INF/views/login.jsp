<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>Green</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>

<div class="wrapper">
    <input class="radio" id="one" name="group" type="radio" checked />
    <input class="radio" id="two" name="group" type="radio" />


    <div class="tabs">
        <label class="tab" id="one-tab" for="one">학생</label>
        <label class="tab" id="two-tab" for="two">교수</label>

    </div>

    <div class="panels">
        <h1 style="text-align: center">LOGIN</h1>
        <form>

            <input type = "text" name = "id" id = "id" placeholder="ID">
            <input type = "password" name = "pw" id = "pw" placeholder="PW">
            <div id = "btns">
                <div class="panel" id="one-panel">
                    <input type ="button" id="loginBtn1" value ="로그인" onclick="login()">
                </div>

                <div class="panel" id="two-panel">
                    <input type ="button" id="loginBtn2" value ="로그인" onclick="professorLogin()">
                </div>
                <input type = "button" id="goBackBtn" value ="뒤로가기" onclick="location.href='/'">
            </div>
        </form>
    </div>
</div>
<aside id="aside1"></aside>
<aside id="aside2"></aside>
<c:import url = "/WEB-INF/views/footer.jsp"/>
</body>
<script type="text/javascript" src="/script/login.js"></script>
</html>