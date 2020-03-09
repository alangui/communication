package com.qing.niu.workstation.spring.xmltodocument;

import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ClassUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/16 18:51
 * @ProjectName communication
 * @Version 1.0.0
 */
public class DoLoadDocument {

    private static final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    private static final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Resource resource = new ClassPathResource("beans.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setAttribute(SCHEMA_LANGUAGE_ATTRIBUTE,XSD_SCHEMA_LANGUAGE);

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setEntityResolver(new ResourceEntityResolver(new PathMatchingResourcePatternResolver()));
        Document document = documentBuilder.parse(resource.getInputStream());
        Element element = document.getDocumentElement();
        System.out.println(element.getNodeName());
        System.out.println(element.getNamespaceURI());
        System.out.println(element.getAttributes().item(0).getNodeName() + "-->" + element.getAttributes().item(0).getNodeValue());
        System.out.println(element.getAttributes().item(1).getNodeName() + "-->" + element.getAttributes().item(1).getNodeValue());
        System.out.println(element.getAttributes().item(2).getNodeName() + "-->" + element.getAttributes().item(2).getNodeValue());

        System.out.println(element.getChildNodes().getLength());
        System.out.println(element.getChildNodes().item(0).getNodeName());

        System.out.println(element.getChildNodes().item(1).getNodeName());
        System.out.println(element.getChildNodes().item(1).getNamespaceURI());
        System.out.println(element.getChildNodes().item(1).getAttributes().getLength());
        System.out.println(element.getChildNodes().item(1).getAttributes().item(0).getNodeName() + "-->" + element.getChildNodes().item(1).getAttributes().item(0).getNodeValue());
        System.out.println(element.getChildNodes().item(1).getAttributes().item(0).getNamespaceURI());
        System.out.println(element.getChildNodes().item(1).getAttributes().item(1).getNodeName() + "-->" + element.getChildNodes().item(1).getAttributes().item(1).getNodeValue());

        System.out.println(element.getChildNodes().item(1).getChildNodes().getLength());
        System.out.println(element.getChildNodes().item(1).getChildNodes().item(1).getNodeName());

        System.out.println(element.getChildNodes().item(2).getNodeName());
    }
}
