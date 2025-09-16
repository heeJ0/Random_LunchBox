package com.example.lms.domain.Professor;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfessorDTO {
    private String grade,name,id,pw,major;
    private int usercode,subcode;
}