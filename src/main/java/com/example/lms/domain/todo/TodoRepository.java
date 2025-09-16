package com.example.lms.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoVO, Integer> {
    @Query(value = "select * from todo where user_code = ?1", nativeQuery = true)
    public List<TodoVO> findByCode(int code);

//    UPDATE table_name SET name = '테스트 변경', country = '대한민국' WHERE id = 1105;

    @Modifying
    @Query(value = "update todo set checked ='Y' where todo_code =?1 " , nativeQuery = true)
    public void updateTodoCheckedY(int code);


    @Modifying
    @Query(value = "update todo set checked ='N' where todo_code =?1 " , nativeQuery = true)
    public void updateTodoCheckedN(int code);

}