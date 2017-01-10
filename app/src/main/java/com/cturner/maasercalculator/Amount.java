package com.cturner.maasercalculator;

/**
 * Created by cturner on 1/3/2017.
 */
public class Amount {

    private Double amount;
    private Double maaserAmount;
    private Boolean paid = false;

    public Amount(Double amount, Double maaserAmount){
        this.amount = amount;
        this.maaserAmount = maaserAmount;
    }

    public Double getMaaserAmount() {
        return maaserAmount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(){
        paid = true;
    }

    public Double getAmount() {
        return amount;
    }
}
