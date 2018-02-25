package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class ListViewAct extends Activity {
  private String[] names = new String[] {"虎头", "弄玉", "李清照", "李白"};
  private String[] descs = new String[] {"可爱的小孩", "一个擅长音乐的女孩", "一个擅长文学的女性", "浪漫主义诗人"};
  private int[] imageIds =
      new int[] {
        R.drawable.drawer_banner,
        R.drawable.sign_in_scene,
        R.drawable.default_error,
        R.drawable.splash
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_list_view);
    //    ListView listView1 = findViewById(R.id.list1);
    //    ListView listView2 = findViewById(R.id.list2);
    //    String[] arr1 = {"孙悟空", "猪八戒", "牛魔王"};
    //    String[] arr2 = {"Java", "Hibernate", "Spring", "Android"};
    //    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.array_item, arr1);
    //    listView1.setAdapter(adapter1);
    //    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.array_item, arr2);
    //    listView2.setAdapter(adapter2);
    //
    //    List<Map<String, Object>> listItems = new ArrayList<>();
    //    for (int i = 0; i < names.length; i++) {
    //      Map<String, Object> listItem = new HashMap<>();
    //      listItem.put("header", imageIds[i]);
    //      listItem.put("personName", names[i]);
    //      listItem.put("desc", descs[i]);
    //      listItems.add(listItem);
    //    }
    //    SimpleAdapter simpleAdapter =
    //        new SimpleAdapter(
    //            this,
    //            listItems,
    //            R.layout.simple_item,
    //            new String[] {"personName", "header", "desc"},
    //            new int[] {R.id.name, R.id.header, R.id.desc});
    ListView listView = findViewById(R.id.simple_adapter_list_view);
    //    listView.setAdapter(simpleAdapter);
    //    listView.setOnItemClickListener(
    //        (parent, view, position, id) -> Log.d("ady", "onItemClick: " + names[position] +
    // "被单击了"));
    //    listView.setOnItemSelectedListener(
    //        new AdapterView.OnItemSelectedListener() {
    //          @Override
    //          public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    // {
    //            Log.d("ady", "onItemSelected: " + names[position] + "被选中了");
    //          }
    //
    //          @Override
    //          public void onNothingSelected(AdapterView<?> parent) {
    //            Log.d("ady", "onNothingSelected: ");
    //          }
    //        });
    BaseAdapter adapter =
        new BaseAdapter() {
          @Override
          public int getCount() {
            return 40;
          }

          @Override
          public Object getItem(int position) {
            return null;
          }

          @Override
          public long getItemId(int position) {
            return position;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout line = new LinearLayout(ListViewAct.this);
            line.setOrientation(LinearLayout.HORIZONTAL);
            ImageView image = new ImageView(ListViewAct.this);
            image.setImageResource(R.drawable.ic_launcher_background);
            TextView text = new TextView(ListViewAct.this);
            text.setText("第" + (position + 1) + "个列表项");
            text.setTextSize(20);
            text.setTextColor(Color.RED);
            line.addView(image);
            line.addView(text);
            return line;
          }
        };
    listView.setAdapter(adapter);
  }
}
