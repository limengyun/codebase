package com.limy.codebase.common;

import android.util.Log;

import com.limy.codebase.BaseApplication;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import timber.log.Timber;

/**
 * @author limy
 */
public class LocalLogTree extends Timber.Tree {

  private static ExecutorService executorService = Executors.newSingleThreadExecutor();

  private BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();

  public LocalLogTree() {
    executorService.submit(new LogTask());
  }

  @Override
  protected boolean isLoggable(int priority) {
    return priority >= Log.DEBUG;
  }

  @Override
  protected void log(int priority, String tag, String message, Throwable t) {
    logQueue.offer(message);
  }

  class LogTask implements Runnable {

    @Override
    public void run() {
      File logFile = new File(App.getInstance().externalDir, "local.log");

      while (true) {
        try {
          String s = logQueue.take();
          FileUtils.write(logFile, s, true);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
