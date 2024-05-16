package y88.kirill.jmsibmmq2;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    System.out.println("Message has been consumed : " + message);
  }
}
