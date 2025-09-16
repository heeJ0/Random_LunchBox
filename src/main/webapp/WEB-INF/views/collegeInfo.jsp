<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="shortcut icon" href="https://bit.ly/3P7ihIk">
    <link rel ="stylesheet" href ="css/collegeInfo.css">
    <title>Green</title>
</head>
<body>
<c:import url = "/WEB-INF/views/header.jsp"/>
<div id = "collegeText">
    <div class="collegeImg">
        <img src="image/bokk.jpg"  class="colImg" alt="" >
        <h1 class="colInfo">학교 소개</h1>
    </div>
    <br>
    <section id="information">
        <div id ="green">GREEN UNIVERSITY</div><br>
        그린대학교의 홈페이지를 방문해 주신 여러분을 환영합니다.<br><br>

        저는 그린대학교의 총장으로서 이 시대 교육의 방향을 '공동체적 자아를 보유한 혁신 리더'를 육성하는 것으로 집중할 계획입니다.<br>
        이기심이 경제사회적 발전의 원동력이 아니라, 공동의 번영이 우리가 함께 추구하는 방향이 되도록 담론을 주도해 가겠습니다.<br><br>

        이를 위해서 교육은 최첨단 기술과 학습 시스템을 활용하여 보다 입체적인 방식으로 혁신하도록 하겠습니다.<br>
        창의적이고 독보적인 지식과 기술이 이 캠퍼스에서 더 많이 창출될 수 있도록 행정, 공간, 제도적 뒷받침 역시 개선해 나아가겠습니다.<br><br>

        대학은 공공재를 생산하는 곳임을 저는 잘 인식하고 있습니다.<br>
        그린은 설립 당시부터 기독교적 사랑의 정신을 토대로 진리와 자유의 비전을 구현하고자 노력하여 왔습니다.<br><br>

        알렌과 언더우드 선교사가 오랜 항해 끝에 이 땅에 첫발을 내디뎠을 때, 그들은 모두 26세였습니다.<br>
        그들의 비전과 영혼이 깃들어 있는 그린은 그래서 영원히 26세의 심장을 가진 개척자일 수밖에 없습니다.<br><br>

        본인은 2020년 2월 1일 그린대학교의 19대 총장으로 취임하며, 이 배를 새로운 미래로 이끌어가고자 합니다.<br>
        새로운 그린을 향한 저의 도전과 개척에 모두 함께 해 주실 것을 기대합니다.<br><br>

        고맙습니다.<br>
    </section>
    <aside id="aside1"></aside>
    <aside id="aside2"></aside>
</div>
<div id="teamInfo">
    <h1>팀원 소개</h1>

    <div class = "info" id = "jeong">
        <img class = "img" src = "./image/하늘.jpg">
        <section class = "team">
            <div class = "name">정하늘</div><br>
            <div class = "address">✉ dorothy_0422@naver.com | ☎ 010-3028-0218</div><br>
            <div class = "part">팀장 | 게시 관리자<br><br>
                · 게시판 관리 <br>
                · 게시글 작성 | 게시글 삭제<br>
                · 게시글 수정<br>
                · 게시글 조회<br>
            </div><br>
        </section>
    </div>

    <div class = "info2" id ="jo">
        <img class = "img" src = "./image/현희.jpg">
        <section class = "team">
            <div class = "name">조현희</div><br>
            <div class = "address">✉ bbanana@kakao.com | ☎ 010-4506-7082</div><br>
            <div class = "part">서기 | 수강 관리자<br><br>
                수강 신청 | 수강 관리 ·<br>
                학과 별 강의목록 조회 ·<br>
                수강신청 현황(시간표) 조회 ·<br>
                성적 수정 ·</div><br>
        </section>
    </div>

    <div class = "info" id ="lee">
        <img class = "img" src = "./image/인성.JPG">
        <section class = "team">
            <div class = "name">이인성</div><br>
            <div class = "address">✉ insung1522@naver.com | ☎ 010-4655-2850</div><br>
            <div class = "part">팀원 | 성적, TODO 관리자<br><br>
                · 성적 관리<br>
                · 성적입력(교직원)<br>
                · 성적조회(교직원/학생)<br>
                · (마이페이지) TODO 관리</div><br>

        </section>
    </div>

    <div class = "info2" id = "hong">
        <img class = "img" src = "./image/성현.jpg">
        <section class = "team">
            <div class = "name">홍성현</div><br>
            <div class = "address">✉ dmdmdm1002@naver.com | ☎ 010-3058-5532</div><br>
            <div class = "part">팀원 | 회원 관리자<br><br>
                회원 관리 ·<br>
                회원 가입 | 회원 탈퇴 | 회원정보 수정 ·<br>
                로그인 | 로그아웃 ·<br>
                마이페이지 ·</div><br>
        </section>
    </div>
</div>
<c:import url = "/WEB-INF/views/footer.jsp"/>
</body>
</html>