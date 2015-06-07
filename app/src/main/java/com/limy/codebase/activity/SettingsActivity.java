package com.limy.codebase.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.limy.codebase.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SettingsActivity extends FragmentActivity {

  @InjectView(R.id.toolbar)
  Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cb_activity_settings);
    getWindow().getDecorView().setBackgroundColor(
        getResources().getColor(R.color.background_material_light));

    ButterKnife.inject(this);

    initToolbar();
  }

  private void initToolbar() {
    toolbar.setTitle(getTitle());
    toolbar.setTitleTextColor(getResources().getColor(R.color.text_color_white));
    toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }
}
