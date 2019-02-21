package com.example.hw2;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.view.View;
import android.widget.TextView;
import static android.graphics.Color.red;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.rgb;

public class Controller implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    private TextView currentTextView;
    private TextView redValue;
    private TextView greenValue;
    private TextView blueValue;

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    private mySurfaceView layout;

    private CustomElement element;

    int r;
    int g;
    int b;


    public Controller(mySurfaceView display, SeekBar initRedSeekBar, SeekBar initBlueSeekBar, SeekBar initGreenSeekBar, TextView initCurrentTextView, TextView initBlueValue, TextView initGreenValue, TextView initRedValue) {
        redSeekBar = initRedSeekBar;
        redSeekBar.setOnSeekBarChangeListener(this);

        greenSeekBar = initGreenSeekBar;
        greenSeekBar.setOnSeekBarChangeListener(this);

        blueSeekBar = initBlueSeekBar;
        blueSeekBar.setOnSeekBarChangeListener(this);

        currentTextView = initCurrentTextView;

        redValue = initRedValue;
        blueValue = initBlueValue;
        greenValue = initGreenValue;

        layout = display;
        display.setOnTouchListener(this);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //get x and y for element
        int x = (int) event.getX();
        int y = (int) event.getY();

        //lets us know if touch was where the element is
        element = layout.findTheElement(x,y);


        //get color for red, green, and blue values
        r = red(element.getColor());
        b = blue(element.getColor());
        g = green(element.getColor());


        //update values of seek bar and the current Text View
        currentTextView.setText(element.getName());


        //sets text for all color values.
        redValue.setText("" + r);
        blueValue.setText("" + b);
        greenValue.setText("" + g);


        //sets the progress of all color values
        redSeekBar.setProgress(r);
        blueSeekBar.setProgress(b);
        greenSeekBar.setProgress(g);


        //set max of text view for values to 255
        redSeekBar.setMax(255);
        blueSeekBar.setMax(255);
        greenSeekBar.setMax(255);


        //handling the case when no element is selected
        if(element == null){
            currentTextView.setText("Nothing is Selected!!");
            return false;
        }


        return true;




    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int seekBarProgress, boolean User) {

        //
            if(User){

                if(seekBar == redSeekBar) {

                    r = seekBarProgress;
                    element.setColor(rgb(r, g, b));
                    redValue.setText("" + seekBarProgress);

                }

                if(seekBar == blueSeekBar){

                    b = seekBarProgress;
                    element.setColor(rgb(r,g,b));
                    blueValue.setText("" + seekBarProgress);

                }

                if(seekBar == greenSeekBar){

                    g = seekBarProgress;
                    element.setColor(rgb(r,g,b));
                    greenValue.setText("" + seekBarProgress);

                }

                layout.invalidate();
            }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



}


