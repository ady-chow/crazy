package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class SpinnerAct extends Activity {
  Spinner spinner;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_spinner);
    spinner = findViewById(R.id.spinner);
    String[] arr = {"孙悟空", "猪八戒", "唐僧"};
    ArrayAdapter<String> adapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
    spinner.setAdapter(adapter);
  }
}
