// 
// 
// 

package com.hr.entity;

public class EASYBUY_ORDER_DETAIL
{
    private int EOD_ID;
    private int EO_ID;
    private int EP_ID;
    private int EOD_QUANTITY;
    private int EOD_COST;
    
    public EASYBUY_ORDER_DETAIL(final int eODID, final int eOID, final int ePID, final int eODQUANTITY, final int eODCOST) {
        this.EOD_ID = eODID;
        this.EO_ID = eOID;
        this.EP_ID = ePID;
        this.EOD_QUANTITY = eODQUANTITY;
        this.EOD_COST = eODCOST;
    }
    
    public int getEOD_ID() {
        return this.EOD_ID;
    }
    
    public void setEOD_ID(final int eODID) {
        this.EOD_ID = eODID;
    }
    
    public int getEO_ID() {
        return this.EO_ID;
    }
    
    public void setEO_ID(final int eOID) {
        this.EO_ID = eOID;
    }
    
    public int getEP_ID() {
        return this.EP_ID;
    }
    
    public void setEP_ID(final int ePID) {
        this.EP_ID = ePID;
    }
    
    public int getEOD_QUANTITY() {
        return this.EOD_QUANTITY;
    }
    
    public void setEOD_QUANTITY(final int eODQUANTITY) {
        this.EOD_QUANTITY = eODQUANTITY;
    }
    
    public int getEOD_COST() {
        return this.EOD_COST;
    }
    
    public void setEOD_COST(final int eODCOST) {
        this.EOD_COST = eODCOST;
    }
}
