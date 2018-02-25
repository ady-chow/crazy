package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/21. */
public class AdapterViewFlipperAct extends Activity {

  int[] imageIds =
      new int[] {
        R.drawable.default_error,
        R.drawable.drawer_banner,
        R.drawable.sign_in_scene,
        R.drawable.splash
      };
  AdapterViewFlipper flipper;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_adapter_view_flipper);
    flipper = findViewById(R.id.flipper);
    BaseAdapter adapter =
        new BaseAdapter() {
          @Override
          public int getCount() {
            return imageIds.length;
          }

          @Override
          public Object getItem(int position) {
            return position;
          }

          @Override
          public long getItemId(int position) {
            return position;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(AdapterViewFlipperAct.this);
            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(
                new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
          }
        };
    flipper.setAdapter(adapter);
  }

  public void prev(View view) {
    flipper.showPrevious();
    flipper.stopFlipping();
  }

  public void next(View view) {
    flipper.showNext();
    flipper.stopFlipping();
  }

  public void auto(View view) {
    flipper.startFlipping();
  }
}
