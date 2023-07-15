package y88.kirill.core;


import y88.kirill.annotation.Singleton;
import y88.kirill.config.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type){

        if(cache.containsKey(type)){
            return (T)cache.get(type);
        }

        Class<? extends T> implClass = type;

        if(type.isInterface()){
            implClass = config.getImplClass(type);
        }

        T t = factory.createObject(implClass);

        if(implClass.isAnnotationPresent(Singleton.class)){
            cache.put(type,t);
        }

        return t;
    }

    public void setFactory(ObjectFactory factory) {
        this.factory = factory;
    }

    public ObjectFactory getFactory() {
        return factory;
    }

    public Map<Class, Object> getCache() {
        return cache;
    }

    public Config getConfig() {
        return config;
    }
}
