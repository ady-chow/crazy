package com.ady.crazyit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ady.crazyit.chapter2.AdapterViewFlipperAct;
import com.ady.crazyit.chapter2.AdvancedTextViewAct;
import com.ady.crazyit.chapter2.AutoCompleteTextViewAct;
import com.ady.crazyit.chapter2.ChronometerAct;
import com.ady.crazyit.chapter2.ClockAct;
import com.ady.crazyit.chapter2.CustomViewAct;
import com.ady.crazyit.chapter2.EditTextAct;
import com.ady.crazyit.chapter2.ExpandableListViewAct;
import com.ady.crazyit.chapter2.FrameLayoutAct;
import com.ady.crazyit.chapter2.GalleryAct;
import com.ady.crazyit.chapter2.GridLayoutAct;
import com.ady.crazyit.chapter2.GridViewAct;
import com.ady.crazyit.chapter2.ImageViewAct;
import com.ady.crazyit.chapter2.ListViewAct;
import com.ady.crazyit.chapter2.ProgressBarAct;
import com.ady.crazyit.chapter2.QuickContactBadgeAct;
import com.ady.crazyit.chapter2.SpinnerAct;
import com.ady.crazyit.chapter2.StackViewAct;
import com.ady.crazyit.chapter2.TableLayoutAct;
import com.ady.crazyit.chapter2.TextViewAct;
import com.ady.crazyit.chapter2.ToggleButtonAct;

/** Created by ady on 2018/2/18. */
public class MainAct extends Activity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_main);
    initEvent();
  }

  private void initEvent() {
    clickEvent(R.id.custom_view, CustomViewAct.class);
    clickEvent(R.id.table_layout, TableLayoutAct.class);
    clickEvent(R.id.frame_layout, FrameLayoutAct.class);
    clickEvent(R.id.grid_layout, GridLayoutAct.class);
    clickEvent(R.id.text_view, TextViewAct.class);
    clickEvent(R.id.advanced_text_view, AdvancedTextViewAct.class);
    clickEvent(R.id.edit_text_view, EditTextAct.class);
    clickEvent(R.id.toggle_button, ToggleButtonAct.class);
    clickEvent(R.id.clock, ClockAct.class);
    clickEvent(R.id.chronometer, ChronometerAct.class);
    clickEvent(R.id.image_view, ImageViewAct.class);
    clickEvent(R.id.quick_contact_badge, QuickContactBadgeAct.class);
    clickEvent(R.id.list_view, ListViewAct.class);
    clickEvent(R.id.auto_complete_text_view, AutoCompleteTextViewAct.class);
    clickEvent(R.id.grid_view, GridViewAct.class);
    clickEvent(R.id.expandable_list_view, ExpandableListViewAct.class);
    clickEvent(R.id.spinner, SpinnerAct.class);
    clickEvent(R.id.gallery, GalleryAct.class);
    clickEvent(R.id.adapter_view_flipper, AdapterViewFlipperAct.class);
    clickEvent(R.id.stack_view, StackViewAct.class);
    clickEvent(R.id.progress, ProgressBarAct.class);
  }

  private void clickEvent(int id, Class<?> cls) {
    findViewById(id).setOnClickListener(c -> start(cls));
  }

  private void start(Class<?> cls) {
    startActivity(new Intent(this, cls));
  }
}
