package org.zerock.aop;
//부가기능

import org.apache.catalina.tribes.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect //joinpoint+advice
@Component
@Slf4j
public class LogAdvice {
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		log.info("Target : {}", pjp.getTarget().getClass().getMethods()[0]);
		log.info("Param : {}", Arrays.toString(pjp.getArgs()));
		
		Object result =  null;
		
		try {
			result = pjp.proceed(); //함수호출
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("Time : {}" , (end-start));
		
		return result;
	}
	
//	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing = "exception")
	public void logException(Exception exception) {
		log.info("Exception!!!!!!");
		log.info("Exception : {} ", exception);
	}
	
	
	
	                                    // SampleService 시작하는 모든 메서드 (..)=>매개변수 신경x
//	@Before("execution(* org.zerock.service.SampleService*.*(..))") //메서드 기준 Pointcut 설정
	public void logBefore() {
		
		log.info("=============before=============");
	}
	
	// SampleService에서 Mul로 메서드 (..)=>매개변수 신경x
//	@Pointcut("execution(* org.zerock.service.SampleService*.*Div*(..))")
	public void allPointcut() {}
	
//	@After("allPointcut()")
	public void logAter() {
		log.info("=============After=============");
	}
	
//	@After("allPointcut()")
	public void soundup() {
		log.info("금요일 오후 수업");
	}

}
