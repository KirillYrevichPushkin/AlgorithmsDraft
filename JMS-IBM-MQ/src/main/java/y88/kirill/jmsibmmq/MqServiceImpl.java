package y88.kirill.jmsibmmq;

import java.util.List;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MqServiceImpl implements MqService{

  @Autowired
  private MqConfig mqConfig;

  @Autowired
  @Qualifier("myJmsTemplates")
  List<JmsTemplate> jmsTemplates;


  @Override
  public void sendToMq(TextMessage msg ) {
    //какая-то логика
    //рандомным образом определяем в какую ноду/темплейт отправлять сообщение.
    int maxIndex = jmsTemplates.size()-1; // Конечное значение диапазона - "до"
    int randomNumber = (int) Math.round(Math.random() * maxIndex);
    jmsTemplates.get(randomNumber).convertAndSend(mqConfig.getQueue2(), msg);
  }

}
