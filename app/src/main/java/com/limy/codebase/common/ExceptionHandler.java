package com.limy.codebase.common;

import timber.log.Timber;

/**
 * @author limy
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

  private final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

  public ExceptionHandler() {
    defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
  }

  @Override
  public void uncaughtException(Thread thread, Throwable ex) {
    Timber.e(ex, null);

    // 用来让应用崩溃，否则就ANR永远无响应了。
    defaultUncaughtExceptionHandler.uncaughtException(thread, ex);
  }
}
