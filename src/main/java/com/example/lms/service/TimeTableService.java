package com.example.lms.service;

import com.example.lms.domain.TimeTable.TimeTableDTO;
import com.example.lms.domain.TimeTable.TimeTableRepository;
import com.example.lms.domain.TimeTable.TimeTableVO;
import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.domain.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TimeTableService {
    @Autowired
    private TimeTableRepository timeTableRepository;

    //시간표 저장
    public void saveTime(TimeTableDTO dto){
        TimeTableVO vo = new TimeTableVO(dto);
       /* System.out.println(vo.getSubcode());
        System.out.println(vo.getUsercode());
        System.out.println(vo.getSub_schedule());
        System.out.println(vo.getTitle());
        System.out.println(vo.getP_name());*/
        timeTableRepository.save(vo);
    }

    //시간표 삭제
    public void delTime(int time_code){
        timeTableRepository.deleteById(time_code);
    }

    //시간표 불러오기
    public List showTime(){
        List<TimeTableVO> temp = timeTableRepository.findAll();
        return temp;
    }

    //시간표 하나 코드로 조회
    public TimeTableVO findTime(int stucode, int p_code){
        TimeTableVO temp = timeTableRepository.findByStu(stucode,p_code);
        return temp;
    }

    //성적 수정
    public TimeTableVO setScore(@RequestBody TimeTableDTO dto){
        TimeTableVO stu = timeTableRepository.findByStu(dto.getUsercode(), dto.getP_code());
        stu.setScore(dto.getScore());
        timeTableRepository.save(stu);

        return stu;
    }

    public List<TimeTableVO> getScore(@RequestBody TimeTableDTO dto){
        List<TimeTableVO> list = timeTableRepository.findByUserCode(dto.getUsercode());
        return list;
    }

}