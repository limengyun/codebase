package com.limy.codebase;

import android.app.Application;

import com.limy.codebase.common.App;
import com.limy.codebase.common.CrashLogTree;
import com.limy.codebase.common.ExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import timber.log.Timber;

/**
 * @author limy
 */
public class BaseApplication extends Application {

  private static BaseApplication INSTANCE;

  private ExecutorService executorService;

  public static BaseApplication getInstance() {
    return INSTANCE;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    INSTANCE = this;

    App.initInstance(this);

    // 初始化必要组件
    initComponents();

    // Timber 中的CrashReportingTree 依赖App
    initTimber();

    // 初始化ExceptionHandler 依赖Timber
    initExceptionHandler();
  }

  private void initComponents() {
    executorService = Executors.newCachedThreadPool();
  }

  private void initExceptionHandler() {
    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
  }

  private void initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    } else {
      // TODO: plan release tree.
    }
    Timber.plant(new CrashLogTree());
  }

  public ExecutorService getExecutorService() {
    return executorService;
  }

}
