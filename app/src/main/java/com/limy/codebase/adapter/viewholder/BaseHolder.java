package com.limy.codebase.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.limy.codebase.data.Model;

/**
 * @author limy
 */
public class BaseHolder extends RecyclerView.ViewHolder{

  protected Model model;

  public BaseHolder(View itemView) {
    super(itemView);
  }

  public void bind(Model model) {
    this.model = model;
  }

  public void unbind() {
    this.model = null;
  }
}
