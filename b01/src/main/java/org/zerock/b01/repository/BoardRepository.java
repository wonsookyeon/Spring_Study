package org.zerock.b01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b01.domain.Board;
import org.zerock.b01.repository.search.BoardSearch;

import java.util.List;

public interface BoardRepository  extends JpaRepository<Board, Long> , BoardSearch {
                                                    //테이블명, 기본키타입

    Board findByTitle(String title);

    List<Board> findByWriter(String writer);
                //find + (엔티티이름) + by + 변수이름

    List<Board> findByWriterAndContent(String writer, String content);

    List<Board> findByBnoBetween(Long start, Long end);

    List<Board> findByWriterLike(String name); //포함되어있는것 search

    List<Board> findByWriterContaining(String name);

    List<Board> findByBnoLessThanOrderByContentDesc(Long bno);

    //jpql
    @Query("select b from Board b where b.title like %:user% order by b.bno desc")
                            //애칭
    List<Board> findByWriterDetail(@Param("user") String user);

    @Query("select b from Board b where b.writer like %:writer% and b.title like %:title% ")
    List<Board> findByWriterTitleDetail(@Param("writer") String user, @Param("title") String title);

    @Query("select b.bno, b.title, b.writer from Board b where b.writer like %:writer% and b.title like %:title%")
        //애칭
    List<Object[]> findByWriterTitleDetail2(@Param("writer") String writer, @Param("title") String title);

    @Query("select b from Board b where b.writer like concat('%', :keyword, '%')")
    Page<Board> findKeyword(String keyword, Pageable pageable);

    @Query(value = "select * from board where bno = :bno", nativeQuery = true) //sql 구문 자체를 넣음
    Board searchBno(@Param("bno") Long bno);

    @Query("select b from Board b where b.title like %?1%") //첫번째 파라미터값
    List<Board> findByTitle2(String title);

    @Query("select b from Board b where b.title like %:title%")
    List<Board> findByTitle3(@Param("title") String title);


}
