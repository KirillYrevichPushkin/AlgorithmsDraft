package logging;

//import org.apache.log4j.Logger;

//import java.util.logging.Logger;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.*;
//import java.util.logging.Logger;

public class OrderLogic {

//    private static final Logger log = Logger.getLogger(OrderLogic.class);
private static final Logger log =  LogManager.getLogger(OrderLogic.class);

    public void doOrder(){
        // какае-то логика
        System.out.println("Заказ оформлен!");
        log.debug("Информационное сообщение");
        addToCart();
    }

    private void addToCart() {
        // добавление товара в корзину
        System.out.println("Товар добавлен в корзину");
        log.error("Это сообщение ошибки");
    }
}
