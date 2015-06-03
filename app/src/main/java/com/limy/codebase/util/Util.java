package com.limy.codebase.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.Locale;

/**
 * @author limy
 */
public class Util {

  public static final int FALLBACK_VERSION_CODE = 0;
  public static final String FALLBACK_VERSION_NAME = "";

  public static final String FALLBACK_MODEL = "";
  public static final String FALLBACK_SDK_VERSION_NAME = "";
  public static final int FALLBACK_SDK_VERSION_INT = 0;
  public static final String FALLBACK_IMEI = "";
  public static final String FALLBACK_MANUFACTURER = "";

  private Util() {
    throw new AssertionError();
  }

  public static String getPackageName(Context context) {
    return context.getPackageName();
  }

  public static int getVersionCode(Context context) {
    try {
      PackageInfo packageInfo = context.getPackageManager().getPackageInfo(
          context.getPackageName(), 0);
      return packageInfo.versionCode;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return FALLBACK_VERSION_CODE;
  }

  public static String getVersionName(Context context) {
    try {
      PackageInfo packageInfo = context.getPackageManager().getPackageInfo(
          context.getPackageName(), 0);
      return packageInfo.versionName;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return FALLBACK_VERSION_NAME;
  }

  public static String getModel() {
    if (!TextUtils.isEmpty(Build.MODEL)) {
      return Build.MODEL;
    }
    return FALLBACK_MODEL;
  }

  public static String getManufacturer() {
    if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
      return Build.MANUFACTURER;
    }
    return FALLBACK_MANUFACTURER;
  }

  public static String getSdkVersionName() {
    try {
      return Build.VERSION.RELEASE;
    } catch (Exception e) {
      e.printStackTrace();
      return FALLBACK_SDK_VERSION_NAME;
    }
  }

  public static int getSdkVersionInt() {
    try {
      return Build.VERSION.SDK_INT;
    } catch (Exception e) {
      e.printStackTrace();
      return FALLBACK_SDK_VERSION_INT;
    }
  }

  /**
   * 需要 READ_PHONE_STATE 权限.
   *
   * @param context
   * @return 获取IMEI
   */
  public static String getIMEI(Context context) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager) context
          .getSystemService(Context.TELEPHONY_SERVICE);
      return telephonyManager.getDeviceId();
    } catch (Exception e) {
      e.printStackTrace();
      return FALLBACK_IMEI;
    }
  }

  public static Locale getLocale(Context context) {
    Locale locale = null;
    try {
      locale = context.getResources().getConfiguration().locale;
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (locale == null) {
      locale = Locale.getDefault();
    }
    return locale;
  }

}
