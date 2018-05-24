package com.example.duhongwang20180514.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.duhongwang20180514.R;
import com.example.duhongwang20180514.bean.DataBean;
import com.example.duhongwang20180514.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created   by    Dewey
 * recyclerview展示数据
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<DataBean> list;

    public MyAdapter(Context context , List<DataBean> list ) {
        this.context = context;
        this.list = list;
    }

    //添加数据的方法
    public void addData(List<DataBean> data) {
        if (list != null) {
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //添加布局视图
        View view = View.inflate(context, R.layout.adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //设置参数数据
        holder.title.setText(list.get(position).getContent());
        holder.name.setText(list.get(position).getJid()+"");
        holder.time.setText(list.get(position).getCreateTime());
        holder.headImage.setImageURI(list.get(position).getImgUrls());
        holder.draweeView.setImageURI( (String) list.get(position).getImgUrls() );
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.headImage)
        SimpleDraweeView headImage;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.biaoti)
        TextView title;
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
