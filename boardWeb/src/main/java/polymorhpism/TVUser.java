package polymorhpism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {

	public static void main(String[] args) {
/*		
		SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
		TV tv = new SamsungTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
*/
		//1. Spring �����̳� ����
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); //xml �������
		//AbstractApplicationContext factory2 = new XmlWebApplicationContext("applicationContext.xml");//����� ������
		//System.out.println("factory : " + factory);
		
		//2. Spring �����̳ʷκ��� �ʿ��� ��ü ��û
		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
		// �ϳ��� ��ü�� 3���� ��� ���� scope="Singtone"(�⺻)
		// prototype 3�� �� ��ü���� �� ����
		
		tv1.powerOn();
		tv1.volumeUp();
		
		factory.close();
		
	}

}
