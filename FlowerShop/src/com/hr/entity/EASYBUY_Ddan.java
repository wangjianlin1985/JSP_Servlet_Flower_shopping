// 
// 
// 

package com.hr.entity;

public class EASYBUY_Ddan
{
    private int EO_ID;
    private String EO_USER_ID;
    private String EP_NAME;
    private String EP_FILE_NAME;
    private int EP_PRICE;
    private int EOD_QUANTITY;
    private int EP_STOCK;
    
    public EASYBUY_Ddan(final int eOID, final String eOUSERID, final String ePNAME, final String ePFILENAME, final int ePPRICE, final int eODQUANTITY, final int ePSTOCK) {
        this.EO_ID = eOID;
        this.EO_USER_ID = eOUSERID;
        this.EP_NAME = ePNAME;
        this.EP_FILE_NAME = ePFILENAME;
        this.EP_PRICE = ePPRICE;
        this.EOD_QUANTITY = eODQUANTITY;
        this.EP_STOCK = ePSTOCK;
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
    
    public String getEP_NAME() {
        return this.EP_NAME;
    }
    
    public void setEP_NAME(final String ePNAME) {
        this.EP_NAME = ePNAME;
    }
    
    public String getEP_FILE_NAME() {
        return this.EP_FILE_NAME;
    }
    
    public void setEP_FILE_NAME(final String ePFILENAME) {
        this.EP_FILE_NAME = ePFILENAME;
    }
    
    public int getEP_PRICE() {
        return this.EP_PRICE;
    }
    
    public void setEP_PRICE(final int ePPRICE) {
        this.EP_PRICE = ePPRICE;
    }
    
    public int getEOD_QUANTITY() {
        return this.EOD_QUANTITY;
    }
    
    public void setEOD_QUANTITY(final int eODQUANTITY) {
        this.EOD_QUANTITY = eODQUANTITY;
    }
    
    public int getEP_STOCK() {
        return this.EP_STOCK;
    }
    
    public void setEP_STOCK(final int ePSTOCK) {
        this.EP_STOCK = ePSTOCK;
    }
}
