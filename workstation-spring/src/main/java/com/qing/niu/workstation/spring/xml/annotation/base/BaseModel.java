package com.qing.niu.workstation.spring.xml.annotation.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

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

}
