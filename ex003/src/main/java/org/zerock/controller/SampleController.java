package org.zerock.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;



//@Controller
@RestController  // @Controller + @ResponseBody , return 문자열로 전송
@RequestMapping("/sample")
@Slf4j
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "text/html; charset=utf-8")
	      //값 전송, 없으면 /view/안녕하세요.jsp화면 찾아감
//	public @ResponseBody String getText() {
	
	     //void 면 /view/sample/.jsp로 찾아감
	public String getText() { //@RestController 썼기때문에 @Controller @ResponseBody 주석처리
		log.info("MiME Type : {}", MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
    @GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_VALUE,
    												MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample() {
        return new SampleVO(112, "스타", "로드");
    }
	
    @GetMapping("/getList")
    public List<SampleVO> getList(){
    	
    	return IntStream.range(1, 10).mapToObj(i-> new SampleVO(i, i+"FirstName", i+"LastName"))
    			.collect(Collectors.toList());
    	
    }
    
    @GetMapping("/getMap")
    public Map<String, SampleVO> getMap(){
    	Map<String, SampleVO> map = new HashMap<String, SampleVO>();
    	
    	map.put("first", new SampleVO(111,"그루트", "주니어"));
    	return map;
    }
	
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height<150)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		else
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		
		return result;
	}
	
	// http://localhost:8082/sample/delete/12
	@GetMapping("/delete/{age}")
	public String[] getPath(@PathVariable("age")int no) {
		return new String[] {"no : " +no};
	}
	
//	@GetMapping("/product/{name}")
//	public String[] getPath(@PathVariable("name")String name, @PathVariable("pid") String pid) {
//		return new String[] {"category : " +name, "productid : " + pid};
//	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("ticket => {}", ticket);
		return ticket;
	}
    
    
    
	
	
	
	
	

}
