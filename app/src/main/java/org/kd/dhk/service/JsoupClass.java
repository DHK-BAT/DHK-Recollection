package org.kd.dhk.service;

import com.google.gson.Gson;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.kd.dhk.model.DuowanImage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 代号:隐无为
 * 时间:2016/1/29
 * 用途：爬取类
 */
public class JsoupClass {
  /**
   * 功能:获得多玩美女图片集合 (抓取方式:HTML)
   * 代号:隐无为
   * 时间:2016/1/29<p>
   * 参数:url 地址
   */
  public static List<String> getDuowanListHtml(String url) throws IOException {
    List<String> urlList = new ArrayList<String>();
      //忽视ignore ContentType
      Document doc = Jsoup.connect(url).ignoreContentType(true).get();
      Elements liList = doc.getElementById("pic-list").select("li");
      for (Element element : liList) {
        urlList.add(element.getElementsByTag("img").attr("src"));
      }

    //因为第一个是二维码要移除
    urlList.remove(0);
    return urlList;
  }

  /**
   * 功能:获得多玩美女图片集合 (抓取方式:json)
   * 代号:隐无为
   * 时间:2016/1/29<p>
   * 参数:url  全地址 分析多玩网站可知
   */
  public static List<String> getDuowanListJson(String url) {
    List<String> urlList = new ArrayList<String>();
    try {
      //忽视ignoreContentType
      Document doc = Jsoup.connect(url).ignoreContentType(true).get();
      Gson gson = new Gson();
      String json = doc.body().html();
      json = json.substring(0, json.length() - 29);//尾部后面有多余的部分
      json = StringEscapeUtils.unescapeHtml(json);
      json = StringEscapeUtils.unescapeJava(json);
      json = json.replaceAll("\"\"", "'");
      json = jsonString(json);// 也可以直接 用这个
      DuowanImage duowanImage = gson.fromJson(json, DuowanImage.class);
      Document doc2 = Jsoup.parse(duowanImage.getHtml());
      Elements liList = doc.getElementsByTag("li");
      for (Element element : liList) {
        String str = element.getElementsByTag("img").attr("src");
        str = StringEscapeUtils.unescapeJava(str);
        str = str.replaceAll("\"", "");
        urlList.add(str);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return urlList;
  }

  // class="" style="" 等等的 变成双引号变单引号
  private static String jsonString(String s) {
    char[] temp = s.toCharArray();
    int n = temp.length;
    for (int i = 0; i < n; i++) {
      if (temp[i] == ':' && temp[i + 1] == '"') {
        for (int j = i + 2; j < n; j++) {
          if (temp[j] == '"') {
            if (temp[j + 1] != ',' && temp[j + 1] != '}') {
              temp[j] = '\'';
            } else if (temp[j + 1] == ',' || temp[j + 1] == '}') {
              break;
            }
          }
        }
      }
    }
    return new String(temp);
  }

}
