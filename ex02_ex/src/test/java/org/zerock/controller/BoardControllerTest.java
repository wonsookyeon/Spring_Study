package org.zerock.controller;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Slf4j
@WebAppConfiguration
public class BoardControllerTest extends TestCase {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

//    @Test
//    public void testList() throws Exception {
//        log.info("{}", mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
//    }
    @Test
    public void testList() throws Exception {

        log.info("{}",
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list") //.get or .post
                                .param("pageNum","2")
                                .param("amount", "10"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap() //데이터 전달된거 확인 가능
        );
    }

    @Test
    public void testRegister() throws Exception {
        log.info("{}", mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                                .param("title", "오라클")
                                .param("content", "view 공부중")
                                .param("writer", "이지스퍼블리싱")
                        )
                        .andReturn()
                        .getModelAndView()
                        .getViewName()
        );
    }

    @Test
    public void testGet() throws Exception {
        log.info("{}", mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
                                .param("bno", "1")
                        )
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
        );
    }

    @Test
    public void testRemove() throws Exception {
        log.info("{}", mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                                .param("bno", "3")
                        )
                        .andReturn()
                        .getModelAndView()
                        .getViewName()
        );
    }

    @Test
    public void testModify() throws Exception {
        log.info("{}", mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                                .param("title", "테스트테스트테스트")
                                .param("content", "테스트 내용 내용")
                                .param("writer", "useruser")
                                .param("bno", "1")
                        )
                        .andReturn()
                        .getModelAndView()
                        .getViewName()
        );
    }


}