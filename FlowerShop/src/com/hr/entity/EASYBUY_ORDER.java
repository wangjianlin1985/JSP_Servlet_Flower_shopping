// 
// 
// 

package com.hr.entity;

public class EASYBUY_ORDER
{
    private int EO_ID;
    private String EO_USER_ID;
    private String EO_USER_NAME;
    private String EO_USER_ADDRESS;
    private String EO_CREATE_TIME;
    private int EO_COST;
    private int EO_STATUS;
    private int EO_TYPE;
    
    public String getOrderStatusStr() {
        if (this.EO_STATUS == 1) {
            return "\u5f85\u5ba1\u6838";
        }
        if (this.EO_STATUS == 2) {
            return "\u5ba1\u6838\u901a\u8fc7";
        }
        if (this.EO_STATUS == 3) {
            return "\u914d\u8d27";
        }
        if (this.EO_STATUS == 4) {
            return "\u53d1\u8d27";
        }
        return "\u786e\u8ba4\u6536\u8d27";
    }
    
    public EASYBUY_ORDER(final int eOID, final String eOUSERID, final String eOUSERNAME, final String eOUSERADDRESS, final String eOCREATETIME, final int eOCOST, final int eOSTATUS, final int eOTYPE) {
        this.EO_ID = eOID;
        this.EO_USER_ID = eOUSERID;
        this.EO_USER_NAME = eOUSERNAME;
        this.EO_USER_ADDRESS = eOUSERADDRESS;
        this.EO_CREATE_TIME = eOCREATETIME;
        this.EO_COST = eOCOST;
        this.EO_STATUS = eOSTATUS;
        this.EO_TYPE = eOTYPE;
    }
    
    public int getEO_ID() {
        return this.EO_ID;
    }
    
    public void setEO_ID(final int eOID) {
        this.EO_ID = eOID;
    }
    
    public String getEO_USER_ID() {
        return this.EO_USER_ID;
    }
    
    public void setEO_USER_ID(final String eOUSERID) {
        this.EO_USER_ID = eOUSERID;
    }
    
    public String getEO_USER_NAME() {
        return this.EO_USER_NAME;
    }
    
    public void setEO_USER_NAME(final String eOUSERNAME) {
        this.EO_USER_NAME = eOUSERNAME;
    }
    
    public String getEO_USER_ADDRESS() {
        return this.EO_USER_ADDRESS;
    }
    
    public void setEO_USER_ADDRESS(final String eOUSERADDRESS) {
        this.EO_USER_ADDRESS = eOUSERADDRESS;
    }
    
    public String getEO_CREATE_TIME() {
        return this.EO_CREATE_TIME;
    }
    
    public void setEO_CREATE_TIME(final String eOCREATETIME) {
        this.EO_CREATE_TIME = eOCREATETIME;
    }
    
    public int getEO_COST() {
        return this.EO_COST;
    }
    
    public void setEO_COST(final int eOCOST) {
        this.EO_COST = eOCOST;
    }
    
    public int getEO_STATUS() {
        return this.EO_STATUS;
    }
    
    public void setEO_STATUS(final int eOSTATUS) {
        this.EO_STATUS = eOSTATUS;
    }
    
    public int getEO_TYPE() {
        return this.EO_TYPE;
    }
    
    public void setEO_TYPE(final int eOTYPE) {
        this.EO_TYPE = eOTYPE;
    }
}
