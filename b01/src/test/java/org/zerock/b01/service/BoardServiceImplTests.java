package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.BoardDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class BoardServiceImplTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user00")
                .build();

        /*BoardDTO b = new BoardDTO();
        b.setTitle("Sample Title...");
        b.setContent("Sample Content...");
        b.setWriter("user00");*/

        Long bno = boardService.register(boardDTO);
        log.info("bno : " + bno);
    }

}