package org.itsci.projectweb.model;

public class AfaqQfaqDTO {
    private String afaqtext;

    private int qfaqid;

    public AfaqQfaqDTO (){

    }

    public AfaqQfaqDTO(String afaqtext, int qfaqid) {
        this.afaqtext = afaqtext;
        this.qfaqid = qfaqid;
    }

    public String getAfaqtext() {
        return afaqtext;
    }

    public void setAfaqtext(String afaqtext) {
        this.afaqtext = afaqtext;
    }

    public int getQfaqid() {
        return qfaqid;
    }

    public void setQfaqid(int qfaqid) {
        this.qfaqid = qfaqid;
    }
}
