// 
// 
// 

package com.hr.entity;

public class EASYBUY_USER
{
    private String EU_USER_ID;
    private String EU_USER_NAME;
    private String EU_PASSWORD;
    private String EU_SEX;
    private String EU_BIRTHDAY;
    private String EU_IDENTITY_CODE;
    private String EU_EMAIL;
    private String EU_MOBILE;
    private String EU_ADDRESS;
    private int EU_STATUS;
    
    public EASYBUY_USER(final String eUUSERID, final String eUUSERNAME, final String eUPASSWORD, final String eUSEX, final String eUBIRTHDAY, final String eUIDENTITYCODE, final String eUEMAIL, final String eUMOBILE, final String eUADDRESS, final int eUSTATUS) {
        this.EU_USER_ID = eUUSERID;
        this.EU_USER_NAME = eUUSERNAME;
        this.EU_PASSWORD = eUPASSWORD;
        this.EU_SEX = eUSEX;
        this.EU_BIRTHDAY = eUBIRTHDAY;
        this.EU_IDENTITY_CODE = eUIDENTITYCODE;
        this.EU_EMAIL = eUEMAIL;
        this.EU_MOBILE = eUMOBILE;
        this.EU_ADDRESS = eUADDRESS;
        this.EU_STATUS = eUSTATUS;
    }
    
    public String getEU_USER_ID() {
        return this.EU_USER_ID;
    }
    
    public void setEU_USER_ID(final String eUUSERID) {
        this.EU_USER_ID = eUUSERID;
    }
    
    public String getEU_USER_NAME() {
        return this.EU_USER_NAME;
    }
    
    public void setEU_USER_NAME(final String eUUSERNAME) {
        this.EU_USER_NAME = eUUSERNAME;
    }
    
    public String getEU_PASSWORD() {
        return this.EU_PASSWORD;
    }
    
    public void setEU_PASSWORD(final String eUPASSWORD) {
        this.EU_PASSWORD = eUPASSWORD;
    }
    
    public String getEU_SEX() {
        return this.EU_SEX;
    }
    
    public void setEU_SEX(final String eUSEX) {
        this.EU_SEX = eUSEX;
    }
    
    public String getEU_BIRTHDAY() {
        return this.EU_BIRTHDAY;
    }
    
    public void setEU_BIRTHDAY(final String eUBIRTHDAY) {
        this.EU_BIRTHDAY = eUBIRTHDAY;
    }
    
    public String getEU_IDENTITY_CODE() {
        return this.EU_IDENTITY_CODE;
    }
    
    public void setEU_IDENTITY_CODE(final String eUIDENTITYCODE) {
        this.EU_IDENTITY_CODE = eUIDENTITYCODE;
    }
    
    public String getEU_EMAIL() {
        return this.EU_EMAIL;
    }
    
    public void setEU_EMAIL(final String eUEMAIL) {
        this.EU_EMAIL = eUEMAIL;
    }
    
    public String getEU_MOBILE() {
        return this.EU_MOBILE;
    }
    
    public void setEU_MOBILE(final String eUMOBILE) {
        this.EU_MOBILE = eUMOBILE;
    }
    
    public String getEU_ADDRESS() {
        return this.EU_ADDRESS;
    }
    
    public void setEU_ADDRESS(final String eUADDRESS) {
        this.EU_ADDRESS = eUADDRESS;
    }
    
    public int getEU_STATUS() {
        return this.EU_STATUS;
    }
    
    public void setEU_STATUS(final int eUSTATUS) {
        this.EU_STATUS = eUSTATUS;
    }
}
