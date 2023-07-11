package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
//		TV tv = new SamsungTV();
//		
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		//1.스프링 컨테이너를 구동함.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
												//xml파일 bean에 등록되어 있는 객체 생성
		
		TV tv = (TV)factory.getBean("tv");
			//강제타입형변환(object타입이라) //참조변수
		//xml파일 bean 에서  scope="scope" 썼을때
//		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		factory.close();
		
		
	}
}
