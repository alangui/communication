package com.qing.niu.workstation.spring.xml.modeltoxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/12 15:19
 * @ProjectName communication
 * @Version 1.0.0
 */
public class NamespaceFilter extends XMLFilterImpl {

    private String usedNamespaceUri;

    private boolean addNamespace;

    private boolean addedNamespace = false;

    private boolean isRootElement = true;

    public NamespaceFilter(){
        super();
        this.addNamespace = false;
        this.usedNamespaceUri = "";
    }

    public NamespaceFilter(boolean addNamespace) {
        super();
        this.addNamespace = addNamespace;
        this.usedNamespaceUri = addNamespace == true ? "namespace_string" : "";
    }

    public NamespaceFilter(String namespaceUri, boolean addNamespace) {
        super();
        this.addNamespace = addNamespace;
        this.usedNamespaceUri = addNamespace == true ? namespaceUri : "";
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        if (addNamespace) {
            startControlledPrefixMapping();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        uri = "";
        if (this.isRootElement) {
            if (this.addNamespace) {
                if (!localName.contains("xmlns")) {
                    if (this.usedNamespaceUri.equals("http://www.springframework.org/schema/beans")) {
                        localName = localName
                                + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                                + " xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd\"";
                    }
                }
            } else {
                localName = localName.replaceAll(" xmlns=.*\"", "");
            }
            this.isRootElement = false;
        }
        super.startElement(uri, localName, localName, atts);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!this.addedNamespace)
            uri = "";
        super.endElement(uri, localName, localName);
    }

    @Override
    public void startPrefixMapping(String prefix, String url) throws SAXException {
        if (addNamespace) {
            this.startControlledPrefixMapping();
        }
    }

    private void startControlledPrefixMapping() throws SAXException {
        if (this.addNamespace && !this.addedNamespace) {
            // We should add namespace since it is set and has not yet been done.
            super.startPrefixMapping("", this.usedNamespaceUri);
            // Make sure we don't do it twice
            this.addedNamespace = true;
        }
    }

}
