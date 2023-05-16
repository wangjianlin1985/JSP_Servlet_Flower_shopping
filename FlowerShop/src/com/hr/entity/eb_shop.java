// 
// 
// 

package com.hr.entity;

public class eb_shop
{
    public int es_id;
    public String es_ep_file_name;
    public String es_ep_name;
    public int es_ep_price;
    public int es_eod_quantity;
    public int es_ep_stock;
    public int es_ep_id;
    public String es_EU_USER_ID;
    public int ea_valid;
    
    public eb_shop(final int esId, final String esEpFileName, final String esEpName, final int esEpPrice, final int esEodQuantity, final int esEpStock, final int esEpId, final String esEUUSERID, final int eaValid) {
        this.es_id = esId;
        this.es_ep_file_name = esEpFileName;
        this.es_ep_name = esEpName;
        this.es_ep_price = esEpPrice;
        this.es_eod_quantity = esEodQuantity;
        this.es_ep_stock = esEpStock;
        this.es_ep_id = esEpId;
        this.es_EU_USER_ID = esEUUSERID;
        this.ea_valid = eaValid;
    }
    
    public int getEs_id() {
        return this.es_id;
    }
    
    public void setEs_id(final int esId) {
        this.es_id = esId;
    }
    
    public String getEs_ep_file_name() {
        return this.es_ep_file_name;
    }
    
    public void setEs_ep_file_name(final String esEpFileName) {
        this.es_ep_file_name = esEpFileName;
    }
    
    public String getEs_ep_name() {
        return this.es_ep_name;
    }
    
    public void setEs_ep_name(final String esEpName) {
        this.es_ep_name = esEpName;
    }
    
    public int getEs_ep_price() {
        return this.es_ep_price;
    }
    
    public void setEs_ep_price(final int esEpPrice) {
        this.es_ep_price = esEpPrice;
    }
    
    public int getEs_eod_quantity() {
        return this.es_eod_quantity;
    }
    
    public void setEs_eod_quantity(final int esEodQuantity) {
        this.es_eod_quantity = esEodQuantity;
    }
    
    public int getEs_ep_stock() {
        return this.es_ep_stock;
    }
    
    public void setEs_ep_stock(final int esEpStock) {
        this.es_ep_stock = esEpStock;
    }
    
    public int getEs_ep_id() {
        return this.es_ep_id;
    }
    
    public void setEs_ep_id(final int esEpId) {
        this.es_ep_id = esEpId;
    }
    
    public String getEs_EU_USER_ID() {
        return this.es_EU_USER_ID;
    }
    
    public void setEs_EU_USER_ID(final String esEUUSERID) {
        this.es_EU_USER_ID = esEUUSERID;
    }
    
    public int getEa_valid() {
        return this.ea_valid;
    }
    
    public void setEa_valid(final int eaValid) {
        this.ea_valid = eaValid;
    }
}
