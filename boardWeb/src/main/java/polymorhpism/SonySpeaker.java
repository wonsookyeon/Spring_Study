package polymorhpism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("SonySpeaker °´Ã¼ »ý¼º");
	}
	
	public void volumUp() {
		System.out.println("SonySpeaker Up");
	}
	
	public void volumDown() {
		System.out.println("SonySpeaker Down");
	}

}
