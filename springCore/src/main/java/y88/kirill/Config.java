package y88.kirill;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = {"quater"})
    public Quater getQuater(){
        Quater quater = new TerminatorQuater();
        quater.setMessage("i will be back");
        return quater;
    }

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor getInjectRandomIntAnnotationBeanPostProcessor(){

        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean
    public ProfilingHandlerBeanPostProcessor getProfilingHandlerBeanPostProcessor(){
        return new ProfilingHandlerBeanPostProcessor();
    }

    @Bean
    public PostProxyInvokerContextListener getPostProxyInvokerContextListener(){
        return new PostProxyInvokerContextListener();
    }

    @Bean
    public DeprecationHandlerBeanFactoryPostProcessor getDeprecationHandlerBeanFactoryPostProcessor(){
        return new DeprecationHandlerBeanFactoryPostProcessor();
    }

//    @Bean
//    public ConfigurableListableBeanFactory getConfigurableListableBeanFactory(){
//        return new DefaultListableBeanFactory();
//    }


}
