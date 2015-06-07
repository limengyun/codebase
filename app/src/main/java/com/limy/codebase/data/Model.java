package com.limy.codebase.data;


/**
 * @author limy
 */
public class Model {

  public Type type;

  public String avatar;

  public String title;

  public String author;

  public long time;

  public String summary;

  public String url;

  public int width;

  public int height;

  public Model(Type type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Model{" +
        "type=" + type +
        ", avatar='" + avatar + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", summary='" + summary + '\'' +
        ", url='" + url + '\'' +
        ", width='" + width + '\'' +
        ", height='" + height + '\'' +
        '}';
  }
}
