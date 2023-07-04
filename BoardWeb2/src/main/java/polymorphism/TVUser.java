package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

   public static void main(String[] args) {

      //(1)������ �����̳� ����:
      AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

//      - �ΰ��� ��� �� ����:
//      TV tv = (TV) factory.getBean("samtv");
      TV tv = factory.getBean("lgtv", LgTV.class);
//      TV tv2 = factory.getBean("samtv", SamsungTV.class);

      
      tv.powerOn();
      tv.volumeUp();
//      tv.volumeDown();
//      tv.powerOff();
      
      factory.close();
   }

}
