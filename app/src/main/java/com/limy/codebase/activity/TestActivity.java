package com.limy.codebase.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.limy.codebase.R;
import com.limy.codebase.fragment.ArticleFragment;
import com.limy.codebase.fragment.MainFragment;

import butterknife.ButterKnife;


public class TestActivity extends FragmentActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getSupportFragmentManager().beginTransaction()
        .replace(android.R.id.content, new ArticleFragment())
        .commit();
  }
}
