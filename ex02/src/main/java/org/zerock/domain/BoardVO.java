package org.zerock.domain;
/*
create SEQUENCE seq_board;

create table tbl_board(
    bno NUMBER(10,0),
    title VARCHAR(200) not null,
    content VARCHAR(2000) not null,
    writer VARCHAR2(50) not null,
    regdate date DEFAULT sysdate,
    updatedate date DEFAULT sysdate
    );
    
alter table tbl_board add CONSTRAINT pk_board PRIMARY KEy(bno);
*/
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	//long - 기본자료형 /  Long - 객체(null값 가능)
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;

}
