package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.BindErrorsTag;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.slf4j.Slf4j;

@Controller //bean에 등록됨
@RequestMapping("/sample/*") //*에 입력↓
@Slf4j
public class sampleController {

//	@GetMapping("/") //get방식일때만 동작
	@RequestMapping("")
	public void basic() {
		log.info("basic......");
	}
//	http://localhost:8081/sample/
	
//	---------------------------------------------------
	
//	@PostMapping("/list") //post방식일때만 동작
//	@RequestMapping(value="/list", method = RequestMethod.POST) //post방식일때만 동작
//	@RequestMapping("/list")
	@GetMapping("/list")
	public String list(String name, Model model) {
		log.info("list........{}",name);
		model.addAttribute("name",name);
		return "list";
	}
//	http://localhost:8081/sample/list
	
//	---------------------------------------------------
	
	@GetMapping("/ex1")
	public void ex1(String name, int age) {
		log.info("name : {}", name);
		log.info("age : {}", age);
//	http://localhost:8081/sample/ex1?name=aaa&age=50	
	}
	
	@GetMapping("/ex2")  //값을 넘겨주지 않을경우를 대비해서 default값 입력
	public void ex2(@RequestParam(name="name", defaultValue="kim") String name,
					@RequestParam (name="age", defaultValue ="0") int age) {
		log.info("name : {}", name);
		log.info("age : {}", age);
	}
	
	@GetMapping("/ex3")  //받아주는 이름이 다를때를 대비해서 @RequestParam 입력
	public void ex3(@RequestParam("name") String n,@RequestParam("age") int a) {
		log.info("name : {}", n);
		log.info("age : {}", a);
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page){  //class SampleDTO 에서 받아줌
		log.info("dto : {}", dto);
		return "ex04";
//	http://localhost:8081/sample/ex04?name=kim&age=50&page=100
	}
	
	@GetMapping("/ex04list") //리스트
	public String ex04list(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : {}", ids);
		
		return "ex04list";
//	http://localhost:8081/sample/ex04list?ids=111&ids=222&ids=333
	}
	
	@InitBinder //날짜나타내기
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
		}
	@GetMapping("/ex05")
	public String ex05(TodoDTO todo) {
		log.info("date : {}", todo);
		return "ex05";
//	http://localhost:8081/sample/ex05?title=park&dueDate=2023-07-06
	}
	
	@GetMapping("/ex06")
	public String ex06(Model model) {
		model.addAttribute("text", "Hello World");
		return "ex06";
//	http://localhost:8081/sample/ex06
	}
	
//	@GetMapping("/ex07")
//	public String ex07(){
//		return "redirect:/sample/list"; //list.jsp 요청 
//	}
	
	//★★★경로바꿀 때
	@GetMapping("/ex07")
	public String ex07(RedirectAttributes rttr){
		rttr.addAttribute("name","AAA"); //view까지 안날라감
		// 위에 /list에서 model.addAttribute 써주면 view까지 날라가고, 고정OK
//		rttr.addFlashAttribute("name", "AA"); //view까지 가능하지만 한번만 사용가능, 새로고침하면 안나옴 (고정X)
		rttr.addFlashAttribute("age", 10); //view까지 날라가지만 한번만 사용가능, 새로고침하면 안나옴 (고정X)
		return "redirect:/sample/list"; // 값을 가지고 list.jsp요청
	}
	
	@GetMapping("/ex08") //sample 폴더 안에 ex08.jsp 파일
	public void ex8() {
		log.info("/ex08");
	}
	
	@GetMapping("list/ex09") //sample 폴더 안에 list폴더 안에 ex09.jsp 파일
	public void ex9() {
		log.info("/ex09");
	}
	
	@GetMapping("/ex10")
	public String ex10() { //경로 안바꿀 경우에는 void 으로 바꾸고 return 지워도됨.
		log.info("/ex10");
		return "sample/ex10";
	}
	
//	@GetMapping("/ex10")
//	public void ex10() { //경로 안바꿀 경우에는 void 으로 바꾸고 return 지워도됨.
//		log.info("/ex10");
//	}
	
	//vo(dto)에 값 담아서 실행 
	@GetMapping("/ex11")
	public SampleDTO ex11(Model model) {
		SampleDTO dto = new SampleDTO();
		dto.setName("park");
		dto.setAge(20);
		model.addAttribute("dto", dto);
		
		return dto;
	}
	
	@GetMapping("/ex12")
	public @ResponseBody SampleDTO ex12() { //반환타입바꿔주기 / jsp 파일 없어도 값을 넘겨준다.
		SampleDTO dto = new SampleDTO();
		dto.setName("park");
		dto.setAge(20);
		
		return dto;
	}
	
//	@DeleteMapping("/list/{id}")
	@GetMapping("/ex13/{id}")
	public String ex13(@PathVariable String id) { //브라우저 경로에 값(free)을 넣어서 던짐
		log.info("id : {}", id);
		return "/sample/ex13";
		
//	http://localhost:8081/sample/ex13/free
	}
	
	
	
	
	
}

/*
핸들러 맵핑

/ -> HomeController 안에 있는 home 실행
/sample/ -> SampleController 안 basic() 실행
/sample/list -> SampleController 안 list() 실행
*/


