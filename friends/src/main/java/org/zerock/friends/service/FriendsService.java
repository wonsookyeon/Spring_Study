package org.zerock.friends.service;

import org.zerock.friends.dto.FriendsDTO;
import org.zerock.friends.dto.PageRequestDTO;
import org.zerock.friends.dto.PageResponseDTO;

public interface FriendsService {

    Long register(FriendsDTO friendsDTO);

    FriendsDTO readOne(Long fno);

    void modify(FriendsDTO friendsDTO);

    void remove(Long fno);

    //목록,검색기능
    PageResponseDTO<FriendsDTO> list(PageRequestDTO pageRequestDTO);

}
