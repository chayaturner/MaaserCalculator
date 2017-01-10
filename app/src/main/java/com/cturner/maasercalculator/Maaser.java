package com.cturner.maasercalculator;

import java.util.ArrayList;

/**
 * Created by cturner on 1/3/2017.
 */

public class Maaser {

    ArrayList<Double> maaserAmounts;
    Double totalMaaserAmounts;

    public Maaser(){
        maaserAmounts = new ArrayList<Double>();
        totalMaaserAmounts = 0.0;
    }

    public void addMaaserAmount(Double amount){
        maaserAmounts.add(amount);
        totalMaaserAmounts += amount;
    }

    public void deleteMaaserAmount(Double amount){
        int index = maaserAmounts.indexOf(amount);
            maaserAmounts.remove(index);
            totalMaaserAmounts -= amount;
    }

    public Double getTotalMaaserAmounts(){ return totalMaaserAmounts;}

    public ArrayList<Double> getMaaserAmountsList() {
        return maaserAmounts;
    }

    public void removeMaaserAmount(int index){
        totalMaaserAmounts -= maaserAmounts.get(index);
        maaserAmounts.remove(index);
    }

}
