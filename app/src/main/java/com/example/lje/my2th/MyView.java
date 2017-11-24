package com.example.lje.my2th;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LJE on 2017-11-24.
 */

public class MyView extends View
{
    float i;
    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint pnt = new Paint();
        pnt.setStrokeWidth(6f);
        pnt.setColor(Color.parseColor("#FF0000"));
        pnt.setStyle(Paint.Style.STROKE);

        RectF rect = new RectF();
        rect.set(200, (200), 600, 600);
        canvas.drawArc(rect, 270, i, false, pnt);

        pnt.setColor(Color.parseColor("#2F9D27"));
        rect = new RectF();
        rect.set(200, (700), 600, 1100);
        canvas.drawArc(rect, (270-i), i, false, pnt);
    }
}




