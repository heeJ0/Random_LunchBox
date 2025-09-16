<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Green</title>
    <link rel ="stylesheet" href ="css/addLecture.css">
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%
    Object log = session.getAttribute("log");
    if(log == null){
        out.print("<script>alert('로그인 후 이용가능합니다'); location.href='/login';</script>");
        //        로그 없으면 로그인페이지로 이동
    } else {
        String stLog = String.valueOf(log);
        if(stLog.length() == 2){
            out.print("<script>alert('교수님은 이용하실 수 없습니다'); location.href='/';</script>");
        }
    }
%>
<input type="hidden" id="hide" value="<%=log%>">
<div class="addLecture" >
    <img src="image/bokk.jpg"  class="addlectureImg" alt="" >
    <h1 class="addlectureInfo">수강 신청</h1>
</div>
<div id = "lecture_set">
    <div id="part1">
        <div id="addschedule">
            <%--전공--%>
            <select id="major" onchange="callSub()">
                <option></option>
            </select>
            <%--과목명--%>
            <select id="subject" onchange="colors()">
                <option></option>
            </select>
            <span id="hakjum">0</span>점
            <button id="move" onclick="checkGoIndex()">수강신청 완료</button>
            <%--메인으로 이동--%>
        </div>
        <span id="message">- 신청 강의목록(클릭시 삭제) -</span>
    </div>
    <section id="part2">
        <div id="time">
            <div></div><div id="MO">월</div><div id="TU">화</div><div id="WE">수</div><div id="TH">목</div><div id="FR">금</div>
            <div>9</div><div id="MO09"></div><div id="TU09"></div><div id="WE09"></div><div id="TH09"></div><div id="FR09"></div>
            <div>10</div><div id="MO10"></div><div id="TU10"></div><div id="WE10"></div><div id="TH10"></div><div id="FR10"></div>
            <div>11</div><div id="MO11"></div><div id="TU11"></div><div id="WE11"></div><div id="TH11"></div><div id="FR11"></div>
            <div>12</div><div id="MO12"></div><div id="TU12"></div><div id="WE12"></div><div id="TH12"></div><div id="FR12"></div>
            <div>13</div><div id="MO13"></div><div id="TU13"></div><div id="WE13"></div><div id="TH13"></div><div id="FR13"></div>
            <div>14</div><div id="MO14"></div><div id="TU14"></div><div id="WE14"></div><div id="TH14"></div><div id="FR14"></div>
            <div>15</div><div id="MO15"></div><div id="TU15"></div><div id="WE15"></div><div id="TH15"></div><div id="FR15"></div>
            <div>16</div><div id="MO16"></div><div id="TU16"></div><div id="WE16"></div><div id="TH16"></div><div id="FR16"></div>
            <div>17</div><div id="MO17"></div><div id="TU17"></div><div id="WE17"></div><div id="TH17"></div><div id="FR17"></div>
            <div>18</div><div id="MO18"></div><div id="TU18"></div><div id="WE18"></div><div id="TH18"></div><div id="FR18"></div>
        </div>
        <div id="schedule">
        </div>
    </section>
</div>
<div class="black_bg"></div>
<div class="modal_wrap">
    <div id="modal_text"></div>
    <input type="hidden" id="subcode">
    <input type="hidden" id="times">
    <button onclick="delOk()">삭제</button>
    <button onclick="delNo()">취소</button>
</div>
<c:import url = "/WEB-INF/views/footer.jsp"/>
<script src="script/addLecture.js"></script>
</body>
</html>