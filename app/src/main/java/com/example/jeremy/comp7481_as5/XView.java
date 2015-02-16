package com.example.jeremy.comp7481_as5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class XView extends View implements OnGestureListener {

    private Paint mPaint = new Paint();
    int oX = 100;
    int oY = 100;
    private GestureDetector gestureScanner;

	public XView(Context context, AttributeSet attrs){
		super(context,attrs);

        gestureScanner = new GestureDetector(getContext(), this);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.MAGENTA);
	}

	@Override
	protected void onDraw(Canvas canvas) {
	    super.onDraw(canvas);

        canvas.drawColor(Color.BLUE);
	    canvas.drawCircle(oX, oY, 100, mPaint);
	}

    /*@Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureScanner.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mPaint.setColor(Color.GRAY);
        this.postInvalidate();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        oX=oX+20;
        mPaint.setColor(Color.RED);
        this.postInvalidate();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        oX=oX-20;
        mPaint.setColor(Color.CYAN);
        this.postInvalidate();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        /*if((e1.getX() < e2.getX())){
            oX=oX+30;
        }else{
            o*X=oX-30;
        }*/

        oX=oX+(int)(-e1.getX() + e2.getX());

        mPaint.setColor(Color.MAGENTA);
        this.postInvalidate();
        return true;
    }
}