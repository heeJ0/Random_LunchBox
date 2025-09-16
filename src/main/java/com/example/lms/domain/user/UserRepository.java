package com.example.lms.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer> {

    @Query(value = "select * from student where id = ?1", nativeQuery = true)
    public List<UserVO> findByStringId(String id);

    @Query(value = "select * from student where userCode =?1 and pw =?2", nativeQuery = true)
    public List<UserVO> findByStringCodePw(int userCode, String pw);

}
