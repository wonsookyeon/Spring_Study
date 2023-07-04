package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	public SamsungTV(Speaker speaker, int price) { 
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV(Speaker speaker, int price) 객체 생성");

	}
	
	public SamsungTV(Speaker speaker) { 
		this.speaker = speaker;
		System.out.println("SamsungTV(Speaker speaker) 객체 생성");
	}
	
	public SamsungTV() { //생성자동작, 객체초기화
		System.out.println("SamsungTV() 객체 생성");
	}

	public void initMethod() {//초기설정
		System.out.println("객체 초기화 작업 수행");
	}
	
	public void destroyMethod() {//소멸할떄
		System.out.println("객체 소멸 시 동작");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원 Off");
	}
	public void volumeUp() {
		//System.out.println("SamsungTV 볼륨 Up");
		speaker.volumUp();
		System.out.println("price : " + this.price);
	}
	public void volumeDown() {
		//System.out.println("SamsungTV 볼륨 Down");
		speaker.volumDown();
	}

}
