package com.example.lms.service;

import com.example.lms.domain.board.BoardDTO;
import com.example.lms.domain.board.BoardRepository;
import com.example.lms.domain.board.BoardVO;
import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.domain.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    // 1.Controller 에서 Service로 가
    // 2. Service에서 Repository 활용해서 원하는 값을 DB에서 얻어옴 -> Controller 로 return 반환
    // 3. Controller 에서 받아온 return 값을 다시 주물러서 js 에서 씀
    @Autowired
    private BoardRepository boardRepository;

    public void write(BoardDTO dto) {
        BoardVO bd = new BoardVO(dto);
        boardRepository.save(bd);
    }

    public BoardVO readBoard(BoardDTO dto) {
        List<BoardVO> result = boardRepository.findByUsercode(dto.getUsercode());
        if (result.isEmpty()) return null;
        System.out.println("야 너 유저코드야!? " + result.get(4));
        return result.get(4);
    }

    // to get Board List
    public List boardList() {
        List<BoardVO> boardList = boardRepository.findAll();
        return boardList;
    }

    public Optional<BoardVO> loadBoard(BoardDTO dto) {
        Optional<BoardVO> temp = boardRepository.findById(dto.getBoard_code());

        return temp;
    }

    public void deleteBoard(BoardDTO dto){
        BoardVO bd = new BoardVO(dto);
        System.out.println("삭제되었습니다.");
        boardRepository.delete(bd);
    }

    public BoardVO updateBoard(BoardDTO dto){
        BoardVO bd = boardRepository.findById(dto.getBoard_code()).orElseThrow(
                () -> new IllegalArgumentException("으악!")
        );
        bd.updateBoard(dto);
        boardRepository.save(bd);
        return bd;
    }

    public int viewcount(BoardDTO dto){
        int bd = boardRepository.findByBc(dto.getView_cnt()+1, dto.getBoard_code());


        return bd;
    }

    //getList
    public List<BoardVO> readList(int start, int end){
        List<BoardVO> list = boardRepository.readlist(start,end);
        return  list;
    }

    //getCnt(총갯수)
    public int getCnt(){
        int temp = boardRepository.getCnt();
        return temp;
    }

    //get Notice
    public BoardVO getNotice(){
        BoardVO temp = boardRepository.getNotice();
        return temp;
    }
}