package com.example.duhongwang20180514.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.duhongwang20180514.R;
import com.example.duhongwang20180514.adapter.MyAdapter;
import com.example.duhongwang20180514.bean.NewsBean;
import com.example.duhongwang20180514.presenter.MyPresenter;
import com.example.duhongwang20180514.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created   by    Dewey
 */
public class Duanzi_Fragment extends Fragment implements MyView {
    private List<NewsBean.DataBean>  list = new ArrayList<>();
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    private MyPresenter presenter;
    private MyAdapter adapter;

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

        return view;
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        if (newsBean != null){
            adapter.addData(newsBean.getData());
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
