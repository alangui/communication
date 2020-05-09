package com.qing.niu.workstation.spring.xml.annotation.base;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.StringWriter;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/9 17:19
 * @ProjectName communication
 * @Version 1.0.0
 */
@XmlTransient
public class BaseModel {
    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    protected MsgHeader msgHeader;

    protected MsgBody msgBody;

    @XmlElement(name = "MsgHeader", required = true)
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    @XmlElement(name = "MsgBody", required = true)
    public MsgBody getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        this.msgBody = msgBody;
    }

    public String toXml(){
       return toXml(false);
    }

    public String toXml(boolean isFormatted){
        return XML_HEADER + toXml(this,isFormatted);
    }

    public String toXml(Object obj, boolean isFormatted){
        return toXml(obj, "namespace_string", isFormatted);
    }

    public String toXml(Object obj, String namespaceUri, boolean isFormatted){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormatted);
            // 是否省略xm头声明信息
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            StringWriter out = new StringWriter();
            OutputFormat format = new OutputFormat();
            format.setNewlines(isFormatted);
            format.setNewLineAfterDeclaration(false);
            XMLWriter writer = new XMLWriter(out, format);
            NamespaceFilter inFilter = new NamespaceFilter(namespaceUri, true);
            inFilter.setContentHandler(writer);
            marshaller.marshal(obj, inFilter);

            return out.toString();
        } catch (Exception e) {
            System.out.println("xml转换异常");
            return null;
        }
    }

    public static class NamespaceFilter extends XMLFilterImpl {
        private String usedNamespaceUri;
        private boolean addNamespace = true;
        private boolean addedNamespace = false;
        private boolean isRootElement = true;

        public NamespaceFilter(boolean addNamespace) {
            super();
            if (addNamespace)
                this.usedNamespaceUri = "namespace_string";
            else
                this.usedNamespaceUri = "";
            this.addNamespace = addNamespace;
        }

        public NamespaceFilter(String namespaceUri, boolean addNamespace) {
            super();

            if (addNamespace)
                this.usedNamespaceUri = namespaceUri;
            else
                this.usedNamespaceUri = "";
            this.addNamespace = addNamespace;
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
                        localName = localName + " xmlns=\"" + this.usedNamespaceUri + "\"";
                        if (this.usedNamespaceUri.contains("ccms")) {
                            localName = localName + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
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
            } else {
                // Remove the namespace, i.e. don´t call startPrefixMapping for
                // parent!
            }
        }

        private void startControlledPrefixMapping() throws SAXException {
            if (this.addNamespace && !this.addedNamespace) {
                // We should add namespace since it is set and has not yet been
                // done.
                super.startPrefixMapping("", this.usedNamespaceUri);

                // Make sure we dont do it twice
                this.addedNamespace = true;
            }
        }

    }

}
