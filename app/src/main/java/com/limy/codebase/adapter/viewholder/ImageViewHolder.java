package com.limy.codebase.adapter.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.limy.codebase.R;
import com.limy.codebase.data.Model;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * @author limy
 */
public class ImageViewHolder extends BaseHolder {
  @InjectView(R.id.image)
  public SimpleDraweeView simpleDraweeView;

  public ImageViewHolder(View v) {
    super(v);
    ButterKnife.inject(this, v);
  }

  @Override
  public void bind(Model model) {
    super.bind(model);

    Uri uri = Uri.parse(model.url);
    float aspect = (float) model.width / (float) model.height;

    Timber.i("url=%s, w=%s, h=%s", model.url, model.width, model.height);
    simpleDraweeView.setAspectRatio(aspect);
    simpleDraweeView.setImageURI(uri);
  }
}