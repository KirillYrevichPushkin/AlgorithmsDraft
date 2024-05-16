package y88.kirill.jmsibmmq;


import javax.jms.Message;
import javax.jms.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    System.out.println("Message has been consumed : " + message);
  }
}
