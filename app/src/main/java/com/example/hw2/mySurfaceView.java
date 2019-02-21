package com.example.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;




public class mySurfaceView extends SurfaceView {

    ArrayList<CustomElement> layout;

    public mySurfaceView(Context context) {
        super(context);
        init();
    }

    public mySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public mySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false);

        layout = new ArrayList<CustomElement>();

        //draws a red circle in the surface view
        CustomCircle redCircle = new CustomCircle("red circle", 0xFFFF0000, 600, 600, 100);
        layout.add(redCircle);

        //draws a teal rectangle in the surface view
        CustomRect tealRectangle = new CustomRect("Teal Rectangle", 0xFF07B0A9, 300, 400, 500, 100);
        layout.add(tealRectangle);

        //draws a big purple circle in the surface view
        CustomCircle purpleCircle = new CustomCircle("Big Purple Circle", 0xFF90098A, 800, 400, 150);
        layout.add(purpleCircle);

        CustomRect shitSquare = new CustomRect("The Shit Square", 0xFF95590E, 300, 700, 100, 300);
        layout.add(shitSquare);

        CustomCircle yellowCircle = new CustomCircle("Yellow Circle", 0xFFFFE108, 1200, 300, 200);
        layout.add(yellowCircle);

        CustomCircle matchaCircle = new CustomCircle("Matcha Circle", 0xFF82C17C, 1300, 400, 100);
        layout.add(matchaCircle);
        //do this six times
    }





    @Override
    protected void onDraw(Canvas canvas) {


        for(CustomElement i : layout){
            i.drawMe(canvas);
        }

    }


    public CustomElement findTheElement(int x, int y){
        ArrayList <CustomElement> arrayListCheck = new ArrayList<CustomElement>();

        for(CustomElement i: layout){
            if(i.containsPoint(x,y)){
                arrayListCheck.add(i);
            }
        }

        CustomElement ifTouched = null;
        for(CustomElement j : arrayListCheck){
            if(j.containsPoint(x,y)){
                ifTouched = j;
            }
        }
        return ifTouched;
    }

}
