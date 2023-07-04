package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("AppleSpeaker ��ü ����");
	}
	
	public void volumUp() {
		System.out.println("AppleSpeaker Up");
	}
	
	public void volumDown() {
		System.out.println("AppleSpeaker Down");
	}

}
