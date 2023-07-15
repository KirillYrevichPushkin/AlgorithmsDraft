package y88.kirill.config;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {



    private Reflections scanner;

    private Map<Class,Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class,Class> ifc2ImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.ifc2ImplClass = ifc2ImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {


        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if(classes.size()!=1){
                throw new RuntimeException(ifc + " ifc 0 or more then one impl");
            }
            return classes.iterator().next();
        });
       //
    }



    @Override
    public Reflections getScanner() {
        return scanner;
    }

}
