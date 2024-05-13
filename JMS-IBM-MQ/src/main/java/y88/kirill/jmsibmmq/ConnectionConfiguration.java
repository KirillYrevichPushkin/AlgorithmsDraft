package y88.kirill.jmsibmmq;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConnectionConfiguration {
  String queueManager;
  String channel;
  String connName;
  String user;
  String password;
}
