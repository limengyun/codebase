package com.limy.codebase.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.limy.codebase.R;
import com.limy.codebase.fragment.MainFragment;

import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cb_activity_main);
    ButterKnife.inject(this);

    getSupportFragmentManager().beginTransaction()
        .replace(android.R.id.content, new MainFragment())
        .commit();
  }
}
