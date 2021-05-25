package com.itbl.bpdbtender;

public class ExpireHistory {

    private  Integer ref_no, show_proID;

    private  String  show_tname, show_expcname, show_expiryD, show_openD , show_expcurr, show_expstat;

    public Integer getRef_no(){
        return ref_no;
    }

    public void setRef_no(Integer ref_no){
        this.ref_no = ref_no;
    }

    public Integer getShow_proID(){
        return show_proID;
    }

    public void setShow_proID(Integer show_proID){
        this.show_proID = show_proID;
    }

    public String getShow_tname(){
        return show_tname;
    }

    public void setShow_tname(String show_tname){
        this.show_tname = show_tname;
    }

    public String getShow_expcname(){
        return show_expcname;
    }

    public void setShow_expcname(String show_expcname){
        this.show_expcname = show_expcname;
    }

    public String getShow_expiryD(){
        return show_expiryD;
    }

    public void setShow_expiryD(String show_expiryD){
        this.show_expiryD = show_expiryD;
    }

    public String getShow_openD(){
        return show_openD;
    }

    public void setShow_openD(String show_openD){
        this.show_openD = show_openD;
    }

    public String getShow_expcurr(){
        return show_expcurr;
    }

    public void setShow_expcurr(String show_expcurr){
        this.show_expcurr = show_expcurr;
    }

    public String getShow_expstat(){
        return show_expstat;
    }

    public void setShow_expstat(String show_expstat){
        this.show_expstat = show_expstat;
    }

    public ExpireHistory( String show_tname,Integer show_proID,String show_expcurr, String show_openD,Integer ref_no,  String show_expiryD,String show_expcname, String show_expstat){

        this.setShow_tname(show_tname);
        this.setShow_proID(show_proID);
        this.setShow_expcurr(show_expcurr);
        this.setShow_openD(show_openD);
        this.setRef_no(ref_no);
        this.setShow_expiryD(show_expiryD);
        this.setShow_expcname(show_expcname);
        this.setShow_expstat(show_expstat);
    }
}
