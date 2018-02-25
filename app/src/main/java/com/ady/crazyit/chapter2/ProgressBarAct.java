package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/21. */
public class ProgressBarAct extends Activity {

  private int[] data = new int[100];
  int hasData = 0;
  int status = 0;
  ProgressBar bar1, bar2;
  Handler mHandler =
      new Handler() {
        @Override
        public void handleMessage(Message msg) {
          if (msg.what == 0x111) {
            bar1.setProgress(status);
            bar2.setProgress(status);
          }
        }
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_progress_bar);
    bar1 = findViewById(R.id.bar1);
    bar2 = findViewById(R.id.bar2);
  }
}
