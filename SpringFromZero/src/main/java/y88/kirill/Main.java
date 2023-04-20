package y88.kirill;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.CustomPostProcessor;

/**
* https://habr.com/ru/articles/419679/
* */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello hell");
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("y88.kirill");
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.populateProperties();
        beanFactory.injectBeanNames();
        beanFactory.injectBeanFactory();
        beanFactory.initializeBeans();



        ProductService productService = (ProductService)beanFactory.getBean("productService");
        PromotionService promotionService = (PromotionService)beanFactory.getBean("promotionService");
        System.out.println(productService);
        System.out.println(productService.getPromotionService());


        System.out.println("Bean name = " + promotionService.getBeanName());
        System.out.println("BeanFactory  = " + promotionService.getBeanFactory());


    }
}
