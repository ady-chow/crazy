package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/21. */
public class GalleryAct extends Activity {

  int[] imageIds =
      new int[] {
        R.drawable.default_error,
        R.drawable.drawer_banner,
        R.drawable.sign_in_scene,
        R.drawable.splash
      };

  Gallery gallery;
  ImageView imageView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_gallery);
    gallery = findViewById(R.id.gallery);
    imageView = findViewById(R.id.image_view);
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
            ImageView iv = new ImageView(GalleryAct.this);
            iv.setImageResource(imageIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(new Gallery.LayoutParams(75, 100));
            //        TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
            return iv;
          }
        };
    gallery.setAdapter(adapter);
    gallery.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.d("ady", "onItemSelected: ");
            imageView.setImageResource(imageIds[position]);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
  }
}
