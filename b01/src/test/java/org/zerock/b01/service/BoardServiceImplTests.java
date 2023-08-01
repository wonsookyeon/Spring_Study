package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class BoardServiceImplTests {

    @Autowired
    private BoardService boardService;

    @Test //등록하기
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

    @Test //데이터 한건만 가져오기
    public void testReadOne(){
        BoardDTO boardDTO = boardService.readOne(99L);
        log.info("BoardDTO : " + boardDTO);
    }

    @Test //수정하기
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(99L)
                .title("수정테스트")
                .content("수정 내용 테스트")
                .build();

        boardService.modify(boardDTO);
    }

    @Test //삭제하기
    public void testRemove(){
        boardService.remove(101L);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        log.info("responseDTO =====> " + responseDTO);
    }




}