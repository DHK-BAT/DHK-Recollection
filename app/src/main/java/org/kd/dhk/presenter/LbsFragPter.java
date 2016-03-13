package org.kd.dhk.presenter;

import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.kd.dhk.activity.MainActivity;
import org.kd.dhk.adapter.LbsRecyclerViewAdapter;
import org.kd.dhk.service.JsoupClass;
import org.kd.dhk.view.FragLbsView;

import java.io.IOException;
import java.util.List;

/**
 * 代号:隐无为
 * 时间:2016/1/27
 * 用途：
 */
@EBean
public class LbsFragPter {
  @Bean
  FragLbsView fragLbsView;
  @RootContext
  MainActivity mainActivity;
  List<String> UrlList;
  LbsRecyclerViewAdapter lbsRecyclerViewAdapter;
  private boolean mIsRefreshing=false;
  int page=1;//页数 递增30

  @AfterViews
  void afterViews() {
    initView();
  }
   public void initView(){
     lbsRecyclerViewAdapter =new LbsRecyclerViewAdapter(mainActivity);
     //fragLbsView.pullLoadMoreRecyclerView.setFooterViewText("OK");//设置上拉刷新文字
     //fragLbsView.pullLoadMoreRecyclerView.setLinearLayout();//线性布局
     fragLbsView.pullLoadMoreRecyclerView.setStaggeredGridLayout(2);//参数为列数
     fragLbsView.pullLoadMoreRecyclerView.setAdapter(lbsRecyclerViewAdapter);
     fragLbsView.pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
       @Override
       public void onRefresh() {
         System.out.println("下拉了");
         setRefresh();
         page = 1;
         setImageData(page);

       }

       @Override
       public void onLoadMore() {
         System.out.println("加载了");
         page++;
         setImageData(page);

       }
     });
//     fragLbsView.pullLoadMoreRecyclerView.setOnTouchListener(
//             new View.OnTouchListener() {
//               @Override
//               public boolean onTouch(View v, MotionEvent event) {
//                 if (mIsRefreshing) {
//                   return true;
//                 } else {
//                   return false;
//                 }
//               }
//             }
//     );

     //首次加载数据
     setImageData(page);
   }
   @UiThread
   void ShowImageData() {
     if(UrlList.size()==0) {
       Toast.makeText(mainActivity, "没有数据了", Toast.LENGTH_SHORT).show();
     }
    lbsRecyclerViewAdapter.getDataList().addAll(UrlList);
    lbsRecyclerViewAdapter.notifyDataSetChanged();
    fragLbsView.pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
  }
   @Background
   void setImageData(int page) {

//     UrlList = JsoupClass.getDuowanListJson("http://tu.duowan.com/m/meinv?offset="
//             + page * 30 + "&order=created&math=0.6211543285753578");
     try {
       UrlList = JsoupClass.getDuowanListHtml("http://tu.duowan.com/m/meinv?offset="
               + page * 30);
       ShowImageData();
     } catch (IOException e) {
       errorHadler();
       e.printStackTrace();
     }

   }

  @UiThread
  public void errorHadler(){
    Toast.makeText(mainActivity, "请检查网络...", Toast.LENGTH_SHORT).show();
    fragLbsView.pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
  }


  public void scrollToTop(){
    fragLbsView.pullLoadMoreRecyclerView.scrollToTop();
  }



  private void setRefresh() {
    lbsRecyclerViewAdapter.getDataList().clear();
  }
}
