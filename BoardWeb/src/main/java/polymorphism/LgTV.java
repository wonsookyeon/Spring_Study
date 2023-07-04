package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("LG Tv 생성자...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 On");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 Off");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV 볼륨 Up");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV 볼륨 Down");
		
	}

}
