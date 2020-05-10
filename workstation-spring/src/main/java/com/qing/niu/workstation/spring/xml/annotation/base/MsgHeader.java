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
@XmlRootElement(name = "msgHeader")
@XmlType(propOrder = {"head1","head2","head3"})
public class MsgHeader {

    private String head1;

    private String head2;

    private String head3;

    @XmlElement(name = "head1")
    public String getHead1() {
        return head1;
    }

    public void setHead1(String head1) {
        this.head1 = head1;
    }

    @XmlElement(name = "head2")
    public String getHead2() {
        return head2;
    }

    public void setHead2(String head2) {
        this.head2 = head2;
    }

    @XmlElement(name = "head3")
    public String getHead3() {
        return head3;
    }

    public void setHead3(String head3) {
        this.head3 = head3;
    }
}
