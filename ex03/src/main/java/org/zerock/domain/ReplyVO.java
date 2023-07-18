package org.zerock.domain;
/*
create table tbl_reply(
	    rno number(10,0),
	    bno number(10,0) not null,
	    reply varchar2(1000) not null,
	    replyer varchar2(50) not null,
	    replyDate date default sysdate,
	    updateDate date default sysdate
	);

	 create sequence seq_reply;

	 alter table tbl_reply add CONSTRAINT pk_reply primary key(rno);
	 
	 alter table tbl_reply add constraint fk_reply_board
	 foreign key(bno) references tbl_board(bno);
*/

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReplyVO {
	
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;

}
