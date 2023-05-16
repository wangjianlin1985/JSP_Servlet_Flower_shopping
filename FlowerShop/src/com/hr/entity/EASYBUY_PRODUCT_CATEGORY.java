// 
// 
// 

package com.hr.entity;

public class EASYBUY_PRODUCT_CATEGORY
{
    private int EPC_ID;
    private String EPC_NAME;
    private int EPC_PARENT_ID;
    
    public EASYBUY_PRODUCT_CATEGORY(final int ePCID, final String ePCNAME, final int ePCPARENTID) {
        this.EPC_ID = ePCID;
        this.EPC_NAME = ePCNAME;
        this.EPC_PARENT_ID = ePCPARENTID;
    }
    
    public int getEPC_ID() {
        return this.EPC_ID;
    }
    
    public void setEPC_ID(final int ePCID) {
        this.EPC_ID = ePCID;
    }
    
    public String getEPC_NAME() {
        return this.EPC_NAME;
    }
    
    public void setEPC_NAME(final String ePCNAME) {
        this.EPC_NAME = ePCNAME;
    }
    
    public int getEPC_PARENT_ID() {
        return this.EPC_PARENT_ID;
    }
    
    public void setEPC_PARENT_ID(final int ePCPARENTID) {
        this.EPC_PARENT_ID = ePCPARENTID;
    }
}
