package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class ToggleButtonAct extends Activity {

  ToggleButton toggle;
  Switch switcher;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_toggle_button);
    toggle = findViewById(R.id.toggle);
    switcher = findViewById(R.id.switcher);
    final LinearLayout test = findViewById(R.id.test);
    CompoundButton.OnCheckedChangeListener listener =
        (buttonView, isChecked) -> {
          if (isChecked) {
            test.setOrientation(LinearLayout.VERTICAL);
          } else {
            test.setOrientation(LinearLayout.HORIZONTAL);
          }
        };
    toggle.setOnCheckedChangeListener(listener);
    switcher.setOnCheckedChangeListener(listener);
  }
}
