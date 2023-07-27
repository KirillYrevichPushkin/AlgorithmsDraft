package y88.kirill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext("y88.kirill");

        System.out.println(context.getApplicationName());
        System.out.println(context.getAutowireCapableBeanFactory().getBean("quater").toString());
        Quater quater = (Quater) context.getBean("quater");

        quater.sayQuote();





    }
}
