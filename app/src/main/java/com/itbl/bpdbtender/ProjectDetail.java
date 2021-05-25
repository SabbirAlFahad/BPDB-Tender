package com.itbl.bpdbtender;

public class ProjectDetail {

    private String ref_date;
    private String cntr_code;
    private String opening_date;
    private String pkg_no;
    private String location;
    private String fc_curr;
    private String pkgName;
    private String ref_no;
    private String pkj_id;
    private String curr_name;
    private String closing_date;

    public ProjectDetail(String ref_date, String cntr_code, String opening_date, String pkg_no,
                         String location, String fc_curr, String pkgName, String ref_no, String curr_name,String pkj_id,
                         String closing_date) {
        this.ref_date = ref_date;
        this.cntr_code = cntr_code;
        this.opening_date = opening_date;
        this.pkg_no = pkg_no;
        this.location = location;
        this.fc_curr = fc_curr;
        this.pkgName = pkgName;
        this.ref_no = ref_no;
        this.curr_name = curr_name;
        this.pkj_id = pkj_id;
        this.closing_date = closing_date;
    }

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public String getCntr_code() {
        return cntr_code;
    }

    public void setCntr_code(String cntr_code) {
        this.cntr_code = cntr_code;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public String getPkj_id() {
        return pkj_id;
    }

    public void setPkj_id(String pkj_id) {
        this.pkj_id = pkj_id;
    }

    public void setOpening_date(String opening_date) {
        this.opening_date = opening_date;
    }

    public String getPkg_no() {
        return pkg_no;
    }

    public void setPkg_no(String pkg_no) {
        this.pkg_no = pkg_no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFc_curr() {
        return fc_curr;
    }

    public void setFc_curr(String fc_curr) {
        this.fc_curr = fc_curr;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getRef_no() {
        return ref_no;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public String getCurr_name() {
        return curr_name;
    }

    public void setCurr_name(String curr_name) {
        this.curr_name = curr_name;
    }

    public String getClosing_date() {
        return closing_date;
    }

    public void setClosing_date(String closing_date) {
        this.closing_date = closing_date;
    }
}
