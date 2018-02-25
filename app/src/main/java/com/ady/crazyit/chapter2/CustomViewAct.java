package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.ady.crazyit.R;

/**
 * Created by ady on 2018/2/18.
 */

public class CustomViewAct extends Activity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_custom_view);
//    LinearLayout root = findViewById(R.id.root);
//    final DrawView draw = new DrawView(this)；
  }
}
