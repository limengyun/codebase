package com.limy.codebase.common;

import android.text.format.DateFormat;
import android.util.Log;

import com.limy.codebase.BaseApplication;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

import timber.log.Timber;

/**
 * @author limy
 */
public class CrashLogTree extends Timber.Tree {

  private ExecutorService executorService = BaseApplication.getInstance().getExecutorService();

  @Override
  protected boolean isLoggable(int priority) {
    return priority == Log.ASSERT || priority == Log.ERROR;
  }

  @Override
  protected void log(int priority, String tag, String message, Throwable t) {
    if (t == null) {
      return;
    }
    executorService.submit(new LogTask(message));
  }

  class LogTask implements Runnable {
    String message;

    LogTask(String message) {
      this.message = message;
    }

    @Override
    public void run() {
      CharSequence format = DateFormat.format("yyyy-MM-dd-hh-mm-ss", System.currentTimeMillis());
      String fileName = String.format("crash/%s.txt", format);
      File logFile = new File(App.getInstance().externalDir, fileName);
      try {
        FileUtils.writeStringToFile(logFile, message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
