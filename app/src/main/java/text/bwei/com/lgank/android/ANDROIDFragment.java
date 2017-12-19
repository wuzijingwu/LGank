package text.bwei.com.lgank.android;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.lgank.R;
import text.bwei.com.lgank.android.adapter.Myandroidadapter;
import text.bwei.com.lgank.android.api.Api;
import text.bwei.com.lgank.android.bean.AdndroidBean;
import text.bwei.com.lgank.android.presenter.presenter;
import text.bwei.com.lgank.android.view.Iview;

/**
 * Created by dell on 2017/12/18.
 */

public class ANDROIDFragment extends Fragment implements Iview {
    @BindView(R.id.recycler_android)
    RecyclerView recycler_android;

    private View view;
    private Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private int pages = 1;
    private text.bwei.com.lgank.android.presenter.presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.androidfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new presenter(this);
        presenter.getAndroid(Api.URL, pages);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showandwroid(final List<AdndroidBean.ResultsBean> list) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recycler_android.setLayoutManager(linearLayoutManager);

        recycler_android.setAdapter(new Myandroidadapter(list, getActivity()));
        recycler_android.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == list.size() - 1) {
                    pages++;
                    presenter.getAndroid(Api.URL, pages);
                }


            }
        });

    }
}