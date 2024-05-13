package y88.kirill.jmsibmmq;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Configuration
@ConfigurationProperties(prefix = "mq")
@EqualsAndHashCode(callSuper = false)
@Data
public class MqConfig {
  private List<ConnectionConfiguration> servers;
  private String queue1;
  private String queue2;

}
