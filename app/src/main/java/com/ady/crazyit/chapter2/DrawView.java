package com.ady.crazyit.chapter2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ady on 2018/2/18.
 */

public class DrawView extends View {

  float currentX = 40;
  float currentY = 50;

  Paint p = new Paint();

  public DrawView(Context context) {
    super(context);
  }

  public DrawView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    p.setColor(Color.RED);
    canvas.drawCircle(currentX, currentY, 15, p);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    currentX = event.getX();
    currentY = event.getY();
    invalidate();
    return true;
  }
}
