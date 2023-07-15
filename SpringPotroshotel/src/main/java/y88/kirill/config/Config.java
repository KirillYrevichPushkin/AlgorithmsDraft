package y88.kirill.config;

import org.reflections.Reflections;

public interface Config {

    Reflections getScanner();

    <T>Class<? extends T> getImplClass(Class<T> ifc);

}
