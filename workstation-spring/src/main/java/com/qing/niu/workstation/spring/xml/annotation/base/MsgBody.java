package com.qing.niu.workstation.spring.xml.annotation.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/9 17:19
 * @ProjectName communication
 * @Version 1.0.0
 */
@XmlRootElement(name = "msgBody")
@XmlType(propOrder = {"body1","body2","body3"})
public class MsgBody {

    private String body1;

    private String body2;

    private String body3;

    @XmlElement(name = "body1")
    public String getBody1() {
        return body1;
    }

    public void setBody1(String body1) {
        this.body1 = body1;
    }

    @XmlElement(name = "body2")
    public String getBody2() {
        return body2;
    }

    public void setBody2(String body2) {
        this.body2 = body2;
    }

    @XmlElement(name = "body3")
    public String getBody3() {
        return body3;
    }

    public void setBody3(String body3) {
        this.body3 = body3;
    }
}
