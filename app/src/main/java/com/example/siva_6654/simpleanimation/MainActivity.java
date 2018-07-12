package com.example.siva_6654.simpleanimation;

import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle1);
        Toast.makeText(getApplicationContext(), "Touch Here!", Toast.LENGTH_LONG).show();
    }
    public void Click(View view){
        final Circle1 circle = findViewById(R.id.circle1);
        Path p = new Path();
        int H = circle.getHeight();
        int W = circle.getWidth();
        p.moveTo(0,0);
        p.lineTo(W/2-100,H/2-100);
        final PathMeasure pm = new PathMeasure(p, false);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,pm.getLength());
        final float[] pos = new float[2];
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float v = (float) animation.getAnimatedValue();
                pm.getPosTan(v, pos, null);
                Circle1.afP = pos;
                circle.invalidate();
            }
        });
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.start();
    }
}
