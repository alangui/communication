package com.qing.niu.workstation.web.communication.serialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * <p>
 *      终端商阿里报备接口
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/11/8
 */
@Getter
@Setter
@ToString(callSuper = true,exclude = {"cardNo","logonId"})
public class TerminalEntryAliReqDTO extends TerminalStoreInfoReqDTO{

    /**
     * 商户经营类目
     */
    @NotNull(message = "商户经营类目不能为null")
    @NotBlank(message = "商户经营类目不能为空")
    @Length(max = 32,message = "商户经营类目超过最大长度（32）")
    private String categoryId;

    /**
     * 支付宝商户编号
     */
    @NotBlank(message = "机构支付宝ID不能为空")
    @NotNull(message = "机构支付宝ID不能为null")
    @Length(max = 32,message = "机构支付宝ID超过最大长度（32）")
    private String aliPid;

    /**
     * 商户证件编号
     */
    private String businessLicense;

    /**
     * NATIONAL_LEGAL-营业执照、NATIONAL_LEGAL_MERGE-营业执照(多证合一)、INST_RGST_CTF：事业单位法人证书
     */
    private String businessLicenseType;

    /**
     * 联系人姓名
     */
    @NotBlank(message = "联系人姓名不能为空")
    @NotNull(message = "联系热姓名不能为null")
    @Length(max = 128,message = "联系人姓名超过最大长度（128）")
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactPhone;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 表示商户联系人的职责。异议处理接口人:02;商户关键联系人:06;数据反馈接口人:11;服务联动接口人:08
     */
    @NotBlank(message = "商户联系人职责不能为空")
    @NotNull(message = "商户联系人职责不能为null")
    @Length(max = 8,message = "商户联系人职责超过最大长度（8）")
    private String contactTag;

    /**
     * 联系人类型:LEGAL_PERSON-法人、CONTROLLER-实际控制人、AGENT-代理人、OTHER-其他
     */
    @NotBlank(message = "联系人类型不能为空")
    @NotNull(message = "联系人类型不能为null")
    @Length(max = 16,message = "联系人类型超过最大长度（16）")
    private String contactType;

    /**
     * 联系人身份证号
     */
    private String idCardNo;

    /**
     * 城市编码是与国家统计局一致
     */
    @NotBlank(message = "城市编码不能为空")
    @NotNull(message = "城市编码不能为null")
    @Length(max = 16,message = "城市编码超过最大长度（16）")
    private String cityCode;

    /**
     * 区县编码是与国家统计局一致
     */
    @NotBlank(message = "区县编码不能为空")
    @NotNull(message = "区县编码不能为null")
    @Length(max = 16,message = "区县编码超过最大长度（16）")
    private String districtCode;

    /**
     * 商户详细经营地址或人员所在地点
     */
    @NotBlank(message = "商户详细经营地址不能为空")
    @NotNull(message = "商户详细经营地址不能为null")
    @Length(max = 256,message = "商户详细经营地址超过最大长度（256）")
    private String storeAddress;

    /**
     * 省份编码是与国家统计局一致
     */
    @NotBlank(message = "省份编码不能为空")
    @NotNull(message = "省份编码不能为null")
    @Length(max = 16,message = "省份编码超过最大长度（16）")
    private String provinceCode;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 维度
     */
    private String latitude;

    /**
     * BUSINESS_ADDRESS-经营地址
     */
    private String addressType;

    /**
     * 商户结算卡银行卡卡号
     */
    @NotBlank(message = "商户结算卡卡号不能为空")
    @NotNull(message = "商户结算卡卡号不能为null")
    @Length(max = 32,message = "商户结算卡卡号超过最大长度（32）")
    private String cardNo;

    /**
     * 商户结算卡银行卡持卡人姓名
     */
    @NotBlank(message = "商户结算卡持卡人不能为空")
    @NotNull(message = "商户结算卡持卡人不能为null")
    @Length(max = 128,message = "商户结算卡持卡人超过最大长度（128）")
    private String cardName;

    /**
     * 商户的支付二维码信息，用于营销活动
     */
    private String payCodeInfo;

    /**
     * 商户的支付宝账号
     */
    @NotBlank(message = "商户的支付宝账号不能为空")
    @NotNull(message = "商户的支付宝账号不能为null")
    @Length(max = 128,message = "商户的支付宝账号超过最大长度（128）")
    private String logonId;

    /**
     * 备注信息
     */
    private String memo;
}
