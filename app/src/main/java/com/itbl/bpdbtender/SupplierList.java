package com.itbl.bpdbtender;

public class SupplierList {
    private String expiry_date;
    private String ref_date;
    private String sup_name;
    private String bank_name;
    private String ts_ref_no;
    private String bi_desc;
    private String ts_value;
    private String issue_date;
    private String ref_no;
    private String price;
    private String pkg_name;
    private String bracnh_name;
    private String currency;
   // ref_date,sup_name,bank_name,ts_ref_no,bi_desc,ts_value,issue_date,ref_no,price,pkg_name,bracnh_name,currency;


    public SupplierList(String expiry_date, String ref_date, String sup_name, String bank_name, String ts_ref_no, String bi_desc,
                        String ts_value, String issue_date, String ref_no, String price, String pkg_name,
                        String bracnh_name, String currency) {
        this.expiry_date = expiry_date;
        this.ref_date = ref_date;
        this.sup_name = sup_name;
        this.bank_name = bank_name;
        this.ts_ref_no = ts_ref_no;
        this.bi_desc = bi_desc;
        this.ts_value = ts_value;
        this.issue_date = issue_date;
        this.ref_no = ref_no;
        this.price = price;
        this.pkg_name = pkg_name;
        this.bracnh_name = bracnh_name;
        this.currency = currency;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getTs_ref_no() {
        return ts_ref_no;
    }

    public void setTs_ref_no(String ts_ref_no) {
        this.ts_ref_no = ts_ref_no;
    }

    public String getBi_desc() {
        return bi_desc;
    }

    public void setBi_desc(String bi_desc) {
        this.bi_desc = bi_desc;
    }

    public String getTs_value() {
        return ts_value;
    }

    public void setTs_value(String ts_value) {
        this.ts_value = ts_value;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getRef_no() {
        return ref_no;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public String getBracnh_name() {
        return bracnh_name;
    }

    public void setBracnh_name(String bracnh_name) {
        this.bracnh_name = bracnh_name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
