package com.example.duhongwang20180514.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.duhongwang20180514.R;
import com.example.duhongwang20180514.adapter.MyAdapter;
import com.example.duhongwang20180514.app.MyApplication;
import com.example.duhongwang20180514.bean.DataBean;
import com.example.duhongwang20180514.bean.NewsBean;
import com.example.duhongwang20180514.presenter.MyPresenter;
import com.example.duhongwang20180514.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created   by    Dewey
 */
public class Duanzi_Fragment extends Fragment implements MyView {
    private List<DataBean>  list = new ArrayList<>();
    @BindView(R.id.recyclerView)
    XRecyclerView recyclerView;
    private Unbinder unbinder;
    private MyPresenter presenter;
    private MyAdapter adapter;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.duanzi_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        //p与v交互，请求数据
        presenter = new MyPresenter(this);
        presenter.get();

        //设置布局管理器以及数据适配器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new MyAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //XRecyclerview的上拉下拉方法
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         * 在子线程内完成上拉刷新数据
                         * 对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会刷新，即使你不传递页数参数
                         */
                        presenter.get();
                        adapter.notifyDataSetChanged();
                        recyclerView.refreshComplete();
                    }
                },888);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         *    在子线程内完成下拉加载数据
                         *    对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会加载，即使你不传递页数参数
                         */
                        presenter.get();
                        adapter.notifyDataSetChanged();
                        recyclerView.loadMoreComplete();
                    }
                },888);
            }
        });
        return view;
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        if (newsBean != null){
            adapter.addData(newsBean.getData());
            //System.out.println("Data:"+newsBean.getData().toString());

            //通过IApplication.session操作数据库  //insertInIx 将集合添加到数据库
            MyApplication.session.getDataBeanDao().insertInTx(newsBean.getData());

            //添加完查询一下  loadAll()查询数据库全部内容
            List<DataBean> beanList = MyApplication.session.getDataBeanDao().loadAll();
            for (DataBean bean : beanList) {
                System.out.println("数据库 = " + bean.toString());
            }
        }

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detach();
    }
}
