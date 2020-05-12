package com.qing.niu.workstation.spring.xml.modeltoxml;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/12 15:11
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ToXmlUtil {

    public String toXml(Object object){
        return toXml(object,false);
    }

    public String toXml(Object object, boolean isFormat){
        return toXml(object,isFormat,"",false);
    }

    public String toXml(Object object, boolean isFormat, String namespace){
        return toXml(object,isFormat,namespace,true);
    }

    public String toXml(Object object, boolean isFormat, String namespace, boolean isAddNamespace){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormat);
            //是否省略xm头声明信息
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

            OutputFormat outputFormat = new OutputFormat();
            outputFormat.setNewlines(isFormat);
            outputFormat.setNewLineAfterDeclaration(false);

            StringWriter out = new StringWriter();
            XMLWriter writer = new XMLWriter(out, outputFormat);

            NamespaceFilter inFilter = new NamespaceFilter(namespace, isAddNamespace);
            inFilter.setContentHandler(writer);
            marshaller.marshal(object, inFilter);

            return out.toString();
        } catch (Exception e) {
            System.out.println("xml转换异常");
            return null;
        }
    }

}
