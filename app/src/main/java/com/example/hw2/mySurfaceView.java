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

        setWillNotDraw(true);

        layout = new ArrayList<CustomElement>();


        /**
         External Citation
         Date:     February 18, 2019
         Problem:  Did not know the colors to use for my shapes
         Resource:
         https://htmlcolorcodes.com
         Solution: I used the hexadecimal color to help me use my colors
         */
        //draws a red circle in the surface view
        CustomCircle redCircle = new CustomCircle("Red Circle", 0xFFFF0000, 600, 600, 100);
        layout.add(redCircle);

        //draws a teal rectangle in the surface view
        CustomRect tealRectangle = new CustomRect("Teal Rectangle", 0xFF07B0A9, 300, 400, 500, 100);
        layout.add(tealRectangle);

        //draws a big purple circle in the surface view
        CustomCircle purpleCircle = new CustomCircle("Big Purple Circle", 0xFF90098A, 800, 400, 150);
        layout.add(purpleCircle);

        //draws a brown square in the surface view
        CustomRect shitSquare = new CustomRect("The Shit Square", 0xFF95590E, 300, 700, 100, 300);
        layout.add(shitSquare);

        //draws a yellow circle in the surface view
        CustomCircle yellowCircle = new CustomCircle("Yellow Circle", 0xFFFFE108, 1200, 300, 200);
        layout.add(yellowCircle);

        //draws a matcha green circle in the surface view
        CustomCircle matchaCircle = new CustomCircle("Matcha Circle", 0xFF82C17C, 1300, 600, 100);
        layout.add(matchaCircle);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //enhanced for loop to be able to access the array in the layout.
        // Then calling the drawMe method from the CustomElement to draw the elements CustomRect and CustomCircle
        for(CustomElement drawing : layout){
            drawing.drawMe(canvas);
        }
    }


    public CustomElement findTheElement(int x, int y){
        //Patrick Bellosil helped me implement the array List because I did not know how to implement that.

        //creating an array list from CustomElement called arrayListCheck and made a new array list
        ArrayList <CustomElement> arrayListCheck = new ArrayList<CustomElement>();

        /*another enhanced for loop to be able to access the array in the layout and being able to call the
          containsPoint method from the CustomElement to draw the elements CustomRect and CustomCircle
        */
        for(CustomElement drawing: layout){
            if(drawing.containsPoint(x,y)){
                arrayListCheck.add(drawing);
            }
        }

        //checking to see if element was touched or not
        CustomElement ifTouched = null;
        for(CustomElement drawing: arrayListCheck){
            if(drawing.containsPoint(x,y)){
                ifTouched = drawing;
            }
        }
        return ifTouched;
    }

}
