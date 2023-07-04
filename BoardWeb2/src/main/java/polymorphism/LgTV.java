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
	
	//������ �ѹ��� ����
//	public void initmethod() {
//		System.out.println("lgtv �ʱ�ȭ �۾�");
//	}
//	
//	public void destroymethod() {
//		System.out.println("lgtv �Ҹ�� �۾�");
//	}

	// �̱��� 1ȸ, ������Ÿ���̸� ��ü�����Ҷ�����
//	public LgTV() {
//		System.out.println("lgtv Ƽ��Ʈ ������");
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
