package com.example.lms.service;

import com.example.lms.domain.Professor.ProfessorDTO;
import com.example.lms.domain.Professor.ProfessorRepository;
import com.example.lms.domain.Professor.ProfessorVO;

import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.domain.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;


    public void addProfeList(@RequestBody ProfessorDTO dto){
        ProfessorVO pro = new ProfessorVO(dto);
        professorRepository.save(pro);
    }



    public ProfessorVO readProfessor(ProfessorDTO ProfessorDto){
        List<ProfessorVO> result = professorRepository.findByStringProfessorId(ProfessorDto.getId());
        if(result.isEmpty())
            return null;
        return result.get(0);
    }


    public ProfessorVO readPro(ProfessorDTO dto){
        ProfessorVO result = professorRepository.findById(dto.getUsercode()).orElseThrow();
        System.out.println(result);
        return result;
    }

}