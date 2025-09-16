package com.example.lms.domain.TimeTable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableVO, Integer> {

//    @Query(value = "update usercode set score=?1 where usercode = ?2", nativeQuery = true)
//    public TimeTableDTO findByStucode(int score,int usercode);

    @Query(value = "select * from time_table where usercode = ?1 and p_code=?2", nativeQuery = true)
    public TimeTableVO findByStu(int usercode, int p_code);

    @Query(value = "select * from time_table where usercode = ?1",nativeQuery = true)
    public List<TimeTableVO> findByUserCode(int usercode);

}