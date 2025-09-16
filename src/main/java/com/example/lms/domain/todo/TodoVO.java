package com.example.lms.domain.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
@Table(name="todo")
public class TodoVO {
    @Id
    private int todoCode;
    @Column(name ="userCode", nullable = false)
    private int userCode;
    @Column(name ="contents", nullable = false)
    private String contents;
    @Column(name="checked", nullable = false)
    private String checked;

    public TodoVO(TodoRequestDTO dto){
        this.userCode = dto.getUserCode();
        this.todoCode = dto.getTodoCode();
        this.contents = dto.getContents();
        this.checked = dto.getChecked();

    }

}