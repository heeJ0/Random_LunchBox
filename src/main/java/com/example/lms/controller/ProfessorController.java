package com.example.lms.controller;

import com.example.lms.domain.Professor.ProfessorDTO;
import com.example.lms.domain.Professor.ProfessorVO;
import com.example.lms.domain.TimeTable.TimeTableVO;
import com.example.lms.domain.subject.SubjectVO;
import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.domain.user.UserVO;
import com.example.lms.service.ProfessorService;
import com.example.lms.service.SubjectService;
import com.example.lms.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private TimeTableService timeTableService;

    @Autowired
    private SubjectService subjectService;


    // subject에서 강의 목록 가져오기
    @PostMapping("/addPro")
    public List<SubjectVO> getMajor(){
        List<SubjectVO> temp = subjectService.getSub();
        return temp;
    }

    // 교수 테이블에 교수 추가해주기
    @PostMapping("/addProfe")
    public void addProfe(@RequestBody ProfessorDTO dto){
        professorService.addProfeList(dto);
    }

    //수강생 리스트 불러오기

    @PostMapping("/professor")
    public ProfessorVO getProfessor(@RequestBody ProfessorDTO professorDto){
        // 여기서
        System.out.println("getUser들어옴");
        ProfessorVO professor =  professorService.readProfessor(professorDto);
//        ProfessorDTO
        if(professor == null)
            System.out.println("NULL");
        return professor;
    }


    @PostMapping("/ProfessorLogin")
    public String login(@RequestBody ProfessorDTO professorDto, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfessorVO professor = getProfessor(professorDto);
        String url = "";
        if(professor.getPw().equals(professorDto.getPw())){
            System.out.println("로그인성공");
            url ="/";

            HttpSession session = request.getSession();
            session.setAttribute("log",professor.getUsercode());
            session.setAttribute("logId",professor.getId());
            session.setAttribute("userName",professor.getName());
        }
        else {
            System.out.println(professor.getPw());
            System.out.println(professorDto.getPw());
            url ="/login";
        }

        return url;
    }

    //수강생 리스트 불러오기
    @PostMapping("/proClassInfo")
    public ArrayList proClassInfo(@RequestBody ProfessorDTO dto){
        System.out.println(dto.getUsercode());
        //과목별 수강생 정보(usrcode) 불러오기
        List<TimeTableVO> temp = timeTableService.showTime();
        ArrayList<TimeTableVO> list = new ArrayList<>();
        for(int i=0; i<temp.size(); i++){
            if(dto.getUsercode() == temp.get(i).getP_code()){
                list.add(temp.get(i));
            }
        }
        //usercode를 기반으로 학생정보 불러오기
//        for(int i=0; i<list.size(); i++){
//        System.out.println(list.get(i));
//        }
        return list;
    }

    @PostMapping("/getPro")
    public ProfessorVO getPro(@RequestBody ProfessorDTO dto){
        // 여기서
        System.out.println("getPro");
        System.out.println(dto.getUsercode());
        ProfessorVO professor =  professorService.readPro(dto);
        System.out.println(professor.getMajor());
        return professor;
    }

}