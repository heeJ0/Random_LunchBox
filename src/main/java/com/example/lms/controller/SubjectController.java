package com.example.lms.controller;

import com.example.lms.domain.subject.SubjectVO;
import com.example.lms.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/majorList")
    public ArrayList getMajor(){
        List<SubjectVO> temp = subjectService.getSub();
        ArrayList<String> subList = new ArrayList<>();
        int cnt = 0;
        subList.add(temp.get(cnt).getMajor());
        for(int i=1; i<temp.size(); i++){
            if(!subList.get(cnt).equals(temp.get(i).getMajor())){
                subList.add(temp.get(i).getMajor());
                cnt ++;
            }
        }
        System.out.println(subList.size());

        return subList;
    }

    @PostMapping("/getSub")
    public ArrayList getSubject(@RequestBody SubjectVO vo){
        List<SubjectVO> temp = subjectService.getSub();
        ArrayList<SubjectVO> subList = new ArrayList<>();
        for(int i=0; i<temp.size(); i++){
            if(vo.getMajor().equals(temp.get(i).getMajor())){
                subList.add(temp.get(i));
            }
        }
        return subList;
    }

}