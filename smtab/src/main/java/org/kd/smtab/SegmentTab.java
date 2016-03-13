package org.kd.smtab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;
import java.util.List;

/**
 * 代号:隐无为
 * 时间:2016/1/31
 * 用途：
 */
public class SegmentTab extends LinearLayout {
  int position=0;
  List<TextView> list=new ArrayList<TextView>();
  private onSegmentViewClickListener listener;
  public SegmentTab(Context context, AttributeSet attrs) {
    super(context, attrs);
    initViews(context, attrs);
  }

  public SegmentTab(Context context) {
    super(context);
  }
  //获取属性值并初始化
  private void  initViews(Context context, AttributeSet attrs){
    TypedArray ay = context.obtainStyledAttributes(attrs, R.styleable.SegmentTab);
    String textValue = ay.getString(R.styleable.SegmentTab_textValue);
    float textSize = ay.getDimension(R.styleable.SegmentTab_textSize, 10);
    ay.recycle();
    initTextViews(textValue, textSize);
  }

  //循环初始化TextViews
  private void initTextViews(String textValue,float textSize){
    String[]values=textValue.split("#");
    if(values.length<2){
     throw  new RuntimeException("至少两个文本值或缺少#符号隔开");
    }

    TextView textView;

    for (int i=0;i<values.length;i++){
      textView=new TextView(getContext());
      textView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
      textView.setText(values[i]);
      XmlPullParser xrp = getResources().getXml(R.xml.segment_text_sele);
      try {
        ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);
        textView.setTextColor(csl);
        textView.setTextColor(csl);
      } catch (Exception e) {
        throw new RuntimeException("资源文件有误");
      }
      textView.setGravity(Gravity.CENTER);
      textView.setPadding(3, 6, 3, 6);
      textView.setTextSize(textSize);
      if(i==0){
        textView.setBackgroundResource(R.drawable.segment_left_sele);
        textView.setSelected(true);
      }else if(i==values.length-1){
        textView.setBackgroundResource(R.drawable.segment_right_sele);
      }else{
        textView.setBackgroundResource(R.drawable.segment_middle_sele);
      }
      this.addView(textView);
      list.add(textView);
      setListenerEvent(textView,position++);
    }


  }
//设置TextView监听事件
private  void setListenerEvent(final TextView textView,final int position){
  textView.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
      if (textView.isSelected()) {
        return;
      }
      toggleSelect(textView);
      if (listener != null) {
        listener.onSegmentViewClick(textView, position);
      }
    }
  });
}

  //切换选择
 private void  toggleSelect(final TextView textView){
   for (TextView t:list){
     if(textView.equals(t)){
       t.setSelected(true);
     }else{
       t.setSelected(false);
     }
   }
  }

  //对外暴露一个设置事件监听的方法
  public void setOnSegmentViewClickListener(onSegmentViewClickListener listener) {
    this.listener = listener;
  }

  //切换选择事件接口
  public  interface onSegmentViewClickListener{
    public  void onSegmentViewClick(View v, int position);
  }
  /**static class属于内部类，相当于类的一个成员。只能通过外部类来调用它。
   * static abstract class属于内部抽象类类
   *同样，static interface也是这样，只能在包含它的类中实现和使用。
   * 其实 去掉 static 也行
   * 也可以用 抽象类 的抽象方法
   * 功能:设置切换改变事件
   * 代号:隐无为
   * 时间:2016/2/1<p>
   * 参数:
   */
}
