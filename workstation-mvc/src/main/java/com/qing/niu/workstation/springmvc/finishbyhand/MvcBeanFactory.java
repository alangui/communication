package com.qing.niu.workstation.springmvc.finishbyhand;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/12 19:14
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MvcBeanFactory {

    private ApplicationContext applicationContext;

    private HashMap<String,MvcBean> apiMap = new HashMap<>();

    public MvcBeanFactory(ApplicationContext applicationContext){
        Assert.notNull("aggument 'applicationContext' nust not be null");
        this.applicationContext = applicationContext;
        loadApiFromSpringBeans();
    }

    private void loadApiFromSpringBeans(){
        apiMap.clear();

        String[] names = applicationContext.getBeanDefinitionNames();
        Class<?> type;

        for (String name : names){
            type = applicationContext.getType(name);
            for (Method m : type.getDeclaredMethods()){
                MvcMapping mvcMapping = m.getAnnotation(MvcMapping.class);
                if (mvcMapping != null){
                    addApiItem(mvcMapping,name,m);
                }
            }
        }
    }

    private void addApiItem(MvcMapping mvcMapping, String beanName, Method method){
        MvcBean apiRun = new MvcBean();
        apiRun.apiName = mvcMapping.value();
        apiRun.targetMethod = method;
        apiRun.targetName = beanName;
        apiRun.applicationContext = applicationContext;
        apiMap.put(mvcMapping.value(),apiRun);
    }

    public MvcBean getMvcBean(String apiName){
        return apiMap.get(apiName);
    }

    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static class MvcBean{
        String apiName;

        String targetName;

        Object target;

        Method targetMethod;

        ApplicationContext applicationContext;

        public Object run(Object... args) throws InvocationTargetException, IllegalAccessException {
            if (null == target){
                target = applicationContext.getBean(targetName);
            }
            return targetMethod.invoke(target,args);
        }

        public String getApiName() {
            return apiName;
        }

        public void setApiName(String apiName) {
            this.apiName = apiName;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

        public Object getTarget() {
            return target;
        }

        public void setTarget(Object target) {
            this.target = target;
        }

        public Method getTargetMethod() {
            return targetMethod;
        }

        public void setTargetMethod(Method targetMethod) {
            this.targetMethod = targetMethod;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        public void setApplicationContext(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }
    }
}
