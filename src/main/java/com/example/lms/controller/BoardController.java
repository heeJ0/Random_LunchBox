package com.example.lms.controller;

import com.example.lms.domain.board.BoardDTO;
import com.example.lms.domain.board.BoardVO;
import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.domain.user.UserVO;
import com.example.lms.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    // CRUD
    // 1. 게시글 작성 (create)
    @PostMapping("/boardWrite")
    public void write(@RequestBody BoardDTO dto){

        boardService.write(dto);
    }
    // 2. 게시글 조회 (read)
    @PostMapping("/boardList")
    public List getBoard(){
        List<BoardVO> temp = boardService.boardList();

        // HttpSession session = request.getSession();
        // session.setAttribute("boardcode",dto.getBoard_code());

        if(temp.size()==0) System.out.println("등록된 게시글 없음");
        return temp;
    }

    @PostMapping("/loadBoard")
    public Optional<BoardVO> loadBoard(@RequestBody BoardDTO dto){
        Optional<BoardVO> temp = boardService.loadBoard(dto);
        return temp;
    }

    // 작성자 코드 가져오기
    @PostMapping("/readBoard")
    public BoardVO getUserCode(@RequestBody BoardDTO dto) {
        BoardVO usercode = boardService.readBoard(dto);

        return usercode;
    }

    // 3. 게시글 수정 (update)
    @PostMapping("/updateBoard")
    public boolean update(@RequestBody BoardDTO dto){
        BoardVO bd = boardService.updateBoard(dto);
        return true;
    }

    // 4. 게시글 삭제 (delete)
    @PostMapping("/deleteBoard")
    public void deleteBoard(@RequestBody BoardDTO dto){
        boardService.deleteBoard(dto);
    }

    // 5. 조회수 증가
    @PutMapping("/viewcount")
    public int viewcount(@RequestBody BoardDTO dto){

        int cnt = boardService.viewcount(dto);

        System.out.println("이건뭐지?: "+cnt);
        return cnt;
    }

    @PostMapping("/readList")
    public List<BoardVO>  resdList(@RequestParam("start") int start){
        System.out.println(start);
        int end = start * 10;
        List<BoardVO> list = boardService.readList(start,end);
        return list;
    }

    @PostMapping("/getCnt")
    public int getCnt(){
        return boardService.getCnt();
    }

    // 공지사항
    @PostMapping("/getNotice")
    public BoardVO getNoptice(){
        return boardService.getNotice();
    }
}