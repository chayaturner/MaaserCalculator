package com.cturner.maasercalculator;

import java.util.ArrayList;

/**
 * Created by cturner on 1/3/2017.
 */

public class Maaser {

    ArrayList<Double> amounts;
    ArrayList<Double> maaserAmounts;
    Double totalAmounts;
    Double totalMaaserAmounts;

    public Maaser(){
        amounts = new ArrayList<Double>();
        maaserAmounts = new ArrayList<Double>();
        totalAmounts = 0.0;
        totalMaaserAmounts = 0.0;
    }

    public void addAmount(Double amount){
        amounts.add(amount);
        totalAmounts += amount;
    }

    public void addMaaserAmount(Double amount){
        maaserAmounts.add(amount);
        totalMaaserAmounts += amount;
    }

    public void deleteAmount(Double amount){
        int index = amounts.indexOf(amount);
        amounts.remove(index);
        totalAmounts -= amount;
    }

    public void deleteMaaserAmount(Double amount){
        int index = maaserAmounts.indexOf(amount);
            maaserAmounts.remove(index);
            totalMaaserAmounts -= amount;
    }

    public Double getTotalAmounts(){
        return totalAmounts;
    }
    public Double getTotalMaaserAmounts(){ return totalMaaserAmounts;}

    public ArrayList<Double> getAmountList(){
        return amounts;
    }
    public ArrayList<Double> getMaaserAmountList(){return maaserAmounts;}

}
