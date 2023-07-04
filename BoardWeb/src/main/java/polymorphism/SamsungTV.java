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
		System.out.println("SamsungTV(Speaker speaker, int price) ��ü ����");

	}
	
	public SamsungTV(Speaker speaker) { 
		this.speaker = speaker;
		System.out.println("SamsungTV(Speaker speaker) ��ü ����");
	}
	
	public SamsungTV() { //�����ڵ���, ��ü�ʱ�ȭ
		System.out.println("SamsungTV() ��ü ����");
	}

	public void initMethod() {//�ʱ⼳��
		System.out.println("��ü �ʱ�ȭ �۾� ����");
	}
	
	public void destroyMethod() {//�Ҹ��ҋ�
		System.out.println("��ü �Ҹ� �� ����");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV ���� On");
	}
	public void powerOff() {
		System.out.println("SamsungTV ���� Off");
	}
	public void volumeUp() {
		//System.out.println("SamsungTV ���� Up");
		speaker.volumUp();
		System.out.println("price : " + this.price);
	}
	public void volumeDown() {
		//System.out.println("SamsungTV ���� Down");
		speaker.volumDown();
	}

}
