<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel = "stylesheet" href ="css/join.css">
    <title>Green</title>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<section id="join">
    <div id="joinForm">
        <h1 id="joinText">회원가입</h1>
        <form>
            이름<br>
            <input type = "text" name = "name" id ="name" required placeholder="name"><br><br>
            아이디<br>
            <input type = "text" name = "joinId" id = "joinId" required placeholder="id(2자 이상)"><br><br>
            <input type="hidden" id="chId">
            <p id="inuse" style="display:none; color:red; font-size: 8pt;">이미 사용중인 아이디입니다.</p>
            <p id="use" style="display:none; color:green; font-size: 8pt;">사용가능한 아이디입니다.</p>
            <br>

            비밀번호<br>
            <input type = "password" name = "pw" id = "pw" required placeholder="pw"><br><br>
            주소<br>
            <div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
                <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
            </div>
            <input type="text" id="postcode" placeholder="우편번호" style="width: 100%; height :50px;"><br>
            <input type="button" class="btn" onclick="execDaumPostcode()" value="우편번호 찾기" style="width: 200px; height :50px; margin-top: 5px"><br><br>
            <input type="text" id="address" placeholder="주소" style="width: 100%; height :50px;"><br>
            <input type="text" id="detailAddress" placeholder="상세주소" style="width: 100%; height :50px; margin-top: 5px"><br><br>

            성별<br>
            <select id = "gender">
                <option name = "none" value ="성별">성별</option>
                <option name = "Female" value ="F">여성</option>
                <option name = "Male" value ="M">남성</option>
            </select><br><br>
            전공<br>
            <select id = "major">
                <option name = "none" value ="none">전공선택</option>
                <option name = "business" value = "경영학">경영학과</option>
                <option name = "computer" value = "컴퓨터공학">컴퓨터공학과</option>
                <option name = "music" value = "실용음악">실용음악과</option>
                <option name = "korean" value = "국어국문학">국어국문학과</option>
            </select><br><br>
            휴대전화<br>
            <input type = "text" name ="mobile" id = "mobile" required placeholder="010-0000-0000"><br><br>
            생년월일<br>
            <input type = "date" name ="birth" id = "birth" required><br><br>
            <input type = "button" class="btn" value ="회원가입" onclick = "joinCheck()" ><br><br>
            <input type = "hidden" name ="grade" id = "grade" value ="S">
        </form>
    </div>
    <aside id="aside1"></aside>
    <aside id="aside2"></aside>
</section>

<c:import url = "/WEB-INF/views/footer.jsp"/>
</body>
<script type="text/javascript" src="/script/validation.js?ver=123"></script>
</html>