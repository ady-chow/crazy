package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/18. */
public class GridLayoutAct extends Activity {

  GridLayout root;

  String[] chars =
      new String[] {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        ".", "0", "=", "+"
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_grid_layout);
    root = findViewById(R.id.root);
    for (int i = 0; i < chars.length; i++) {
      Button btn = new Button(this);
      btn.setText(chars[i]);
      btn.setTextSize(40);
      GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
      GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
      GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
      params.setGravity(Gravity.FILL);
      root.addView(btn, params);
    }
  }
}
