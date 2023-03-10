package y88.kirill;

import lombok.Setter;
import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectFactory {



    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();


    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
    this.context = context;


       // this.config = new JavaConfig("y88.kirill", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }

        for (Class<? extends ProxyConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ProxyConfigurator.class)) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
        }

    }




    @SneakyThrows
    public <T> T createObject (Class<T> implClass) {

        T t = create(implClass);

        configure(t);

        invokeInit(implClass, t);

        t = wrapWithProxyIfNeeded(implClass, t);


        return t;
    }

    private <T> T wrapWithProxyIfNeeded(Class<T> implClass, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t =  (T)proxyConfigurator.replaceWithProxyIfNeeded(t, implClass);
        }
        return t;
    }

    private <T> void invokeInit(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)){
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t,context));
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return implClass.getDeclaredConstructor().newInstance();
    }


}
