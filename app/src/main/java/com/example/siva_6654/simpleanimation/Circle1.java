package com.example.siva_6654.simpleanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Circle1 extends View {

    public int W,H,i,j;
    public static float[] afP={0f,0f};
    public Circle1(Context context) {
        super(context);
    }

    public Circle1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Circle1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Circle1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        W = MeasureSpec.getSize(widthMeasureSpec);
        H = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(W,H);
    }
    private Path makepath(float x ,float y,int r){
        Path path = new Path();
        path.addCircle(x,y,r,Path.Direction.CW);
        return path;
    }

    @Override
    protected void onDraw(Canvas canvas){
        Random rnd = new Random();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                Path path = makepath(i == 0 ? 100+afP[0] : W- 100- afP[0], j == 0 ? 100+afP[1] : H-100- afP[1], 100);
                paint.setColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                canvas.drawPath(path, paint);
            }
        }
    }
}