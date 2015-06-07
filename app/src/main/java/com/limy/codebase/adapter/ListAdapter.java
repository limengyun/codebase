package com.limy.codebase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limy.codebase.R;
import com.limy.codebase.adapter.viewholder.BaseHolder;
import com.limy.codebase.adapter.viewholder.DateHolder;
import com.limy.codebase.adapter.viewholder.ImageViewHolder;
import com.limy.codebase.adapter.viewholder.MainViewHolder;
import com.limy.codebase.data.Model;
import com.limy.codebase.data.Type;

import java.util.ArrayList;
import java.util.List;


/**
 * @author limy
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private List<Model> data = new ArrayList<>();

  public void setData(List<Model> data) {
    this.data = data;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Type type = Type.values()[viewType];
    switch (type) {
      case POST: {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.cb_item_post, parent, false);
        return new MainViewHolder(v);
      }
      case DATE: {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.cb_item_date, parent, false);
        return new DateHolder(v);
      }
      case IMAGE: {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.cb_item_image, parent, false);
        return new ImageViewHolder(v);
      }
    }

    return null;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof BaseHolder) {
      ((BaseHolder) holder).bind(data.get(position));
    } else {
      throw new IllegalArgumentException("All view holder must be subclass of BaseHolder.");
    }
  }

  @Override
  public void onViewRecycled(RecyclerView.ViewHolder holder) {
    if (holder instanceof BaseHolder) {
      ((BaseHolder) holder).unbind();
    } else {
      throw new IllegalArgumentException("All view holder must be subclass of BaseHolder.");
    }
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  @Override
  public int getItemViewType(int position) {
    return data.get(position).type.ordinal();
  }

}
