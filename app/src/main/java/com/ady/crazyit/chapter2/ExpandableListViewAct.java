package com.ady.crazyit.chapter2;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ady.crazyit.R;

/** Created by ady on 2018/2/19. */
public class ExpandableListViewAct extends Activity {
  ExpandableListView expandableListView;
  int[] logos =
      new int[] {R.drawable.default_error, R.drawable.default_error, R.drawable.default_error};
  private String[] armTypes = new String[] {"神族兵种", "虫族兵种", "人族兵种"};
  private String[][] arms =
      new String[][] {
        {"狂战士", "龙骑士", "黑暗圣堂", "点兵"}, {"够", "刺蛇", "飞龙", "自爆飞机"}, {"机枪兵", "护士MM", "幽灵"}
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_expandable_list_view);
    expandableListView = findViewById(R.id.expandable_list_view);
    ExpandableListAdapter adapter =
        new ExpandableListAdapter() {
          @Override
          public void registerDataSetObserver(DataSetObserver observer) {}

          @Override
          public void unregisterDataSetObserver(DataSetObserver observer) {}

          @Override
          public int getGroupCount() {
            return arms.length;
          }

          @Override
          public int getChildrenCount(int groupPosition) {
            return arms[groupPosition].length;
          }

          @Override
          public Object getGroup(int groupPosition) {
            return armTypes[groupPosition];
          }

          @Override
          public Object getChild(int groupPosition, int childPosition) {
            return arms[groupPosition][childPosition];
          }

          @Override
          public long getGroupId(int groupPosition) {
            return groupPosition;
          }

          @Override
          public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
          }

          @Override
          public boolean hasStableIds() {
            return true;
          }

          @Override
          public View getGroupView(
              int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            LinearLayout ll = new LinearLayout(ExpandableListViewAct.this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ImageView logo = new ImageView(ExpandableListViewAct.this);
            logo.setImageResource(logos[groupPosition]);
            ll.addView(logo);
            TextView textView = getTextView();
            textView.setText(getGroup(groupPosition).toString());
            ll.addView(textView);
            return ll;
          }

          @Override
          public View getChildView(
              int groupPosition,
              int childPosition,
              boolean isLastChild,
              View convertView,
              ViewGroup parent) {
            TextView textView = getTextView();
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
          }

          @Override
          public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
          }

          @Override
          public boolean areAllItemsEnabled() {
            return false;
          }

          @Override
          public boolean isEmpty() {
            return false;
          }

          @Override
          public void onGroupExpanded(int groupPosition) {}

          @Override
          public void onGroupCollapsed(int groupPosition) {}

          @Override
          public long getCombinedChildId(long groupId, long childId) {
            return 0;
          }

          @Override
          public long getCombinedGroupId(long groupId) {
            return 0;
          }

          private TextView getTextView() {
            AbsListView.LayoutParams lp =
                new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
            TextView textView = new TextView(ExpandableListViewAct.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(36, 0, 0, 0);
            textView.setTextSize(20);
            return textView;
          }
        };
    ExpandableListView expandableListView = findViewById(R.id.expandable_list_view);
    expandableListView.setAdapter(adapter);
  }
}
