package com.example.e_business.utility.module;

public class ItemsUpload {

    String imageUri;
    String product_nm;
    String product_pr;
    String product_dt;

    public ItemsUpload(){

    }

    public ItemsUpload(String imageUri, String product_nm, String product_pr, String product_dt) {
        this.imageUri = imageUri;
        this.product_nm = product_nm;
        this.product_pr = product_pr;
        this.product_dt = product_dt;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getProduct_Name() {
        return product_nm;
    }

    public void setProduct_Name(String product_nm) {
        this.product_nm = product_nm;
    }

    public String getProduct_Price() {
        return product_pr;
    }

    public void setProduct_Price(String product_pr) {
        this.product_pr = product_pr;
    }

    public String getProduct_Details() {
        return product_dt;
    }

    public void setProduct_Details(String product_dt) {
        this.product_dt = product_dt;
    }




}
