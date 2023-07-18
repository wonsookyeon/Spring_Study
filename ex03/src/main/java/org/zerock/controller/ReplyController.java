package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/replies")
@Slf4j
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyService replyService;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("ReplyVO : {}", vo);
		
		int insertCount = replyService.register(vo);
		return insertCount == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
								: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	


}
