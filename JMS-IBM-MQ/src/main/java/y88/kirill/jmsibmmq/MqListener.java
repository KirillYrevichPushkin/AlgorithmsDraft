package y88.kirill.jmsibmmq;

import javax.jms.MessageListener;
import javax.jms.TextMessage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MqListener implements MessageListener {

//  @Autowired
//  MqService mqService;

  @SneakyThrows
  @Override
  public void onMessage(@Payload javax.jms.Message message) {
//    log.info("Получено сообщение <" + message + ">");
    System.out.println("Получено сообщение <" + message + ">");
    //TODO: сюда добавим отправку ответа чуть позже
    //mqService.sendToMq((TextMessage) message);

  }

}
