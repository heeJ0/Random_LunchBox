package com.example.lms.domain.board;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardDTO {
    private int board_code;
    private String title;
    private String contents;
    private int usercode;
    private char grade;
    private int view_cnt;

    private  String name;
}
