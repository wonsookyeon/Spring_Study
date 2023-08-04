package org.zerock.b01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zerock.b01.domain.Board;
import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.BoardListReplyCountDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;
import org.zerock.b01.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper; //DTO(BoardDTO) --> Entity(Board)  변환하기 위해서
    private final BoardRepository boardRepository; //영속계층에 저장하기위해서..

    @Override //등록하기
    public Long register(BoardDTO boardDTO) {

        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        //----------- DB저장 ----------> 저장된 bno 값을 반환

        return bno;
    }

    @Override //데이터 한건만 가져오기
    public BoardDTO readOne(Long bno){
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();

        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);

        return boardDTO;
    }

    @Override //수정하기
    public void modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
                                    //데이터를 먼저 찾고
        Board board = result.orElseThrow(); //있다면
        board.change(boardDTO.getTitle(), boardDTO.getContent()); //변경
        boardRepository.save(board); //save --> insert, update 두 기능 수행
    }

    @Override //삭제하기
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes(); // t c w
        String keyword = pageRequestDTO.getKeyword(); // java , 1
        Pageable pageable = pageRequestDTO.getPageable("bno"); //0page, 10개, bno.desc //page정보

        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
        //확인 검색
        log.info("-----------------------------------------------");
        log.info("aaa getTotalPages : " + result.getTotalPages());
        log.info("aaa getSize : " + result.getSize());
        log.info("aaa getTotalElements : " + result.getTotalElements());
        result.getContent().forEach(board -> log.info(board));
        log.info("-----------------------------------------------");

        //--------------------------------
        //board(entity) 타입을 --> boardDTO 타입으로 변환(mapper)
        List<BoardDTO> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board,BoardDTO.class))
                .collect(Collectors.toList());


        PageResponseDTO<BoardDTO> pageResponseDTO =
                new PageResponseDTO<>(pageRequestDTO, dtoList, (int)result.getTotalElements());

        return pageResponseDTO;

        /*return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();*/
    }


    @Override
    public PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO){

        String[] types = pageRequestDTO.getTypes(); // t c w
        String keyword = pageRequestDTO.getKeyword(); // java , 1
        Pageable pageable = pageRequestDTO.getPageable("bno"); //0page, 10개, bno.desc //page정보

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);

        return PageResponseDTO.<BoardListReplyCountDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(result.getContent())
                .total((int)result.getTotalElements())
                .build();
    }




}
