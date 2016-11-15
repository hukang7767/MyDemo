package com.hukang.mydemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Heart extends View {
    private Paint mPaint;
    public Heart(Context context) {
        super(context);
        init();
    }

    public Heart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Heart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(100,50,200,150,220,110,false,mPaint);
            canvas.drawArc(186,50,286,150,210,110,false,mPaint);
            canvas.drawArc(102,0,300,210,90,112,false,mPaint);
            canvas.drawArc(80,0,280,210,338,110,false,mPaint);
        }
    }
    private void init(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#cd436f"));
        mPaint.setStrokeWidth(10);
    }
}
