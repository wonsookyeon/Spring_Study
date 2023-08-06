package org.zerock.friends.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zerock.friends.domain.Friends;
import org.zerock.friends.dto.FriendsDTO;
import org.zerock.friends.dto.PageRequestDTO;
import org.zerock.friends.dto.PageResponseDTO;
import org.zerock.friends.repository.FriendsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FriendsServiceImpl implements FriendsService{

    private final ModelMapper modelMapper;
    private final FriendsRepository friendsRepository;
    @Override
    public Long register(FriendsDTO friendsDTO) {
        Friends friends = modelMapper.map(friendsDTO, Friends.class);
        Long fno = friendsRepository.save(friends).getFno();
        //-----------DB저장 ------------------>저장된 Bno값을 반환

        return fno;
    }

    @Override
    public FriendsDTO readOne(Long fno) {
        Optional<Friends> result = friendsRepository.findById(fno);
        Friends friends = result.orElseThrow();
        FriendsDTO friendsDTO = modelMapper.map(friends, FriendsDTO.class);

        return friendsDTO;
    }

    @Override
    public void modify(FriendsDTO friendsDTO) {

        Optional<Friends> result = friendsRepository.findById(friendsDTO.getFno());

        Friends friends = result.orElseThrow();
        friends.change(friendsDTO.getPhone(), friendsDTO.getAddress());
        friendsRepository.save(friends); // save --> insert,update 두 기능 수행

    }

    @Override
    public void remove(Long fno) {

        friendsRepository.deleteById(fno);
    }

    @Override
    public PageResponseDTO<FriendsDTO> list(PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("fno");

        Page<Friends> result = friendsRepository.searchAll(types,keyword,pageable);

        log.info("-----------------------------------------------");
        log.info("aaa getTotalPages: " + result.getTotalPages());
        log.info("aaa getSize: " + result.getSize());
        log.info("aaa getTotalElements: " + result.getTotalElements());
        result.getContent().forEach(board -> log.info(board));
        log.info("------------------------------------------------");
        // ---------------------------------------


        // board(entity)---> boardDTO로 변환(mapper)
        List<FriendsDTO> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board,FriendsDTO.class)).collect(Collectors.toList());

        PageResponseDTO<FriendsDTO> pageResponseDTO =
                new PageResponseDTO<>(pageRequestDTO, dtoList,(int) result.getTotalElements());

        return pageResponseDTO;



//        return PageResponseDTO.<BoardDTO>withAll()

//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(dtoList)
//                .total((int)result.getTotalElements())
//                .build();
    }


}
