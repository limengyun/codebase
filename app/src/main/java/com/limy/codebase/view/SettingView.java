package com.limy.codebase.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.limy.codebase.R;


/**
 * @author limy
 */
public class SettingView extends FrameLayout {

  private boolean showIndicator;
  private boolean indicatorOn;
  private ImageView indicator;
  private String subTitle;
  private String title;
  private TextView titleTextView;
  private TextView subTitleTextView;

  public SettingView(Context context) {
    super(context);
    init(context, null);
  }

  public SettingView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SettingView, 0, 0);
    showIndicator = a.getBoolean(R.styleable.SettingView_show_indicator, false);
    title = a.getString(R.styleable.SettingView_setting_title);
    subTitle = a.getString(R.styleable.SettingView_setting_subtitle);
    a.recycle();
    LayoutInflater.from(context).inflate(R.layout.cb_layout_setting_view, this, true);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    indicator = (ImageView) findViewById(R.id.indicator);
    titleTextView = (TextView) findViewById(R.id.title);
    subTitleTextView = (TextView) findViewById(R.id.sub_title);
    if (showIndicator) {
      indicator.setVisibility(VISIBLE);
    } else {
      indicator.setVisibility(GONE);
    }

    if (TextUtils.isEmpty(title)) {
      titleTextView.setVisibility(GONE);
    } else {
      titleTextView.setVisibility(VISIBLE);
      titleTextView.setText(title);
    }

    if (TextUtils.isEmpty(subTitle)) {
      subTitleTextView.setVisibility(GONE);
    } else {
      subTitleTextView.setVisibility(VISIBLE);
      subTitleTextView.setText(subTitle);
    }
  }

  public void setSubTitle(String text) {
    subTitleTextView.setText(text);
  }

  public void setShowIndicator(boolean showIndicator) {
    this.showIndicator = showIndicator;
  }

  public void setIndicatorOn(boolean indicatorOn) {
    this.indicatorOn = indicatorOn;
    if (indicatorOn) {
      indicator.setImageResource(R.mipmap.ic_switch_on);
    } else {
      indicator.setImageResource(R.mipmap.ic_switch_off);
    }
  }

  public boolean getIndicatorOn() {
    return this.indicatorOn;
  }
}
