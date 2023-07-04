package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component("lgtv")
@AllArgsConstructor
public class LgTV implements TV{
	

	private Speaker speaker;
//	private int price;
	
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}

//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	
//	public LgTV(Speaker speaker, int price) {
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	//무조건 한번만 나옴
//	public void initmethod() {
//		System.out.println("lgtv 초기화 작업");
//	}
//	
//	public void destroymethod() {
//		System.out.println("lgtv 소멸시 작업");
//	}

	// 싱글톤 1회, 프로토타입이면 객체생성할때마다
//	public LgTV() {
//		System.out.println("lgtv 티폴트 생성자");
//	}

	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV powerOff");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumUp();
//		System.out.println("price : " + price);
		//System.out.println("LgTV volumeUp");
		
	}

	@Override
	public void volumeDown() {
		speaker.volumDown();
//		System.out.println("LgTV volumeDown");
		
	}
	
	

}
