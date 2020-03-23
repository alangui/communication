package com.qing.niu.workstation.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import java.io.IOException;
import java.util.Locale;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/13 18:41
 * @ProjectName communication
 * @Version 1.0.0
 */
@Component
@ComponentScan("com.qing.niu.workstation.spring.beanpostprocessor")
public class ApplicationContextAwareProcessorDemo implements EnvironmentAware,
                                                             EmbeddedValueResolverAware,
                                                             ResourceLoaderAware,
                                                             MessageSourceAware,
                                                             ApplicationEventPublisherAware,
                                                             ApplicationContextAware{

    private EmbeddedValueResolverConfig embeddedValueResolverConfig;

    /**
     * 1、可以拿到StandardEnvironment对象,从而能据此获取jvm环境变量和操作系统环境变量等信息
     */
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("ApplicationContextAwareProcessorDemo.setEnvironment");
        printStringArray(environment.getDefaultProfiles());
        System.out.println(environment.getProperty("os.name"));
        System.out.println(environment.getProperty("user.dir"));
        System.out.println(environment.getProperty("Path"));
        System.out.println(environment);
    }

    private void printStringArray(String[] strings){
        for (String s : strings){
            System.out.println(s);
        }
    }

    /**
     * 2、拿到EmbeddedValueResolver对象，可以据此拿到远行环境变量的值（如：properties文件的值）等信息
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("ApplicationContextAwareProcessorDemo.setEmbeddedValueResolver");
        System.out.println(resolver);
        System.out.println(resolver.resolveStringValue("${os.name}"));
        EmbeddedValueResolverConfig embeddedValueResolverConfig = new EmbeddedValueResolverConfig();
        embeddedValueResolverConfig.setAge(resolver.resolveStringValue("${age}"));
        embeddedValueResolverConfig.setSex(resolver.resolveStringValue("${sex}"));
        System.out.println(embeddedValueResolverConfig);
    }

    /**
     * 3、拿到bean容器对象的资源加载接口,可以据此获取文件资源
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("ApplicationContextAwareProcessorDemo.setResourceLoader");
        System.out.println(resourceLoader);
        System.out.println(resourceLoader.getClassLoader());
        Resource resource = resourceLoader.getResource("/properties/EmbeddedValueResolver.properties");
        System.out.println(resource.getFilename());
        try {
            System.out.println(resource.getURL().getPath());
            System.out.println(resource.getURI().getScheme());
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * 4、拿到bean容器对象的事件发布接口，据此可以发布事件
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("ApplicationContextAwareProcessorDemo.setApplicationEventPublisher");
        System.out.println(applicationEventPublisher);
        applicationEventPublisher.publishEvent(new VolatileEvent(this,"ox0a0018dd"));
    }

    /**
     * 5、拿到bean容器对象的国际化信息处理接口，据此可以实现国际化处理
     */
    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("ApplicationContextAwareProcessorDemo.setMessageSource");
        System.out.println(messageSource);
        String usAddress = messageSource.getMessage("country.address",new Object[]{"America","www.america.com"}, Locale.US);
        String zhAddress = messageSource.getMessage("country.address",new Object[]{"China","www.china.cn"}, Locale.SIMPLIFIED_CHINESE);
        System.out.println("contry address: " + usAddress);
        System.out.println("contry address: " + zhAddress);
    }

    /**
     * 6、获取到bean容器对象的上下文接口，可以据此获取bean等信息
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAwareProcessorDemo.setApplicationContext");
        embeddedValueResolverConfig = (EmbeddedValueResolverConfig) applicationContext.getBean("embeddedValueResolverConfig");
        System.out.println(embeddedValueResolverConfig);
    }

}
