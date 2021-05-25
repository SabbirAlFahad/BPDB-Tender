package com.itbl.bpdbtender;

public class TenderPkgInfoList {

    private String sf_des;
    private String est_cost;
    private String curr_name;
    private String dist_DESC;
    private String thana_DESC;
    private String div_DESC;

    public TenderPkgInfoList(String sf_des, String est_cost, String curr_name, String dist_DESC, String thana_DESC, String div_DESC) {
        this.sf_des = sf_des;
        this.est_cost = est_cost;
        this.curr_name = curr_name;
        this.dist_DESC = dist_DESC;
        this.thana_DESC = thana_DESC;
        this.div_DESC = div_DESC;
    }

    public String getSf_des() {
        return sf_des;
    }

    public void setSf_des(String sf_des) {
        this.sf_des = sf_des;
    }

    public String getEst_cost() {
        return est_cost;
    }

    public void setEst_cost(String est_cost) {
        this.est_cost = est_cost;
    }

    public String getCurr_name() {
        return curr_name;
    }

    public void setCurr_name(String curr_name) {
        this.curr_name = curr_name;
    }

    public String getDist_DESC() {
        return dist_DESC;
    }

    public void setDist_DESC(String dist_DESC) {
        this.dist_DESC = dist_DESC;
    }

    public String getThana_DESC() {
        return thana_DESC;
    }

    public void setThana_DESC(String thana_DESC) {
        this.thana_DESC = thana_DESC;
    }

    public String getDiv_DESC() {
        return div_DESC;
    }

    public void setDiv_DESC(String div_DESC) {
        this.div_DESC = div_DESC;
    }
}
