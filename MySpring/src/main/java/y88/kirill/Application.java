package y88.kirill;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifcImplClass){
        JavaConfig config = new JavaConfig(packageToScan, ifcImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
    }
}
