package com.limy.codebase.common;

import android.content.Context;
import android.os.Environment;

import com.limy.codebase.util.Util;

import java.io.File;


/**
 * @author limy
 */
public class App {
  private static App INSTANCE;

  public final String packageName;
  public final String versionName;
  public final int versionCode;

  public final String model;
  public final String manufacturer;
  public final String IMEI;
  public final String sdkVersionName;
  public final int sdkVersionInt;
  public final String language;
  public final String country;

  public final File externalDir;

  private App(Context context) {
    this.packageName = Util.getPackageName(context);
    this.versionName = Util.getVersionName(context);
    this.versionCode = Util.getVersionCode(context);

    this.model = Util.getModel();
    this.manufacturer = Util.getManufacturer();
    this.IMEI = Util.getIMEI(context);
    this.sdkVersionName = Util.getSdkVersionName();
    this.sdkVersionInt = Util.getSdkVersionInt();
    this.language = Util.getLocale(context).getLanguage();
    this.country = Util.getLocale(context).getCountry();

    this.externalDir = new File(Environment.getExternalStorageDirectory(), packageName);
  }

  public static App initInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (App.class) {
        if (INSTANCE == null) {
          INSTANCE = new App(context);
        }
      }
    }
    return INSTANCE;
  }

  public static App getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "App{" +
        "packageName='" + packageName + '\'' +
        ", versionName='" + versionName + '\'' +
        ", versionCode=" + versionCode +
        '}';
  }
}
