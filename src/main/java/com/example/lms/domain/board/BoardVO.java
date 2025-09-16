package com.example.lms.domain.board;

import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.util.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardVO extends Timestamp {
    @Id
    private int board_code;
    @Column
    private String title;
    @Column
    private String contents;
    @Column
    private int usercode;
    @Column
    private char grade;
    @Column
    private int view_cnt;

    @Column
    private  String name;
    public BoardVO(BoardDTO dto){
        this.board_code = dto.getBoard_code();
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.usercode = dto.getUsercode();
        this.grade = dto.getGrade();
        this.view_cnt = dto.getView_cnt();
        this.name = dto.getName();
    }

    public void updateBoard(BoardDTO dto){
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }
}