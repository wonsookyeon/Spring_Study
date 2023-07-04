package polymorphism;

import org.springframework.stereotype.Component;

//@Component
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("AppleSpeaker 객체생성");
	}
	
	public void volumUp() {
		System.out.println("AppleSpeaker Up");
	}
	
	public void volumDown() {
		System.out.println("AppleSpeaker Down");
	}

}
