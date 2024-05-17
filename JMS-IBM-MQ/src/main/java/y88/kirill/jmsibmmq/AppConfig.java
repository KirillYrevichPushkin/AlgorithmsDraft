package y88.kirill.jmsibmmq;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.Property;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

@Configuration
@EnableJms
@ConfigurationProperties(value = "application.yaml")
public class AppConfig implements JmsListenerConfigurer {

  @Autowired
  MQProperties mqProperties;

  @Autowired
  MsgReader msgReader;

  @Autowired
  SampleListener sampleListener;

  @Value("${ibm.mq.queue}")
  private String[] queue;

  @Value("${test.lavel}")
  private String[] queue2;



  @Override
  public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {

    for (String s : mqProperties.getQueues()) {
      System.out.println(s);
      SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
      endpoint.setId("myJmsEndpoint" + s);
      endpoint.setDestination(s);
      endpoint.setMessageListener(sampleListener);
      registrar.registerEndpoint(endpoint);
    }

//    System.out.println(registrar);
  }
}
