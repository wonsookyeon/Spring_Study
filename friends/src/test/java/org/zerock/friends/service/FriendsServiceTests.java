package org.zerock.friends.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.friends.dto.FriendsDTO;
import org.zerock.friends.service.FriendsService;

@SpringBootTest
@Log4j2
public class FriendsServiceTests {

    @Autowired
    private FriendsService friendsService;

    @Test
    public void testRegister(){
        log.info(friendsService.getClass().getName());

        FriendsDTO friendsDTO = FriendsDTO.builder()
                .name("정혜민")
                .phone("010-1234-1234")
                .address("수원시")
                .email("hyemin@naver.com")
                .build();

        Long fno = friendsService.register(friendsDTO);
        log.info("FNO : " + fno);
    }
    @Test //데이터 한건만 가져오기
    public void testReadOne() {
        FriendsDTO friendsDTO = friendsService.readOne(9L);
        log.info("FriendsDTO : " + friendsDTO);
    }

    @Test
    public void testModify(){
        FriendsDTO friendsDTO = FriendsDTO.builder()
                .fno(1L)
                .phone("번호 수정")
                .address("주소 수정")
                .build();
        friendsService.modify(friendsDTO);

    }
    @Test
    public void testRemove() {
        friendsService.remove(85L);

    }

}