package com.example.lms.domain.Professor;

import com.example.lms.domain.user.UserVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository  extends JpaRepositoryImplementation <ProfessorVO, Integer> {

    @Query(value = "select * from professor where id = ?1", nativeQuery = true)
    public List<ProfessorVO> findByStringProfessorId(String id);

}