package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class AutoCompleteTextViewAct extends Activity {
  AutoCompleteTextView autoCompleteTextView;
  MultiAutoCompleteTextView multiAutoCompleteTextView;
  String[] books = new String[] {"疯狂Java讲义", "疯狂Ajax讲义", "疯狂XML讲义", "疯狂Workflow讲义"};

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_auto_complete_text_view);
    ArrayAdapter<String> aa =
        new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, books);
    autoCompleteTextView = findViewById(R.id.auto);
    multiAutoCompleteTextView = findViewById(R.id.mauto);
    autoCompleteTextView.setAdapter(aa);
    multiAutoCompleteTextView.setAdapter(aa);
    multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
  }
}
