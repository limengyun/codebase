package com.limy.codebase;

import android.content.Context;
import android.content.Intent;

import com.limy.codebase.activity.SettingsActivity;
import com.limy.codebase.activity.TestActivity;

/**
 * @author limy
 */
public class NavigationManager {
  public static void navigateToSettings(Context context) {
    Intent intent = new Intent(context, SettingsActivity.class);
    context.startActivity(intent);
  }

  public static void navigateToTest(Context context) {
    Intent intent = new Intent(context, TestActivity.class);
    context.startActivity(intent);
  }
}
