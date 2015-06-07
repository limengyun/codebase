package com.limy.codebase.adapter.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.limy.codebase.NavigationManager;
import com.limy.codebase.R;
import com.limy.codebase.data.Model;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * @author limy
 */
public class DateHolder extends BaseHolder {


  @InjectView(R.id.title)
  public TextView title;


  public DateHolder(View v) {
    super(v);
    ButterKnife.inject(this, v);
  }

  @Override
  public void bind(Model model) {
    super.bind(model);


    title.setText("Yesterday");

  }

}