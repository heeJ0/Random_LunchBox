package com.example.lms.domain.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name="subject")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubjectVO {
    @Id
    private int subcode;

    private String major,p_name,title,content,thumbnail;
    private int runtime,p_code;
    private String sub_schedule;

}