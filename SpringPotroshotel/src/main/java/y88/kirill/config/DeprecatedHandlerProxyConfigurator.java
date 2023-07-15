package y88.kirill.config;


import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {

        if(implClass.isAnnotationPresent(Deprecated.class)) {

            if(implClass.getInterfaces().length == 0){
                return Enhancer.create(implClass, new net.sf.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("********** my proxy  CGLIB");
                        return method.invoke(t,args);
                    }
                });
            }


            return  Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("reccomend")) {
                        System.out.println("********** my proxy");
                        return method.invoke(t);
                    } else {
                        return method.invoke(t);
                    }
                }
            });
        }
        return t;
    }


}
