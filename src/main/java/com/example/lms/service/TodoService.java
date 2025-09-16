package com.example.lms.service;

import com.example.lms.domain.todo.TodoRepository;
import com.example.lms.domain.todo.TodoRequestDTO;
import com.example.lms.domain.todo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoVO> readTodoList(@RequestBody TodoRequestDTO todoRequestDTO){
        System.out.println(todoRequestDTO.getUserCode());
        List<TodoVO> result = todoRepository.findByCode(todoRequestDTO.getUserCode());
        //List<TodoVO> result = todoRepository.findByCode(1005);
        if(result.isEmpty()){
            System.out.println("결과없음");
            return null;
        }
        else {
            System.out.println("가져옴");
        }
        return result;
    }

    public void addTodoList(@RequestBody TodoRequestDTO todoRequestDTO){
        TodoVO todoVO = new TodoVO(todoRequestDTO);
        todoRepository.save(todoVO);
    }

    //체크 y 로 변경
    @Transactional
    public void checkTodoListY(@RequestBody TodoRequestDTO todoRequestDTO){
        TodoVO todoVO = new TodoVO(todoRequestDTO);
        System.out.println(todoVO.getTodoCode());
        todoRepository.updateTodoCheckedY(todoVO.getTodoCode());
    }


    //체크 n 로 변경
    @Transactional
    public void checkTodoListN(@RequestBody TodoRequestDTO todoRequestDTO){
        TodoVO todoVO = new TodoVO(todoRequestDTO);
        System.out.println(todoVO.getTodoCode());
        todoRepository.updateTodoCheckedN(todoVO.getTodoCode());
    }


    public void deleteTodoList(@RequestBody TodoRequestDTO todoRequestDTO){
        TodoVO todoVO = new TodoVO(todoRequestDTO);
        todoRepository.deleteById(todoVO.getTodoCode());

    }


}