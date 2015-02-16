package com.example.jeremy.comp7481_as5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends Activity implements OnGestureListener {
    private LinearLayout myLayout;
    private TextView myTextView;
    private GestureDetector gestureScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureScanner = new GestureDetector(getBaseContext(), this);

        myLayout = new LinearLayout(this);
        myLayout.setLayoutParams(new LinearLayout.LayoutParams(1000, 500));
        myLayout.setOrientation(LinearLayout.VERTICAL);

        myTextView = new TextView(this);
        myTextView.setBackgroundColor(Color.YELLOW);
        myTextView.setTextColor(Color.BLACK);
        myTextView.setTextSize(15);
        myTextView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));
        myLayout.addView(myTextView);

        XView myXView = new XView(this, null);
        myLayout.addView(myXView);

        setContentView(myLayout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        myTextView.setText("-" + "DOWN" + "-");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        myTextView.setText("-" + "FLING" + "-");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        myTextView.setText("-" + "LONG PRESS" + "-");

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        myTextView.setText("-" + "SCROLL" + "-");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        myTextView.setText("-" + "SHOW PRESS" + "-");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        myTextView.setText("-" + "SINGLE TAP UP" + "-");
        return true;
    }


}
