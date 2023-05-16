// 
// 
// 

package com.hr.entity;

public class EASYBUY_COMMENT
{
    private int EC_ID;
    private String EC_CONTENT;
    private String EC_CREATE_TIME;
    private String EC_REPLY;
    private String EC_REPLY_TIME;
    private String EC_NICK_NAME;
    
    public EASYBUY_COMMENT(final int eCID, final String eCCONTENT, final String eCCREATETIME, final String eCREPLY, final String eCREPLYTIME, final String eCNICKNAME) {
        this.EC_ID = eCID;
        this.EC_CONTENT = eCCONTENT;
        this.EC_CREATE_TIME = eCCREATETIME;
        this.EC_REPLY = eCREPLY;
        this.EC_REPLY_TIME = eCREPLYTIME;
        this.EC_NICK_NAME = eCNICKNAME;
    }
    
    public EASYBUY_COMMENT() {
    }
    
    public int getEC_ID() {
        return this.EC_ID;
    }
    
    public void setEC_ID(final int eCID) {
        this.EC_ID = eCID;
    }
    
    public String getEC_CONTENT() {
        return this.EC_CONTENT;
    }
    
    public void setEC_CONTENT(final String eCCONTENT) {
        this.EC_CONTENT = eCCONTENT;
    }
    
    public String getEC_CREATE_TIME() {
        return this.EC_CREATE_TIME;
    }
    
    public void setEC_CREATE_TIME(final String eCCREATETIME) {
        this.EC_CREATE_TIME = eCCREATETIME;
    }
    
    public String getEC_REPLY() {
        return this.EC_REPLY;
    }
    
    public void setEC_REPLY(final String eCREPLY) {
        this.EC_REPLY = eCREPLY;
    }
    
    public String getEC_REPLY_TIME() {
        return this.EC_REPLY_TIME;
    }
    
    public void setEC_REPLY_TIME(final String eCREPLYTIME) {
        this.EC_REPLY_TIME = eCREPLYTIME;
    }
    
    public String getEC_NICK_NAME() {
        return this.EC_NICK_NAME;
    }
    
    public void setEC_NICK_NAME(final String eCNICKNAME) {
        this.EC_NICK_NAME = eCNICKNAME;
    }
}
