// 
// 
// 

package com.hr.entity;

public class EASYBUY_NEWS
{
    private int EN_ID;
    private String EN_TITLE;
    private String EN_CONTENT;
    private String EN_CREATE_TIME;
    
    public EASYBUY_NEWS(final int eNID, final String eNTITLE, final String eNCONTENT, final String eNCREATETIME) {
        this.EN_ID = eNID;
        this.EN_TITLE = eNTITLE;
        this.EN_CONTENT = eNCONTENT;
        this.EN_CREATE_TIME = eNCREATETIME;
    }
    
    public int getEN_ID() {
        return this.EN_ID;
    }
    
    public void setEN_ID(final int eNID) {
        this.EN_ID = eNID;
    }
    
    public String getEN_TITLE() {
        return this.EN_TITLE;
    }
    
    public void setEN_TITLE(final String eNTITLE) {
        this.EN_TITLE = eNTITLE;
    }
    
    public String getEN_CONTENT() {
        return this.EN_CONTENT;
    }
    
    public void setEN_CONTENT(final String eNCONTENT) {
        this.EN_CONTENT = eNCONTENT;
    }
    
    public String getEN_CREATE_TIME() {
        return this.EN_CREATE_TIME;
    }
    
    public void setEN_CREATE_TIME(final String eNCREATETIME) {
        this.EN_CREATE_TIME = eNCREATETIME;
    }
}
