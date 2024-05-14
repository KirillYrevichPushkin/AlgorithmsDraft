package y88.kirill.jmsibmmq;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControllerJMS {

  @Autowired
  private JmsTemplate jmsTemplate;
  

  @GetMapping("/test")
  public String getTest(){
    return "hi";
  }

  @GetMapping("send1")
  String send1(){
    try{
      jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");
      return "OK";
    }catch(JmsException ex){
      ex.printStackTrace();
      return "FAIL";
    }
  }

  @GetMapping("send2")
  String send2(){
    try{
      jmsTemplate.convertAndSend("DEV.QUEUE.2", "Hello World!");
      return "OK";
    }catch(JmsException ex){
      ex.printStackTrace();
      return "FAIL";
    }
  }

  //@JmsListener(id = "app", destination = "DEV.QUEUE.1")
  @GetMapping("recv2")
  String recv2(){
    try{
      return jmsTemplate.receiveAndConvert("DEV.QUEUE.2").toString();
    }catch(JmsException ex){
      ex.printStackTrace();
      return "FAIL";
    }
  }

  @JmsListener(id = "app", destination = "DEV.QUEUE.1")
  public void listener(String message){
    System.out.println("listener " + message);
  }

}
