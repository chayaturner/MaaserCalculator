package com.cturner.maasercalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        mAdapter = new CheckListAdapter(this, R.layout.list_layout, maaser.getList());
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
                maaser.addAmount(amount);
                maaser.addMaaserAmount(amount * 0.10);
                break;
            case R.id.radioButton15:
                maaser.addAmount(amount);
                maaser.addMaaserAmount(amount * 0.15);
                break;
            case R.id.radioButton20:
                maaser.addAmount(amount);
                maaser.addMaaserAmount(amount * 0.20);
                break;
        }
    }
}
