package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("SonySpeaker 객체생성");
	}
	
	public void volumUp() {
		System.out.println("SonySpeaker Up");
	}
	
	public void volumDown() {
		System.out.println("SonySpeaker Down");
	}

}
