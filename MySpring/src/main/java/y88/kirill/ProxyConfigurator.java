package y88.kirill;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);

}
