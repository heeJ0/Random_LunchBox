<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <%
        Object log = session.getAttribute("log");
        String str  ="login";

        String log2 = String.valueOf(log);
        if(!log2.equals(null)) str = "addLecture";

    %>
    <link rel ="stylesheet" href ="css/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>Green</title>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<%--<input type="hidden" id="hide" value="<%=log%>">--%>
<div class="slide">
    <div class="slides" >
        <input type="radio" id="ra01" name="ra" value="" checked>
        <input type="radio" id="ra02" name="ra" value="">
        <input type="radio" id="ra03" name="ra" value="">

        <div class="sl"  style="text-align: center; opacity: 100%;">
            <video src="image/ColVideo.mp4" class="colVideo" controls loop muted autoplay
                   height="1080px"></video>
            <h1 class="indexText">Where there is a will there is a way.</h1>
        </div>


        <div class="sl" style="text-align: center; opacity: 100%;">
            <a href = "/board"><img src="image/testInfo.png" alt="" height="550px"></a>
        </div>

        <div class="sl"  style="text-align: center; opacity: 100%;">
            <a href = "http://www.randommenu.site/"><img src="image/003.png" alt="" height="550px"></a>
        </div>

    </div>

    <div class="page">
        <label for="ra01">●</label>
        <label for="ra02">●</label>
        <label for="ra03">●</label>
    </div>
</div>

<section id = "last">
    <div id = "todo">
        <% if(log != null && String.valueOf(log).length() == 4){%> <a href = "/todo"><%}%><h2>My Todo</h2><% if(log != null && String.valueOf(log).length() == 4){%>   </a><%}%>
        <div id = "list">
            <form id = "todoList">
                <input type ="hidden" id ="code" value ="<%=log%>">
            </form>
        </div>
    </div>

    <a href ="/<%=str%>">
        <div id = "schedule">
        <div>  </div><div id="MO">월</div><div id="TU">화</div><div id="WE">수</div><div id="TH">목</div><div id="FR">금</div>
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
    </a>
    <aside>
        <img src="image/aside.jpg">
    </aside>
</section>
<c:import url = "/WEB-INF/views/footer.jsp"/>
</body>
<script src="script/index.js"></script>
</html>