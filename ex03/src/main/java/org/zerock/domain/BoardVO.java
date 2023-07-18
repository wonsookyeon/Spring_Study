package org.zerock.domain;

//create table tbl_board(
//        bno NUMBER(10,0),
//        title VARCHAR2(200) not null,
//        content VARCHAR2(2000) not null ,
//        writer VARCHAR2(50) not null ,
//        regdate date DEFAULT sysdate,
//        updatedate date default sysdate
//        );

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long bno;
    private String title,content,writer;
    private Date regdate,updatedate;
}
