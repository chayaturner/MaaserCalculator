package com.cturner.maasercalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import java.util.ArrayList;


// CheckViews:
// http://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html

public class MainActivity extends AppCompatActivity {

    EditText input;
    private Maaser maaser;
    private final String mKey = "MAASER";
    private CheckListAdapter mAdapter;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You paid your maaser!", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();

                //get all checked items
                SparseBooleanArray checkedAmounts = mListView.getCheckedItemPositions();

                for(int i = 0; i < checkedAmounts.size(); i++){
                   if(checkedAmounts.get(i)) {
                       maaser.getMaaserAmountsList().set(i, 0.0); //sets checked to 0\
                   }
                }
                //arraylist to hold "0" to remove all 0's from maaser list
                ArrayList<Double> list = new ArrayList<Double>();
                list.add(0.0);
                maaser.getMaaserAmountsList().removeAll(list);

                mAdapter.notifyDataSetChanged();
            }
        });

        if(savedInstanceState != null){
            maaser = restoreFromJSon(savedInstanceState.getString(mKey));
        } else {
            maaser = new Maaser();
        }

        displayListView();
    }

    private void displayListView() {
        mAdapter = new CheckListAdapter(this, R.layout.list_layout, maaser.getMaaserAmountsList());
        mListView = (ListView)findViewById(R.id.maaserList);
        //set the adapter for the listView
        mListView.setAdapter(mAdapter);
        //Enable checkboxes more than one at a time
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }


    private Maaser restoreFromJSon(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Maaser.class);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(mKey, getJSONof(maaser));
    }

    @Override
    protected void onPause(){
        super.onPause();

        SharedPreferences preferences = getSharedPreferences(mKey, MODE_PRIVATE);

        // Create an Editor object to write changes to the preferences object above
        SharedPreferences.Editor editor = preferences.edit();

        // clear whatever was set last time
        editor.clear();

        // save autoSave preference
        editor.putString(mKey, getJSONof(maaser));
        editor.apply();

    }

    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences preferences = getSharedPreferences(mKey, MODE_PRIVATE);

        // Create an Editor object to write changes to the preferences object above
        SharedPreferences.Editor editor = preferences.edit();

        // clear whatever was set last time
        editor.clear();

        // save autoSave preference
        editor.putString(mKey, getJSONof(maaser));
        editor.apply();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        maaser = restoreFromJSon(savedInstanceState.getString(mKey));
    }

    private String getJSONof(Maaser maaser) {
        Gson gson = new Gson();
        return gson.toJson(maaser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateClick(View view) {

        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        group.getCheckedRadioButtonId();

        EditText editText = (EditText) findViewById(R.id.amountText);

            Double amount = Double.parseDouble(editText.getText().toString());

            switch (group.getCheckedRadioButtonId()){
                case R.id.radioButton10:
                    Amount a = new Amount(amount, amount*.10);
                    maaser.addMaaserAmount(amount * 0.10);
                    break;
                case R.id.radioButton15:
                    maaser.addMaaserAmount(amount * 0.15);
                    break;
                case R.id.radioButton20:
                    maaser.addMaaserAmount(amount * 0.20);
                    break;
            }

        //let adapter know that data has changed
        mAdapter.notifyDataSetChanged();
    }


}
