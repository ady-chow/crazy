package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.QuickContactBadge;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class QuickContactBadgeAct extends Activity {

  QuickContactBadge badge;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_quick_contact_badge);
    badge = findViewById(R.id.badge);
    badge.assignContactFromPhone("13943459510", false);
  }
}
