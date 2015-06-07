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
public class ArticleFragment extends Fragment {

  @InjectView(R.id.recycler_view)
  RecyclerView recyclerView;

  private LinearLayoutManager layoutManager;
  private ListAdapter adapter;

  public ArticleFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.cb_fragment_article, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.inject(this, view);

    initRecyclerView();
  }

  private void initRecyclerView() {
    recyclerView.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    adapter = new ListAdapter();
    List<Model> models = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      Model model = new Model(Type.IMAGE);

      model.url = MockUtil.getWDJAvatarUrl(i);
      model.width = 500;
      model.height = 500;

      models.add(model);
    }
    adapter.setData(models);
    recyclerView.setAdapter(adapter);

    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration());
  }
}
