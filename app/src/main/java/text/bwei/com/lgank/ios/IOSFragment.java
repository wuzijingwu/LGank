package text.bwei.com.lgank.ios;

import android.os.Bundle;
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
import text.bwei.com.lgank.ios.Iospresenter.presenter;
import text.bwei.com.lgank.ios.adapter.Myiosadapter;
import text.bwei.com.lgank.ios.api.Apios;
import text.bwei.com.lgank.ios.bean.Iosbean;
import text.bwei.com.lgank.ios.view.Iview;

/**
 * Created by dell on 2017/12/18.
 */

public class IOSFragment extends Fragment implements Iview{
    @BindView(R.id.recyler_ios)
    RecyclerView recyler_ios;
    private View view;
    private Unbinder unbinder;
    private int pages=2;
    private LinearLayoutManager linearLayoutManager;
    private text.bwei.com.lgank.ios.Iospresenter.presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.iosfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new presenter(this);
        presenter.getIos(Apios.URLIOS,pages);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showIos(final List<Iosbean.ResultsBean> list) {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyler_ios.setLayoutManager(linearLayoutManager);
        recyler_ios.setAdapter(new Myiosadapter(list,getActivity()));
        recyler_ios.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == list.size() - 1) {
                    pages++;
                    presenter.getIos(Apios.URLIOS,pages);
                }


            }
        });
    }
}
