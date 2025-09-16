package com.example.lms.controller;

import com.example.lms.domain.TimeTable.TimeTableDTO;
import com.example.lms.domain.TimeTable.TimeTableVO;
import com.example.lms.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeTableController {
    @Autowired
    private TimeTableService timeTableService;

    @PostMapping("/saveTime0")
    public void savaTime(@RequestBody TimeTableDTO dto){
        timeTableService.saveTime(dto);
    }

    @DeleteMapping("/delTime0")
    public void  delTime(@RequestBody TimeTableDTO dto){
        List<TimeTableVO> temp = timeTableService.showTime();
        for(int i=0; i<temp.size(); i++){
            if(dto.getUsercode() == temp.get(i).getUsercode() && dto.getSubcode() == temp.get(i).getSubcode()){
                timeTableService.delTime(temp.get(i).getTime_code());
            }
        }
    }

    @PostMapping("/showTime0")
    public ArrayList showTime(@RequestBody TimeTableDTO dto){
        ArrayList<TimeTableVO> schedule = new ArrayList<>();
        List<TimeTableVO> temp = timeTableService.showTime();
        for(int i=0; i<temp.size(); i++){
            if(dto.getUsercode() == temp.get(i).getUsercode()){
                schedule.add(temp.get(i));
            }
        }
        return schedule;
    }

    @PostMapping("/setScore")
    public void setScore(@RequestBody TimeTableDTO dto){
//        TimeTableVO stu = timeTableService.findTime(dto.getUsercode(), dto.getP_code());
//        TimeTableVO temp = new TimeTableVO(stu,dto.getScore());
        timeTableService.setScore(dto);
    }

    @PostMapping("/getScores")
    public List<TimeTableVO> getScores(@RequestBody TimeTableDTO dto){
        List<TimeTableVO> list = timeTableService.getScore(dto);
        return list;
    }
}