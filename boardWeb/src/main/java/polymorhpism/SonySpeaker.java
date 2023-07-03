package polymorhpism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("SonySpeaker ��ü ����");
	}
	
	public void volumUp() {
		System.out.println("SonySpeaker Up");
	}
	
	public void volumDown() {
		System.out.println("SonySpeaker Down");
	}

}
