package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ady.crazyit.R;

import java.util.Timer;
import java.util.TimerTask;

/** Created by ady on 2018/2/18. */
public class FrameLayoutAct extends Activity {

  private int currentColor = 0;
  final int[] colors =
      new int[] {
        R.color.color1,
        R.color.color2,
        R.color.color3,
        R.color.color4,
        R.color.color5,
        R.color.color6
      };

  final int[] names =
      new int[] {
        R.id.view_01, R.id.view_02, R.id.view_03, R.id.view_04, R.id.view_05, R.id.view_06
      };

  TextView[] views = new TextView[names.length];

  Handler handler =
      new Handler() {
        @Override
        public void handleMessage(Message msg) {
          if (msg.what == 0x123) {
            for (int i = 0; i < names.length; i++) {
              views[i].setBackgroundResource(colors[(i + currentColor) % names.length]);
            }
            currentColor++;
          }
          super.handleMessage(msg);
        }
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_frame_layout);
    for (int i = 0; i < names.length; i++) {
      views[i] = findViewById(names[i]);
    }
    new Timer()
        .schedule(
            new TimerTask() {
              @Override
              public void run() {
                handler.sendEmptyMessage(0x123);
              }
            },
            0,
            200);
  }
}
