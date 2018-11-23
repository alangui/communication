package com.qing.niu.communication.serialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/11/8
 */
@Getter
@Setter
@ToString
public class TerminalStoreInfoReqDTO implements Serializable{
    private static final long serialVersionUID = -502367708356312601L;

    /**
     * 代理商商户号
     */
    private String agentMerchantNo;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 商户名称
     */
    @NotBlank(message = "商户名称不能为空")
    @NotNull(message = "商户名称不能为null")
    @Length(max = 128,message = "商户名称超过最大长度（128）")
    private String merchantName;

    /**
     * 商户简称
     */
    @NotBlank(message = "商户简称不能为空")
    @NotNull(message = "商户简称不能为null")
    @Length(max = 64,message = "商户简称超过最大长度（64）")
    private String aliasName;

    /**
     * 商户客服电话
     */
    @NotBlank(message = "商户客服电话不能为空")
    @NotNull(message = "商户客服电话不能为null")
    @Length(max = 64,message = "商户客服电话超过最大长度（64）")
    private String servicePhone;

    /**
     * 门店地址
     */
    private String storeAddress;

    /**
     * 门店联系人
     */
    private String storeContactName;

    /**
     * 门店信息简介，300个字以内
     */
    private String introduction;

    /**
     * 营业时间(24 小时制表示，用“-”连接，如 8:00-20:00)
     */
    private String openTime;

    /**
     * 人均消费
     */
    private Integer avgPrice;

    /**
     * 门店分账银行卡号
     */
    private String storeCardNo;

    /**
     * 门店分账银行卡持卡人姓名
     */
    private String storeCardName;

    /**
     * 进件来源系统（CMS、GATEWAY、OMS）
     */
    private String requestSystem;

    /**
     * 操作人
     */
    private String operator;
}
