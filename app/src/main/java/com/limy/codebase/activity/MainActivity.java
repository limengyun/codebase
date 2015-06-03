package com.limy.codebase.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.limy.codebase.R;
import com.limy.codebase.fragment.MainFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import timber.log.Timber;


public class MainActivity extends FragmentActivity {

  @InjectView(R.id.toolbar)
  Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cb_activity_main);
    ButterKnife.inject(this);

    toolbar.setTitle(getTitle());
    toolbar.inflateMenu(R.menu.menu_main);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
          case R.id.action_settings:
            Timber.e("test");
            throw new RuntimeException("test");
          default:
            break;
        }
        return false;
      }
    });
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, new MainFragment())
        .commit();
  }
}
