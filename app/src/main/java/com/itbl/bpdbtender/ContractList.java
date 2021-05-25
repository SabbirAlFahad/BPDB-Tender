package com.itbl.bpdbtender;

public class ContractList{
    private String contract_currType;
    private String contract_price;
    private String contract_value;
    private String contract_No;
    private String contract_issueD;
    private String contract_type;
    private String contract_pkgDetails;
    private String contract_bankName;
    private String contract_RefNo;
    private String contract_suppName;
    private String contract_securityInfo;
    private String contract_Date;
    private String contract_branchName;
    private String contract_expiryD;

    public ContractList(String contract_currType, String contract_price, String contract_value, String contract_No,
                        String contract_issueD, String contract_type, String contract_pkgDetails, String contract_bankName,
                        String contract_RefNo, String contract_suppName, String contract_securityInfo,
                        String contract_Date, String contract_branchName, String contract_expiryD){
        
        this.contract_currType = contract_currType;
        this.contract_price = contract_price;
        this.contract_value = contract_value;
        this.contract_No = contract_No;
        this.contract_issueD = contract_issueD;
        this.contract_type = contract_type;
        this.contract_pkgDetails = contract_pkgDetails;
        this.contract_bankName = contract_bankName;
        this.contract_RefNo = contract_RefNo;
        this.contract_suppName = contract_suppName;
        this.contract_securityInfo = contract_securityInfo;
        this.contract_Date = contract_Date;
        this.contract_branchName = contract_branchName;
        this.contract_expiryD = contract_expiryD;
    }

    public String getContract_currType() {
        return contract_currType;
    }

    public void setContract_currType(String contract_currType) {
        this.contract_currType = contract_currType;
    }

    public String getContract_price() {
        return contract_price;
    }

    public void setContract_price(String contract_price) {
        this.contract_price = contract_price;
    }

    public String getContract_value() {
        return contract_value;
    }

    public void setContract_value(String contract_value) {
        this.contract_value = contract_value;
    }

    public String getContract_No() {
        return contract_No;
    }

    public void setContract_No(String contract_No) {
        this.contract_No = contract_No;
    }

    public String getContract_issueD() {
        return contract_issueD;
    }

    public void setContract_issueD(String contract_issueD) {
        this.contract_issueD = contract_issueD;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getContract_pkgDetails() {
        return contract_pkgDetails;
    }

    public void setContract_pkgDetails(String contract_pkgDetails) {
        this.contract_pkgDetails = contract_pkgDetails;
    }

    public String getContract_bankName() {
        return contract_bankName;
    }

    public void setContract_bankName(String contract_bankName) {
        this.contract_bankName = contract_bankName;
    }

    public String getContract_RefNo() {
        return contract_RefNo;
    }

    public void setContract_RefNo(String contract_RefNo) {
        this.contract_RefNo = contract_RefNo;
    }

    public String getContract_suppName() {
        return contract_suppName;
    }

    public void setContract_suppName(String contract_suppName) {
        this.contract_suppName = contract_suppName;
    }

    public String getContract_securityInfo() {
        return contract_securityInfo;
    }

    public void setContract_securityInfo(String contract_securityInfo) {
        this.contract_securityInfo = contract_securityInfo;
    }

    public String getContract_Date() {
        return contract_Date;
    }

    public void setContract_Date(String contract_Date) {
        this.contract_Date = contract_Date;
    }

    public String getContract_branchName() {
        return contract_branchName;
    }

    public void setContract_branchName(String contract_branchName) {
        this.contract_branchName = contract_branchName;
    }

    public String getContract_expiryD() {
        return contract_expiryD;
    }

    public void setContract_expiryD(String contract_expiryD) {
        this.contract_expiryD = contract_expiryD;
    }
}
