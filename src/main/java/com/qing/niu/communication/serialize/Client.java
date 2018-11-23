package com.qing.niu.communication.serialize;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/11/23
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        TerminalEntryAliReqDTO terminalEntryAliReqDTO = new TerminalEntryAliReqDTO();
        terminalEntryAliReqDTO.setAgentMerchantNo("8000100023");
        terminalEntryAliReqDTO.setMerchantNo(null);
        terminalEntryAliReqDTO.setMerchantName("大润发宝山路店");
        terminalEntryAliReqDTO.setAliasName("大润发");
        terminalEntryAliReqDTO.setServicePhone("010-0000000");
        terminalEntryAliReqDTO.setStoreContactName("huqingniu");
        terminalEntryAliReqDTO.setIntroduction("11212");
        terminalEntryAliReqDTO.setOpenTime("2122");
        terminalEntryAliReqDTO.setAvgPrice(1);
        terminalEntryAliReqDTO.setStoreCardNo("00900909990");
        terminalEntryAliReqDTO.setStoreCardName("马克");
        terminalEntryAliReqDTO.setRequestSystem("GATEWAY");
        terminalEntryAliReqDTO.setOperator("SYSTEM");

        terminalEntryAliReqDTO.setCategoryId("2015050700000000");
        terminalEntryAliReqDTO.setAliPid("test");
        terminalEntryAliReqDTO.setBusinessLicense("88888888");
        terminalEntryAliReqDTO.setBusinessLicenseType("NATIONAL_LEGAL");
        terminalEntryAliReqDTO.setContactName("huqingniu");
        terminalEntryAliReqDTO.setContactPhone("010-000000000");
        terminalEntryAliReqDTO.setMobile("15688888888");
        terminalEntryAliReqDTO.setContactTag("06");
        terminalEntryAliReqDTO.setContactType("LEGAL_PERSON");
        terminalEntryAliReqDTO.setIdCardNo("872767687524621");
        terminalEntryAliReqDTO.setCityCode("00001");
        terminalEntryAliReqDTO.setDistrictCode("000001");
        terminalEntryAliReqDTO.setStoreAddress("上海市浦东新区宝山路100号");
        terminalEntryAliReqDTO.setProvinceCode("001");
        terminalEntryAliReqDTO.setLongitude("120");
        terminalEntryAliReqDTO.setLatitude("68");
        terminalEntryAliReqDTO.setAddressType("BUSINESS_ADDRESS");
        terminalEntryAliReqDTO.setCardName("马克");
        terminalEntryAliReqDTO.setPayCodeInfo("www.yinxiao.com");
        terminalEntryAliReqDTO.setMemo("大型购物连锁超市");
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:/TerminalEntryAli.txt")));
            oo.writeObject(terminalEntryAliReqDTO);
            log.info("序列化完成！");
            oo.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/TerminalEntryAli.txt")));
            TerminalEntryAliReqDTO reqDTO = (TerminalEntryAliReqDTO) ois.readObject();
            log.info("反序列化完成！");
            log.info("{}",reqDTO);
        } catch (IOException | ClassNotFoundException e) {
            log.info("{}", Throwables.getStackTraceAsString(e));
        }
    }


}
