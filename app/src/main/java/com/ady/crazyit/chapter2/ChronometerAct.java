package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Chronometer;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class ChronometerAct extends Activity {
  Chronometer ch;
  Button start;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_chronometer);
    ch = findViewById(R.id.test);
    start = findViewById(R.id.start);
    start.setOnClickListener(
        c -> {
          ch.setBase(SystemClock.elapsedRealtime());
          ch.start();
          start.setEnabled(false);
        });
    ch.setOnChronometerTickListener(
        c -> {
          if (SystemClock.elapsedRealtime() - ch.getBase() > 10 * 1000) {
            ch.stop();
            start.setEnabled(true);
          }
        });
  }
}
