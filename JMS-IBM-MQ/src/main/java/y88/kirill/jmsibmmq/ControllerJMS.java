package y88.kirill.jmsibmmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerJMS {

  @GetMapping("/test")
  public String getTest(){
    return "hi";
  }

}
