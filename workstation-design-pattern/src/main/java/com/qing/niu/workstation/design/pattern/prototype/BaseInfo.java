package com.qing.niu.workstation.design.pattern.prototype;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class BaseInfo {

    private String companyName;

    private String address;

    private Date date;

    public BaseInfo(String companyName, String address, Date date) {
        this.companyName = companyName;
        this.address = address;
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}
