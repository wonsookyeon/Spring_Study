package org.zerock.friends.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.friends.domain.Friends;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class FriendsRepositoryTests {

    @Autowired
    private FriendsRepository friendsRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Friends friends = Friends.builder()
                    .name("원숙연" + i)
                    .phone("010-1234-1234" + i)
                    .address("수원시 영통구 매탄동" + i)
                    .email("tnrdus0530@naver.com" + i)
                    .build();

            Friends result = friendsRepository.save(friends);
            log.info("FNO : " + result.getFno());
        });
    }

    @Test
    public void testRead() {


        Optional<Friends> id = friendsRepository.findById(3L);

        Friends friends = id.orElseThrow();
        log.info(friends);
    }

    @Test
    public void testDelete() {

        Optional<Friends> id = friendsRepository.findById(3L);
        Friends friends = id.orElseThrow();
        friendsRepository.delete(friends);
    }

    @Test
    public void testModify() {
        Optional<Friends> id = friendsRepository.findById(2L);
        Friends friends = id.orElseThrow();

        friends.change("phone 바꿈", "주소 바꿈");

        friendsRepository.save(friends);
    }







}