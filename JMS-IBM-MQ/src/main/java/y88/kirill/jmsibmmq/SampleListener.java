package y88.kirill.jmsibmmq;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleListener implements MessageListener {

//  @Autowired
//  MsgReader msgReader;
  private final MsgReader msgReader;

  @Override
  public void onMessage(Message message) {
    System.out.println("Message has been consumed2 : " + message);
    TextMessage textMessage = (TextMessage) message;
    try {
      msgReader.goRead(textMessage.getText());
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
