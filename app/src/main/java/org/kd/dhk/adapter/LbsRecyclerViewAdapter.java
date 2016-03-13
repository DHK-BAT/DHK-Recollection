package org.kd.dhk.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.kd.dhk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 代号:隐无为
 * 时间:2016/1/27
 * 用途：
 */
public class LbsRecyclerViewAdapter extends RecyclerView.Adapter<LbsRecyclerViewAdapter.ViewHolder> {
  private List<String> dataList=new ArrayList<String>();
  Activity activity;
  public List<String> getDataList() {
    return dataList;
  }

  public  LbsRecyclerViewAdapter(Activity activity){
    this.activity = activity;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {

    Picasso.with(activity)
            .load(dataList.get(position))
            .placeholder(R.drawable.bg_mezi_1)
            .error(R.drawable.bg_mezi_2)
            .into(holder.imageView);
  }

  @Override
  public int getItemCount() {
    return dataList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public ViewHolder(View itemView) {
      super(itemView);
      imageView = (ImageView) itemView.findViewById(R.id.wall_image);
  }
  }
}
