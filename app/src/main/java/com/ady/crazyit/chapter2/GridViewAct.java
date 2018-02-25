package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.ady.crazyit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created by ady on 2018/2/19. */
public class GridViewAct extends Activity {
  GridView grid;
  ImageView imageView;
  int[] imageIds =
      new int[] {
        R.drawable.splash,
        R.drawable.default_error,
        R.drawable.sign_in_scene,
        R.drawable.drawer_banner,
        R.drawable.splash,
        R.drawable.default_error,
        R.drawable.sign_in_scene,
        R.drawable.drawer_banner,
        R.drawable.splash,
        R.drawable.default_error,
        R.drawable.sign_in_scene,
        R.drawable.drawer_banner,
        R.drawable.splash,
        R.drawable.default_error,
        R.drawable.sign_in_scene,
        R.drawable.drawer_banner
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_grid_view);
    List<Map<String, Object>> listItems = new ArrayList<>();
    for (int i = 0; i < imageIds.length; i++) {
      Map<String, Object> listItem = new HashMap<>();
      listItem.put("image", imageIds[i]);
      listItems.add(listItem);
    }
    imageView = findViewById(R.id.image_view);
    SimpleAdapter adapter =
        new SimpleAdapter(
            this, listItems, R.layout.cell, new String[] {"image"}, new int[] {R.id.image1});
    grid = findViewById(R.id.grid01);
    grid.setAdapter(adapter);
    grid.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.d("ady", "onItemSelected: pos = " + position);
            imageView.setImageResource(imageIds[position]);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
    grid.setOnItemClickListener(
        (parent, view, position, id) -> {
          Log.d("ady", "onItemClick: pos = " + position);
          imageView.setImageResource(imageIds[position]);
        });
  }
}
