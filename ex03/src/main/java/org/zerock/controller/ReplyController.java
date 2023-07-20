package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyPageDTO;
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
	
	
	//댓글등록 //json형태로 요청이 들어오고 클라이언트에게 문자열로 결과값 반환
	// {"reply" : "Js Test", "replyer" : "tester", "bno" : "bnoValue"}    //결과값(return값)을 평문(문자열)로 전송 ("success")
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		    //상태코드값
		log.info("ReplyVO : {}", vo);
		
		int insertCount = replyService.register(vo);
		return insertCount == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) //200
								: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); //500
		
	}
	//select * from tbl_reply where bno=1000
	//http://localhost:8082/replies/pages/1000/1
/*	@GetMapping(value = "/pages/{bno}/{pages}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable("pages") int pages){
        Criterial cri = new Criterial(pages,10);

        log.info("bno: {}, pages: {}", bno, pages);
        
        return new ResponseEntity<>(replyService.getList(cri, bno), HttpStatus.OK);
    }
*/
	
	@GetMapping(value = "/pages/{bno}/{pages}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Long bno, @PathVariable("pages") int pages){
        Criterial cri = new Criterial(pages,10);

        log.info("bno: {}, pages: {}", bno, pages);
        
        return new ResponseEntity<>(replyService.getListPage(cri, bno), HttpStatus.OK);
    }
	
	
	
	
	//삭제하기 //postman에 delete로 놓고 확인
	//http://localhost:8082/replies/10
	@DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("rno ==> {}", rno);
//		return replyService.remove(rno) == 1 ? new ResponseEntity<String>("delete success", HttpStatus.OK)
//				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		return replyService.remove(rno) == 1 ?
				ResponseEntity.ok("success")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//수정하기 //postman에 patch로 놓고 send 후 body에서 수정
	//http://localhost:8082/replies/1   //json 타입으로 전송            //결과값(return값)을 평문(문자열)로 전송 ("modify success")
	@PatchMapping(value = "/{rno}", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		
		log.info("rno : {}, vo{}", rno, vo);
		vo.setRno(rno);
		
		return replyService.modify(vo) == 1 ?
				new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//데이터 가져오기 (1건)
	//http://localhost:8082/replies/2
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		
		return new ResponseEntity(replyService.get(rno), HttpStatus.OK);
		
	}
	
	
	
	



}
