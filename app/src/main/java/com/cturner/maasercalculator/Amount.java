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


}
