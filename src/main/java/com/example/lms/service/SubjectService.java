package com.example.lms.service;

import com.example.lms.domain.subject.SubjectRepository;
import com.example.lms.domain.subject.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List getSub(){
        List<SubjectVO> temp = subjectRepository.findAll();
        return temp;
    }


}