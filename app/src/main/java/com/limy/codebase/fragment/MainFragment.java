package com.limy.codebase.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limy.codebase.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

  public MainFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.cb_fragment_main, container, false);
  }
}
