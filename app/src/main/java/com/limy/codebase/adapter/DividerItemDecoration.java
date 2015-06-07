package com.limy.codebase.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.limy.codebase.BaseApplication;
import com.limy.codebase.R;

/**
 * @author limy
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
  private ColorDrawable divider;
  private int dividerHeight;

  public DividerItemDecoration() {
    int color = BaseApplication.getInstance().getResources().getColor(R.color.divider);
    divider = new ColorDrawable(color);
    dividerHeight = 1;
  }

  @Override
  public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
    final int left = parent.getPaddingLeft();
    final int right = parent.getWidth() - parent.getPaddingRight();

    int childCount = parent.getChildCount();
    for (int i = 0; i < childCount; i++) {
      View child = parent.getChildAt(i);
      final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
          .getLayoutParams();
      final int top = child.getBottom() + params.bottomMargin;
      final int bottom = top + dividerHeight;
      divider.setBounds(left, top, right, bottom);
      divider.draw(c);
    }
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.set(0, 0, 0, dividerHeight);
  }
}
