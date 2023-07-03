package polymorhpism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {

	public static void main(String[] args) {
/*		
		SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
		TV tv = new SamsungTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
*/
		//1. Spring 컨테이너 구동
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); //xml 설정기반
		//AbstractApplicationContext factory2 = new XmlWebApplicationContext("applicationContext.xml");//웹기반 스프링
		//System.out.println("factory : " + factory);
		
		//2. Spring 컨테이너로부터 필요한 객체 요청
		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
		// 하나의 객체에 3가지 모두 접근 scope="Singtone"(기본)
		// prototype 3번 다 객체생성 후 실행
		
		tv1.powerOn();
		tv1.volumeUp();
		
		factory.close();
		
	}

}
