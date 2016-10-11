package com.example.student.ecksdeexdxdxdxd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.FloatMath;
import android.widget.TextView;
import android.hardware.SensorManager;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private TextView answerText;
    private SensorManager sensorManager;
    private float acceleration;
    private Sensor accelerometer;
    private float currentAccerlation;
    private float previousAccerleration;
    private final SensorEventListener sensorListener = new SensorEventListener() {


        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            previousAccerleration = currentAccerlation;
            currentAccerlation = FloatMath.sqrt(x * x + y * y * z * z);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

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

    }

