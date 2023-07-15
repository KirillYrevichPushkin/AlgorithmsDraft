package y88.kirill.config;

public interface ProxyConfigurator {

    Object replaceWithProxyIfNeeded(Object t, Class implClass);

}
