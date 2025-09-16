package com.example.lms.domain.TimeTable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TimeTableDTO {
    private int time_code;
    private int p_code, subcode, usercode,score;
    private String title,sub_schedule;
}