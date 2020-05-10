package com.qing.niu.workstation.spring.xml.annotation.base;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/9 17:16
 * @ProjectName communication
 * @Version 1.0.0
 */
@XmlRootElement(name = "root")
@XmlType(propOrder = {"msgHeader", "msgBody"})
public class PayApply extends BaseModel {

}
