package y88.kirill.jmsibmmq;


import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.QosSettings;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.*;
import java.util.*;

import static javax.jms.DeliveryMode.NON_PERSISTENT;
import static javax.jms.Session.CLIENT_ACKNOWLEDGE;

@Configuration
@EnableJms
public class MqConfiguration {

  @Autowired
  MqConfig mqConfig;

  @Autowired
  private JmsListenerEndpointRegistry registry;

  //Создаем фабрики слушателей, на вход которых также используем созданные connectionFactories
  @Bean
  public List<JmsListenerContainerFactory> myFactories(
      @Qualifier("myConnFactories")
          List<CachingConnectionFactory> connectionFactories,
      MqListener mqListener) {
    List<JmsListenerContainerFactory> factories = new ArrayList<>();
    connectionFactories.forEach(connectionFactory -> {
      DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory);
      factory.setSessionAcknowledgeMode(CLIENT_ACKNOWLEDGE);

      QosSettings qosSettings = new QosSettings();
      qosSettings.setDeliveryMode(NON_PERSISTENT);
      factory.setReplyQosSettings(qosSettings);

      SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
      endpoint.setId("myJmsEndpoint-"+ UUID.randomUUID());
      endpoint.setDestination(mqConfig.getQueue1());
      endpoint.setMessageListener(mqListener);
      registry.registerListenerContainer(endpoint, factory);

      factories.add(factory);
    });
    return factories;
  }
  //Создаем лист темплейтов для отправки сообщений, на вход которому скармливаем созданные коннекты
  @Bean
  @Qualifier("myJmsTemplates")
  public List<JmsTemplate> jmsTemplates(
      @Qualifier("myConnFactories")
          List<CachingConnectionFactory> connectionFactories) {
    return getJmsTemplates(new ArrayList<ConnectionFactory>(connectionFactories));
  }

  public List<JmsTemplate> getJmsTemplates(List<ConnectionFactory> connectionFactories) {
    List<JmsTemplate> jmsTemplates = new ArrayList<>();
    for (ConnectionFactory connectionFactory : connectionFactories) {
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(connectionFactory);
      jmsTemplate.setMessageConverter(new SimpleMessageConverter());
      jmsTemplate.setDefaultDestinationName(mqConfig.getQueue2());
      jmsTemplate.setDeliveryMode(NON_PERSISTENT);
      jmsTemplate.setDeliveryPersistent(false);
      jmsTemplate.setExplicitQosEnabled(true);
      jmsTemplates.add(jmsTemplate);
    }
    return jmsTemplates;
  }

  //Определяем коннекшионФактори для каждого элемента массива из yml-пропертей
  @Bean
  @Qualifier("myConnFactories")
  public List<CachingConnectionFactory> connectionFactories() throws JMSException {
    List<CachingConnectionFactory> factories = new ArrayList<>();

    for (ConnectionConfiguration server : mqConfig.getServers()) {
      CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
      MQConnectionFactory cf = new MQConnectionFactory();
      cachingConnectionFactory.setTargetConnectionFactory(cf);
      cf.setQueueManager(server.getQueueManager());
      cf.setChannel(server.getChannel());
      cf.setConnectionNameList(server.getConnName());
      cf.setStringProperty(WMQConstants.USERID, server.getUser());
      cf.setStringProperty(WMQConstants.PASSWORD, server.getPassword());
      cf.setStringProperty("XMSC_WMQ_CONNECTION_MODE", "1");

      factories.add(cachingConnectionFactory);
    }
    return factories;
  }


}
