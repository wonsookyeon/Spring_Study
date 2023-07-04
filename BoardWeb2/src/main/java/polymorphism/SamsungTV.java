package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	
	public SamsungTV() {
		System.out.println("삼성 디폴트 생성자");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");
		
	}
	
	

}
