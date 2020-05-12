package com.qing.niu.workstation.spring.xml;

import com.qing.niu.workstation.spring.xml.annotation.base.MsgBody;
import com.qing.niu.workstation.spring.xml.annotation.base.MsgHeader;
import com.qing.niu.workstation.spring.xml.annotation.base.PayApply;
import com.qing.niu.workstation.spring.xml.modeltoxml.ToXmlUtil;

public class main {

    public static void main(String[] args) {
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setHead1("h1");
        msgHeader.setHead2("h2");
        msgHeader.setHead3("h3");
        MsgBody msgBody = new MsgBody();
        msgBody.setBody1("b1");
        msgBody.setBody2("b2");
        msgBody.setBody3("b3");
        PayApply payApply = new PayApply();
        payApply.setMsgHeader(msgHeader);
        payApply.setMsgBody(msgBody);
        System.out.println(new ToXmlUtil().toXml(payApply,true,"http://www.springframework.org/schema/beans"));
    }
}
