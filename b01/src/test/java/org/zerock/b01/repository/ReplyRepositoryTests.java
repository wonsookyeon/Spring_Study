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
import org.zerock.b01.domain.Reply;
import org.zerock.b01.dto.BoardListReplyCountDTO;
import org.zerock.b01.dto.PageRequestDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test //댓글넣기
    public void testInsert(){
        //실제 DB에 있는 bno
        Long bno = 1L;

        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글4.....!")
                .replyer("원숙연4")
                .build();

        replyRepository.save(reply);

    }

    @Test //페이징처리
    public void testBoardReplies(){
        Long bno = 1L;

        Pageable pageable =
                PageRequest.of(0, 3, Sort.by("rno").descending());
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> log.info(reply));
    }

    /*@Test
    public void TestSearchReplyCount(){
        String[] types = {"t", "c", "W"};
        String keyword = "1";

        Pageable pageable =
                PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);

        log.info(result.getTotalPages());
        log.info(result.getSize());
        log.info(result.getNumber());
        log.info(result.hasPrevious() + ": ");
    }*/

}