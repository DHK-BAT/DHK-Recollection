package org.kd.dhk.model;

/**
 * 代号:隐无为
 * 时间:2016/1/29
 * 用途：多玩的图片json
 */
public class DuowanImage {
private  String html;// 给多玩网站瀑布用的
private  String more;//
private  String offset;// 页数
private  String enabled;//

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public String getMore() {
    return more;
  }

  public void setMore(String more) {
    this.more = more;
  }

  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }
}
