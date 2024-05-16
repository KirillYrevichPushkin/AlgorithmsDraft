package y88.kirill.jmsibmmq2;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.common.CommonConstants;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class JmsIbmMq2Application {

	public static void main(String[] args) {
		SpringApplication.run(JmsIbmMq2Application.class, args);
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory
				= new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		MQConnectionFactory mqFactory = new MQConnectionFactory();
		try {
			mqFactory.setQueueManager("QM1");
			mqFactory.setChannel("DEV.ADMIN.SVRCONN");
			mqFactory.setConnectionNameList("localhost(1414)");
			mqFactory.setStringProperty("user", "admin");
			mqFactory.setStringProperty("password", "passw0rd");
			mqFactory.setIntProperty(CommonConstants.WMQ_CONNECTION_MODE, CommonConstants.WMQ_CM_CLIENT);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return new MQConnectionFactory();
	}

}
