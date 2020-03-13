package com.qing.niu.workstation.spring.springboot.autoconfig.version3;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 14:11
 * @ProjectName communication
 * @Version 1.0.0
 */
public class GjkImportSelector implements ImportSelector{

    /**
     * 硬编码
     */
//    @Override
//    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[]{
//                "TestConfig"};
//    }

//    /**
//     * 读取文件
//     */
//    @Override
//    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        Properties properties = new Properties();
//        try {
//            properties = PropertiesLoaderUtils.loadAllProperties("myautoconfig.properties");
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//        String value = properties.getProperty(GjkEnableAutoConfig.class.getName());
//        return new String[]{value};
//    }

    /**
     * spring boot方式
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
                ObjectAutoConfig.class,GjkImportSelector.class.getClassLoader());

        Assert.notEmpty(configurations,"No auto configuration classes found in META-INF/spring.factories");
        return StringUtils.toStringArray(configurations);
    }

}
