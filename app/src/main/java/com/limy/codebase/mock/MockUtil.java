package com.limy.codebase.mock;

import com.limy.codebase.data.Model;
import com.limy.codebase.data.Type;

/**
 * @author limy
 */
public class MockUtil {
  public static String getWDJAvatarUrl(int index) {

    String prefix = "";
    if (index >= 100) {
      prefix = "";
    } else if (index >= 10) {
      prefix = "0";
    } else {
      prefix = "00";
    }
    String num = prefix + String.valueOf(index);

    return String.format("http://img.wdjimg.com/static-files/account/avatar/%s.jpg", num);
  }



}
