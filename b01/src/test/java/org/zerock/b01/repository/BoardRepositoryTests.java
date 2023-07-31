package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.b01.domain.Board;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2
class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Board board = Board.builder().
                    title("title"+i).
                    content("content"+i).
                    writer("user"+(i%10)).build();

            Board result = boardRepository.save(board);
            log.info("bno:"+result.getBno());
        });
    }

    @Test
    public void testRead(){
        Long bno = 5L;
        Optional<Board> byId = boardRepository.findById(bno);

        Board board = byId.orElseThrow();
        log.info(board);
    }

    @Test
    public void testDelete() {
        Optional<Board> id = boardRepository.findById(3L);
        Board board = id.orElseThrow();
        boardRepository.delete(board);
    }

    @Test
    public void testPaging() {
        PageRequest request = PageRequest.of(2, 10, Sort.by("bno").descending());
        Page<Board> page = boardRepository.findAll(request);
        log.info(page.getTotalPages());
        log.info(page.getSize());
        log.info(page.getTotalElements());
        log.info(page.getNumber());

        page.getContent().forEach(board-> log.info(board));

    }

    @Test
    public void testTitle(){
        String title = "title20";
        Board byTitle = boardRepository.findByTitle(title);
        log.info(byTitle);
    }

    @Test
    public void testWriter() {
        boardRepository.findByWriter("user5").forEach( //find + (엔티티이름) + by + 변수명
                board-> log.info("board: " + board)
        );
    }

    @Test
    public void testWriterAndContent() {
        boardRepository.findByWriterAndContent("user5", "content75").forEach(
                board-> log.info("board: " + board)
        );
    }

    @Test
    public void testBetween() {
        boardRepository.findByBnoBetween(10L, 15L).forEach(
                board-> log.info("board: " + board)
        );
    }

    @Test
    public void testLike() {
        boardRepository.findByWriterLike("%user%").forEach(
                board-> log.info("board: " + board)
        );
    }

    @Test
    public void testContaining() {
        boardRepository.findByWriterContaining("user").forEach(
                board-> log.info("board: " + board)
        );
    }

    @Test
    public void testfindByBnoLessThanOrderByContentDesc() {
        boardRepository.findByBnoLessThanOrderByContentDesc(10L).forEach(
                board-> log.info("board: " + board)
        );
    }

    @Test
    public void testQuery(){
        boardRepository.findByWriterDetail("2").forEach(
                board-> log.info("board: " + board)
        );
    }
/*
    @Test
    public void testQuery2(){
        boardRepository.findByWriterDetail2("2", "2").forEach(
                board-> log.info(Arrays.toString(board))
        );
    }
*/
    @Test
    public void testKeywordPage(){
        Pageable pageable = PageRequest.of(1, 5, Sort.by("bno").descending());

        Page<Board> page = boardRepository.findKeyword("2", pageable);

        log.info("page : " + page.getTotalPages()); //총 페이지 수
        log.info("page : " + page.getTotalElements()); //총 데이터 수
        log.info("page : " + page.getSize()); //한 페이지당 보여주는 데이터 수
        log.info("page : " + page.getNumber()); //현재 페이지

        page.getContent().forEach(list-> log.info(list)); //getContent => 현재 페이지에서 조회된 데이터
    }

    @Test
    public void testSearch() {
        Board board = boardRepository.searchBno(100L);
        log.info(board);
    };

    @Test
    public void testByTitle() {
        boardRepository.findByTitle2("2")
                .forEach(board-> log.info("board: " + board)
        );
    }

    @Test
    public void testByTitle2() {
        boardRepository.findByTitle3("3").forEach(
                board-> log.info("board: " + board)
        );
    }


    @Test
    public void testSearch1() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("bno").descending());
        Page<Board> search1 = boardRepository.search1(pageable);

        log.info("getTotalPages: " + search1.getTotalPages());
        log.info("getTotalPages: " + search1.getTotalElements());
        search1.getContent().forEach(list-> log.info(list));
    }

}