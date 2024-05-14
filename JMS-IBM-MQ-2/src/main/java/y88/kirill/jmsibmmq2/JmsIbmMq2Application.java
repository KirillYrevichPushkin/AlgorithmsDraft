package y88.kirill.jmsibmmq2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JmsIbmMq2Application {

	public static void main(String[] args) {
		SpringApplication.run(JmsIbmMq2Application.class, args);
	}

}
