package com.example.lms.domain.TimeTable;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name="time_table")
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class TimeTableVO {
    @Id
    private int time_code;

    private int p_code, subcode, usercode,score;
    private String title,sub_schedule;

    public TimeTableVO(TimeTableDTO dto){
        this.p_code = dto.getP_code();
        this.subcode = dto.getSubcode();
        this.usercode = dto.getUsercode();
        this.title = dto.getTitle();
        this.sub_schedule = dto.getSub_schedule();
        this.score = dto.getScore();
    }

    public void setScore(int score){
        this.score = score;
    }
}