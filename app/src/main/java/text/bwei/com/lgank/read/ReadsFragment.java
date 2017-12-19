package text.bwei.com.lgank.read;

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
import text.bwei.com.lgank.read.adapter.MyReadAdapter;
import text.bwei.com.lgank.read.api.Apiread;
import text.bwei.com.lgank.read.bean.ReadBean;
import text.bwei.com.lgank.read.readpresenter.ReadPresenter;
import text.bwei.com.lgank.read.view.IreadView;

/**
 * Created by dell on 2017/12/18.
 */

public class ReadsFragment extends Fragment implements IreadView {

    @BindView(R.id.recycler_read)
    RecyclerView recycler_read;
    private int pages = 2;
    private ReadPresenter readPresenter;
    private View view;
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.readfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        readPresenter = new ReadPresenter(this);
        readPresenter.getRead(Apiread.URLREAD, pages);

    }


    @Override
    public void showRead(List<ReadBean.ResultsBean> list) {
        recycler_read.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_read.setAdapter(new MyReadAdapter(list, getActivity()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
