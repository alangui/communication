package com.qing.niu.workstation.spring.model;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/5/30
 */
public class WithholdReqDTO {

    static {
        System.out.println("WithholdReqDTO class initial");
    }

    public String tradeNo;

    public WithholdReqDTO() {
        System.out.println("WithholdReqDTO 无参构造实例化实例化");
    }

    public WithholdReqDTO(String tradeNo) {
        System.out.println("WithholdReqDTO 实例化");
        this.tradeNo = tradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
