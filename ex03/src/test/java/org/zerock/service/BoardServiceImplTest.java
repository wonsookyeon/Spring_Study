package org.zerock.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardServiceImplTest {

    @Autowired
    private BoardService service;

    @Test
    public void testGetList() {
        service.getList(new Criterial(2,10)).forEach(
                (list) -> {
                    log.info("list : {}",list);
                }
        );
    }

    @Test
    public void testRemove() {
        log.info("------------------testRemove");
        service.remove(2L);
    }

    @Test
    public void testModify() {
        log.info("-------------testModify");
        BoardVO vo = new BoardVO();
        vo.setTitle("JSP");
        vo.setContent("JSP 왜 씀 ㅋㅋ");
        vo.setWriter("김대철 선생님");
        vo.setBno(3L);

        log.info("modify : {}",service.modify(vo));
    }

    @Test
    public void testRegister(){
        BoardVO vo = new BoardVO();
        vo.setTitle("박종종");
        vo.setContent("종종종종종종종");
        vo.setWriter("진종진");
        service.register(vo);
    }

    @Test
    public void testGet() {
        Long bno = 11L;
        service.get(bno);
    }

    @Test
    public void testGetCount() {
        log.info("total count: {}", service.getTotal(new Criterial(1, 10)));
    }


}
