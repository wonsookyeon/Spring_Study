package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionAdvice {

	@ExceptionHandler
	public String except(Exception ex, Model model) {
		
		log.error("Exception : {}" , ex.getMessage());
		model.addAttribute("exception", ex);
		log.error("model : {}" , model);
		
		return "error_page";
		
	}
}
