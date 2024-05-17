package y88.kirill.jmsibmmq;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ibm.mq")
public class MQProperties {

  List<String> queues;
  String message_folder;
  List<Map<String,String>> servers;

}
