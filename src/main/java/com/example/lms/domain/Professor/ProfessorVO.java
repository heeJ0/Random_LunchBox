package com.example.lms.domain.Professor;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name="professor")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProfessorVO {
    @Id
    private int usercode;
    @Column(name="grade", nullable = false)
    private String grade;

    @Column(name="major", nullable = false)
    private String major;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="id", nullable = false)
    private String id;

    @Column(name="pw", nullable = false)
    private String pw;

    @Column(name="subcode", nullable = false)
    private int subcode;


    public ProfessorVO(ProfessorDTO dto){
        this.usercode = dto.getUsercode();
        this.grade =dto.getGrade();
        this.major =dto.getMajor();
        this.name = dto.getName();
        this.id = dto.getId();
        this.pw = dto.getPw();
        this.subcode = dto.getSubcode();
    }
}