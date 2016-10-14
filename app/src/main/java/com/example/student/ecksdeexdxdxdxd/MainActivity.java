package com.example.student.ecksdeexdxdxdxd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.TextView;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView answerText;
    private SensorManager sensorManager;
    private double acceleration;
    private Sensor accelerometer;
    private double currentAccerlation;
    private double previousAccerleration;
    private final SensorEventListener sensorListener = new SensorEventListener() {


        @Override
        public void onSensorChanged(SensorEvent event) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];
            previousAccerleration = currentAccerlation;
            currentAccerlation = Math.sqrt(x * x + y * y * z * z);
            double delta = currentAccerlation - previousAccerleration;
            acceleration = acceleration *0.9f + delta;
            if(acceleration > 12){
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.loudnigratest);
            mediaPlayer.start();
        }
        };

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        acceleration = 0.0f;
        currentAccerlation = SensorManager.GRAVITY_EARTH;
        previousAccerleration = SensorManager.GRAVITY_EARTH;
        answerText = (TextView) findViewById(R.id.answerText);
        answerText.setText(Prediction.get().getPrediction());


    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }


};

