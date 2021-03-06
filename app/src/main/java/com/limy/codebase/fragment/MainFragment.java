package com.limy.codebase.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.limy.codebase.NavigationManager;
import com.limy.codebase.R;
import com.limy.codebase.adapter.DividerItemDecoration;
import com.limy.codebase.adapter.ListAdapter;
import com.limy.codebase.data.Model;
import com.limy.codebase.data.Type;
import com.limy.codebase.mock.MockUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author limy
 */
public class MainFragment extends Fragment {

  @InjectView(R.id.recycler_view)
  RecyclerView recyclerView;

  @InjectView(R.id.toolbar)
  Toolbar toolbar;

  @InjectView(R.id.swipe_refresh)
  SwipeRefreshLayout swipeRefreshLayout;

  private LinearLayoutManager layoutManager;
  private ListAdapter adapter;

  public MainFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.cb_fragment_main, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.inject(this, view);

    initToolbar();
    initRecyclerView();

    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        swipeRefreshLayout.postDelayed(new Runnable() {
          @Override
          public void run() {
            swipeRefreshLayout.setRefreshing(false);
          }
        }, 2000);
      }
    });
  }

  private void initToolbar() {
    toolbar.setTitle(getActivity().getTitle());
    toolbar.setTitleTextColor(getResources().getColor(R.color.text_color_white));
    toolbar.inflateMenu(R.menu.menu_main);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
          case R.id.action_settings:
            NavigationManager.navigateToSettings(getActivity());
            break;
          default:
            break;
        }
        return false;
      }
    });
  }

  private void initRecyclerView() {
    recyclerView.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    adapter = new ListAdapter();
    List<Model> models = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      Model model = new Model(Type.POST);
      if (i == 0 || i == 13) {
        model = new Model(Type.DATE);
      }

      model.url = MockUtil.getWDJAvatarUrl(i);
      models.add(model);
    }
    adapter.setData(models);
    recyclerView.setAdapter(adapter);

    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration());
  }
}
