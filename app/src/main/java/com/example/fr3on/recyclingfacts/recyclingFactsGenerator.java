package com.example.fr3on.recyclingfacts;

import android.content.Context;

import java.util.Random;

public class recyclingFactsGenerator {
    String facts[] ;
    public recyclingFactsGenerator(Context context){
        facts=context.getResources().getStringArray(R.array.facts);
    }
    public String generateFacts(){

        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(facts.length);
        String fact = facts[randomNum];
        return fact;

    }
}
