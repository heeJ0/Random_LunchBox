package com.example.lms.domain.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoRequestDTO {
    private int userCode;
    private int todoCode;
    private String contents;
    private String checked;
}