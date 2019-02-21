package com.example.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializes text views for red, green, blue values
        TextView redValue = (TextView) findViewById(R.id.redValue);
        TextView greenValue = (TextView) findViewById(R.id.greenValue);
        TextView blueValue = (TextView) findViewById(R.id.blueValue);

        //initializes current Text View for current element
        TextView currentElement = (TextView) findViewById(R.id.currentElement);

        //initializes seek bars for red, green, and blue values
        SeekBar redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);


      mySurfaceView display = findViewById(R.id.surfaceView);

      controller = new Controller(display, redSeekBar, blueSeekBar, greenSeekBar, currentElement, blueValue, greenValue, redValue);
    }
}
