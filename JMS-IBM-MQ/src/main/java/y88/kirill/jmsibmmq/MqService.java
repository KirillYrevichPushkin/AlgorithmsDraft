package y88.kirill.jmsibmmq;

import javax.jms.TextMessage;
import org.springframework.stereotype.Service;


public interface MqService {


  void sendToMq(TextMessage msg);

}
