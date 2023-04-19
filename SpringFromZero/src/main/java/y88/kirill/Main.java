package y88.kirill;

import org.springframework.beans.factory.BeanFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello hell");
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("y88.kirill");

        ProductService productService = (ProductService)beanFactory.getBean("productService");
        System.out.println(productService);

    }
}
