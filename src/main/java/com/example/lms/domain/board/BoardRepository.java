package com.example.lms.domain.board;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface BoardRepository extends JpaRepositoryImplementation<BoardVO, Integer> {

    @Query(value = "select * from board where usercode = ?1", nativeQuery = true)
    public List<BoardVO> findByUsercode(int usercode);

    @Query(value = "delete from board where board_code = ?1",nativeQuery = true)
    public int findByBoardcode(int board_code);

    //    @Query(value = "update board set title = ?1, contents = ?2 where board_code = ?3",nativeQuery = true)
//    public List<BoardVO> findByTC(String title, String contents, int board_code);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value ="update board set view_cnt = ?1 where board_code =?2",nativeQuery = true)
    public int findByBc(int view_cnt, int board_code);

    //게시판 최근순서대로 불러오기
    @Query (value = "select * from(select row_number() over (order by board_code desc) rownum,board_code,title,contents,usercode,grade,created_at,modified_at,view_cnt,name from board)t where t.rownum between ?1 and ?2",nativeQuery = true)
    public List<BoardVO> readlist(int start, int end);

    @Query(value = "select count(*) from board", nativeQuery = true)
    public int getCnt();

    //가장최근 공지사항 -> F등급이 작성한 가장 최근게시물
    @Query(value = "select * from board where grade='F' ORDER BY created_at desc limit 1", nativeQuery = true)
    public BoardVO getNotice();
}