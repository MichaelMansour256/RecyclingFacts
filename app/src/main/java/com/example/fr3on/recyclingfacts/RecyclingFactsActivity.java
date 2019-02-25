package com.example.fr3on.recyclingfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RecyclingFactsActivity extends AppCompatActivity {

    private static final String FACT_KEY = "fact key";
    //here we initialize the variables
    private TextView factTextView;
    private Button factButton;
    private String fact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling_facts);
        // set the variables
        factTextView = findViewById(R.id.factTextView);
        factButton = findViewById(R.id.factButton);
       final recyclingFactsGenerator recyclingFactsGenerator = new recyclingFactsGenerator(this);
       fact = getResources().getString(R.string.recycling_facts_activity_content);
        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // change fact


                 fact = recyclingFactsGenerator.generateFacts();
                factTextView.setText(fact);

            }
        };
        factButton.setOnClickListener(onClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FACT_KEY,fact);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fact =savedInstanceState.getString(FACT_KEY);
        factTextView.setText(fact);

    }
}
