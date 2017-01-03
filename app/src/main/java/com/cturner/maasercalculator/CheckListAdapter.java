package com.cturner.maasercalculator;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * Created by cturner on 1/3/2017.
 */

public class CheckListAdapter extends ArrayAdapter<Double>{
    private ArrayList<Double> maaserList;

    public CheckListAdapter(Context context, int textViewResourceId,
                           ArrayList<Double> maaserList) {
        super(context, textViewResourceId, maaserList);
        this.maaserList = new ArrayList<Double>();
        this.maaserList.addAll(maaserList);
    }
}
