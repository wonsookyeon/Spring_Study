package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("LG Tv ������...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV ���� On");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV ���� Off");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV ���� Up");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV ���� Down");
		
	}

}
