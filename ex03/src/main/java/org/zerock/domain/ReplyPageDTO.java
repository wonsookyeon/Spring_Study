package org.zerock.domain;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter@Setter
@RequiredArgsConstructor
public class ReplyPageDTO {
	
	private final int replyCnt;
	private final List<ReplyVO> list;
	

}
