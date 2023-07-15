package y88.kirill.core;

import lombok.SneakyThrows;
import y88.kirill.config.Config;
import y88.kirill.config.ObjectConfigurator;
import y88.kirill.config.ProxyConfigurator;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    private static ObjectFactory objectFactory;
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();
    private Config config;
    private final ApplicationContext context;



    //@SneakyThrows
    public ObjectFactory( ApplicationContext context) {

       // this.config = new JavaConfig("y88.kirill", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            try {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Class<? extends ProxyConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ProxyConfigurator.class)) {
            try {
                proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        this.context = context;
    }


    @SneakyThrows
    public <T> T createObject(Class<T> implClass){

        try {

            T t = create(implClass);

            configure(t);

            //вызываем методы @postConstract
            runInitMethod(implClass, t);

            t = wrapWithProxyIfNeeded(implClass, t);

            return t;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private <T> T wrapWithProxyIfNeeded(Class<T> implClass, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.replaceWithProxyIfNeeded(t, implClass);
        }
        return t;
    }

    private <T> void runInitMethod(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)){
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t,context));
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }


}
