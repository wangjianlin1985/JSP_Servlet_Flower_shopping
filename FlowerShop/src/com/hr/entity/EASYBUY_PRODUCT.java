// 
// 
// 

package com.hr.entity;

public class EASYBUY_PRODUCT
{
    private int EP_ID;
    private String EP_NAME;
    private String EP_DESCRIPTION;
    private int EP_PRICE;
    private int EP_STOCK;
    private int EPC_ID;
    private int EPC_CHILD_ID;
    private String EP_FILE_NAME;
    
    public EASYBUY_PRODUCT(final int ePID, final String ePNAME, final String ePDESCRIPTION, final int ePPRICE, final int ePSTOCK, final int ePCID, final int ePCCHILDID, final String ePFILENAME) {
        this.EP_ID = ePID;
        this.EP_NAME = ePNAME;
        this.EP_DESCRIPTION = ePDESCRIPTION;
        this.EP_PRICE = ePPRICE;
        this.EP_STOCK = ePSTOCK;
        this.EPC_ID = ePCID;
        this.EPC_CHILD_ID = ePCCHILDID;
        this.EP_FILE_NAME = ePFILENAME;
    }
    
    public int getEP_ID() {
        return this.EP_ID;
    }
    
    public void setEP_ID(final int ePID) {
        this.EP_ID = ePID;
    }
    
    public String getEP_NAME() {
        return this.EP_NAME;
    }
    
    public void setEP_NAME(final String ePNAME) {
        this.EP_NAME = ePNAME;
    }
    
    public String getEP_DESCRIPTION() {
        return this.EP_DESCRIPTION;
    }
    
    public void setEP_DESCRIPTION(final String ePDESCRIPTION) {
        this.EP_DESCRIPTION = ePDESCRIPTION;
    }
    
    public int getEP_PRICE() {
        return this.EP_PRICE;
    }
    
    public void setEP_PRICE(final int ePPRICE) {
        this.EP_PRICE = ePPRICE;
    }
    
    public int getEP_STOCK() {
        return this.EP_STOCK;
    }
    
    public void setEP_STOCK(final int ePSTOCK) {
        this.EP_STOCK = ePSTOCK;
    }
    
    public int getEPC_ID() {
        return this.EPC_ID;
    }
    
    public void setEPC_ID(final int ePCID) {
        this.EPC_ID = ePCID;
    }
    
    public int getEPC_CHILD_ID() {
        return this.EPC_CHILD_ID;
    }
    
    public void setEPC_CHILD_ID(final int ePCCHILDID) {
        this.EPC_CHILD_ID = ePCCHILDID;
    }
    
    public String getEP_FILE_NAME() {
        return this.EP_FILE_NAME;
    }
    
    public void setEP_FILE_NAME(final String ePFILENAME) {
        this.EP_FILE_NAME = ePFILENAME;
    }
}
