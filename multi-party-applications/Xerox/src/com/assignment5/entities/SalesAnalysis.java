/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

/**
 *
 * @author ketanmalik
 */
public class SalesAnalysis {

    private int productId;
    private int salePrice;
    private int targetPrice;
    private int priceDifference;
    private int totalProductsSold;
    private float error;

    public SalesAnalysis(int productId, int salePrice, int targetPrice, int priceDifference, int totalProductsSold, float error) {
        this.productId = productId;
        this.salePrice = salePrice;
        this.targetPrice = targetPrice;
        this.priceDifference = priceDifference;
        this.totalProductsSold = totalProductsSold;
        this.error = error;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(int priceDifference) {
        this.priceDifference = priceDifference;
    }

    public int getTotalProductsSold() {
        return totalProductsSold;
    }

    public void setTotalProductsSold(int totalProductsSold) {
        this.totalProductsSold = totalProductsSold;
    }

    public float getError() {
        return error;
    }

    public void setError(float error) {
        this.error = error;
    }

}
