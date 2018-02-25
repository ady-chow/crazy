package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.ady.crazyit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/** Created by ady on 2018/2/21. */
public class StackViewAct extends Activity {

  int[] imageIds =
      new int[] {
        R.drawable.default_error,
        R.drawable.drawer_banner,
        R.drawable.sign_in_scene,
        R.drawable.splash
      };

  StackView stack;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_stack_view);
    List<Map<String, Object>> listItems = new ArrayList<>();
    for (int i = 0; i < imageIds.length; i++) {
      Map<String, Object> listItem = new HashMap<>();
      listItem.put("image", imageIds[i]);
      listItems.add(listItem);
    }
    SimpleAdapter simpleAdapter =
        new SimpleAdapter(
            this, listItems, R.layout.cell, new String[] {"image"}, new int[] {R.id.image1});
    stack = findViewById(R.id.stack);
    stack.setAdapter(simpleAdapter);
  }

  public void prev(View v) {
    stack.showPrevious();
  }

  public void next(View v) {
    stack.showNext();
  }
}
