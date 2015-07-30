package com.limy.codebase;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.limy.codebase.common.App;
import com.limy.codebase.common.CrashLogTree;
import com.limy.codebase.common.ExceptionHandler;
import com.limy.codebase.common.LocalLogTree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import timber.log.Timber;

/**
 * @author limy
 */
public class BaseApplication extends Application {

  private static BaseApplication INSTANCE;

  private ExecutorService executorService = Executors.newCachedThreadPool();

  public static BaseApplication getInstance() {
    return INSTANCE;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    INSTANCE = this;

    App.initInstance(this);

    // Timber 中的CrashReportingTree 依赖App
    initTimber();

    // 初始化ExceptionHandler 依赖Timber
    initExceptionHandler();

    // 初始化必要组件
    initComponents();
  }

  private void initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
      Timber.plant(new LocalLogTree());
    } else {
      // TODO: plan release tree.
    }
    Timber.plant(new CrashLogTree());
  }

  private void initExceptionHandler() {
    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
  }

  private void initComponents() {
    Fresco.initialize(this);
  }

  public ExecutorService getExecutorService() {
    return executorService;
  }

}
