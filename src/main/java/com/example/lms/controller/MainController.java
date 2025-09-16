package com.example.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping("/main")
    public String main(){
        return "studentMain";
    }

    @RequestMapping("/addLecture")
    public String addLecture(){
        return "addLecture";
    }

    @RequestMapping("/board")
    public String board(){
        return "board";
    }

    @RequestMapping("/boardWrite")
    public String boardWrite(){
        return "boardWrite";
    }

    @RequestMapping("/boardUpdate")
    public String boardUpdate(){
        return "boardUpdate";
    }

    @RequestMapping("/boardView")
    public String boardView(){
        return "boardView";
    }
    @RequestMapping("/collegeInfo")
    public String collegeInfo(){
        return "collegeInfo";
    }
    @RequestMapping("/join")
    public String join(){
        return "join";
    }
    @RequestMapping("/leave")
    public String leave(){
        return "leave";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/professorMain")
    public String professorMain(){
        return "professorMain";
    }
    @RequestMapping("/studentMain")
    public String studentMain(){
        return "studentMain";
    }
    @RequestMapping("/subInfo")
    public String subInfo(){
        return "subInfo";
    }
    @RequestMapping("/todo")
    public String todo(){
        return "todo";
    }
    @RequestMapping("/scoreView")
    public String scoreView(){return "scoreView";}
    @RequestMapping("/header")
    public String header(){
        return "header";
    }

    @RequestMapping("/footer")
    public String footer(){
        return "footer";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(){
        return "updateInfo";
    }




}