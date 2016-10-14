package com.example.student.ecksdeexdxdxdxd;

import android.widget.TextView;

import java.util.Random;
public class Prediction {
    private static Prediction prediction;
    private String[] answers;
    private Random myRandom = new Random();
    private int randomNumber;

    private Prediction(){
        answers = new String[] {
                "No",
                "Stop",
                "Think for one second"
        };
    }
public static Prediction get(){

    if(prediction == null) {
        prediction = new Prediction();


    }
    return prediction;
}
    public String getPrediction(){
        randomNumber = myRandom.nextInt(answers.length);

        return answers[randomNumber];

    }
}
