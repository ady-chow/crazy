package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class ImageViewAct extends Activity {
  int[] images =
      new int[] {
        R.drawable.sign_in_scene,
        R.drawable.splash,
        R.drawable.default_error,
        R.drawable.drawer_banner
      };

  int currentImg = 2;
  private int alpha = 255;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_image_view);
    final Button plus = findViewById(R.id.plus);
    final Button minus = findViewById(R.id.minus);
    final Button next = findViewById(R.id.next);
    final ImageView image1 = findViewById(R.id.image1);
    final ImageView image2 = findViewById(R.id.image2);
    next.setOnClickListener(c -> image1.setImageResource(images[++currentImg % images.length]));
    View.OnClickListener listener =
        v -> {
          if (v == plus) {
            alpha += 20;
          } else if (v == minus) {
            alpha -= 20;
          }
          if (alpha >= 255) {
            alpha = 255;
          }
          if (alpha < 0) {
            alpha = 0;
          }
          image1.setAlpha(alpha);
        };
    plus.setOnClickListener(listener);
    minus.setOnClickListener(listener);
    image1.setOnTouchListener(
        (view, event) -> {
          BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
          Bitmap bitmap = bitmapDrawable.getBitmap();
          double scale = bitmap.getWidth() / 320.0;
          int x = (int) (event.getX() * scale);
          int y = (int) (event.getY() * scale);
          if (x + 120 > bitmap.getWidth()) {
            x = bitmap.getWidth() - 120;
          }
          if (y + 120 > bitmap.getHeight()) {
            y = bitmap.getHeight() - 120;
          }
          image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
          image2.setAlpha(alpha);
          return false;
        });
  }
}
