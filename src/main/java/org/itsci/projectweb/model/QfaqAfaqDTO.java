package org.itsci.projectweb.model;

public class QfaqAfaqDTO {
    private String afaqtext;
    private String qfaqtext;
    private int topicid;

    public QfaqAfaqDTO(){

    }

    public QfaqAfaqDTO(String afaqtext, String qfaqtext, int topicid) {
        this.afaqtext = afaqtext;
        this.qfaqtext = qfaqtext;
        this.topicid = topicid;
    }

    public String getAfaqtext() {
        return afaqtext;
    }

    public void setAfaqtext(String afaqtext) {
        this.afaqtext = afaqtext;
    }

    public String getQfaqtext() {
        return qfaqtext;
    }

    public void setQfaqtext(String qfaqtext) {
        this.qfaqtext = qfaqtext;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

}
