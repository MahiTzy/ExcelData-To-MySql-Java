package com.dump.dumpingdemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer pID;
    private String pName;
    private Integer pPrice;
    private String pDesc;
    public Integer getpID() {
        return pID;
    }
    public void setpID(Integer pID) {
        this.pID = pID;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public Integer getpPrice() {
        return pPrice;
    }
    public void setpPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }
    public String getpDesc() {
        return pDesc;
    }
    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }
    public Product() {
    }
    public Product(Integer pID, String pName, Integer pPrice, String pDesc) {
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDesc = pDesc;
    }
    @Override
    public String toString() {
        return "Product [pID=" + pID + ", pName=" + pName + ", pPrice=" + pPrice + ", pDesc=" + pDesc + "]";
    }
    
}
