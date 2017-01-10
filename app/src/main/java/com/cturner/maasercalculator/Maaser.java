package com.cturner.maasercalculator;

import java.util.ArrayList;

/**
 * Created by cturner on 1/3/2017.
 */

public class Maaser {

    ArrayList<Double> maaserAmounts;

    public Maaser(){
        maaserAmounts = new ArrayList<Double>();
    }

    public void addMaaserAmount(Double amount){
        maaserAmounts.add(amount);
    }

    public void deleteMaaserAmount(Double amount){
        int index = maaserAmounts.indexOf(amount);
            maaserAmounts.remove(index);
    }

    public ArrayList<Double> getMaaserAmountsList() {
        return maaserAmounts;
    }

    public void removeMaaserAmount(int index){
        maaserAmounts.remove(index);
    }

}
