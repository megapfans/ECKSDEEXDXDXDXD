package com.example.student.ecksdeexdxdxdxd;

/**
 * Created by Student on 9/25/2016.
 */
public class Prediction {
    private static Prediction prediction;
    private String[] answers;
    private Prediction(){
        answers = new String[] {
                "No",
                "Stop"
        };
    }
public static Prediction get(){

    if(prediction == null) {
        prediction = new Prediction();


    }
    return prediction;
}
    public String getPrediction(){
        return answers[1];
    }
}
