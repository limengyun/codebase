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
public class MainViewHolder extends BaseHolder {
  @InjectView(R.id.root)
  public View rootView;

  @InjectView(R.id.avatar)
  public SimpleDraweeView avatar;

  @InjectView(R.id.title)
  public TextView title;

  @InjectView(R.id.author)
  public TextView author;

  @InjectView(R.id.summary)
  public TextView summary;

  public MainViewHolder(View v) {
    super(v);
    ButterKnife.inject(this, v);
  }

  @Override
  public void bind(Model model) {
    super.bind(model);
    Uri uri = Uri.parse(model.url);
    avatar.setImageURI(uri);

    title.setText("发布【豌豆荚探索版 1.0.6】due date at");
    author.setText("limy");
    summary.setText("发布【豌豆荚探索版 1.0.6】due date at");

  }

  @OnClick(R.id.root)
  void click() {
    Toast.makeText(rootView.getContext(), "clicked:" + model.toString(), Toast.LENGTH_SHORT).show();

    NavigationManager.navigateToTest(itemView.getContext());
  }
}