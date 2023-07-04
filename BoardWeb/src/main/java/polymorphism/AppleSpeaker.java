package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("AppleSpeaker °´Ã¼ »ý¼º");
	}
	
	public void volumUp() {
		System.out.println("AppleSpeaker Up");
	}
	
	public void volumDown() {
		System.out.println("AppleSpeaker Down");
	}

}
