package text.bwei.com.lgank.fuli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.lgank.R;
import text.bwei.com.lgank.fuli.adapter.MyFuliAdapter;
import text.bwei.com.lgank.fuli.api.Apifuli;
import text.bwei.com.lgank.fuli.bean.FuliBean;
import text.bwei.com.lgank.fuli.fulipresenter.fulipresenters;
import text.bwei.com.lgank.fuli.view.Ifuliview;

/**
 * Created by dell on 2017/12/18.
 */

public class FuliFragment extends Fragment implements Ifuliview {
    @BindView(R.id.recycler_fuli)
    RecyclerView recycler_fuli;
    @BindView(R.id.xianxing_fuli)
    FloatingActionButton xianxing_fuli;
    @BindView(R.id.liushi_fuli)
    FloatingActionButton liushi_fuli;
    @BindView(R.id.pubu_fuli)
    FloatingActionButton pubu_fuli;
    @BindView(R.id.changeMaptypeBtn)
    FloatingActionsMenu changeMaptypeBtn;
    private View view;
    private Unbinder unbinder;
    private int pages = 1;
    private GridLayoutManager gridLayoutManager;
    private text.bwei.com.lgank.fuli.fulipresenter.fulipresenters fulipresenters;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fulifragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fulipresenters = new fulipresenters(this);
        fulipresenters.getFuli(Apifuli.URLFULI, pages);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showfuli(final List<FuliBean.ResultsBean> list) {
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recycler_fuli.setLayoutManager(gridLayoutManager);
        recycler_fuli.setAdapter(new MyFuliAdapter(list, getActivity()));
        recycler_fuli.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == list.size() - 1) {
                    pages++;
                    fulipresenters.getFuli(Apifuli.URLFULI, pages);

                }

            }
        });


        xianxing_fuli.setOnClickListener(new View.OnClickListener() {

            private LinearLayoutManager linearLayoutManager;

            @Override
            public void onClick(View view) {
                linearLayoutManager = new LinearLayoutManager(getActivity());
                recycler_fuli.setLayoutManager(linearLayoutManager);
                recycler_fuli.setAdapter(new MyFuliAdapter(list, getActivity()));
                recycler_fuli.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                        if (lastVisibleItemPosition == list.size() - 1) {
                            pages++;
                            fulipresenters.getFuli(Apifuli.URLFULI, pages);

                        }

                    }
                });

            }
        });

        liushi_fuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycler_fuli.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                recycler_fuli.setAdapter(new MyFuliAdapter(list, getActivity()));
                recycler_fuli.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        int lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                        if (lastVisibleItemPosition == list.size() - 1) {
                            pages++;
                            fulipresenters.getFuli(Apifuli.URLFULI, pages);

                        }

                    }
                });


            }
        });

        pubu_fuli.setOnClickListener(new View.OnClickListener() {

            private StaggeredGridLayoutManager staggeredGridLayoutManager;

            @Override
            public void onClick(View view) {
                staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                recycler_fuli.setLayoutManager(staggeredGridLayoutManager);
                recycler_fuli.setAdapter(new MyFuliAdapter(list, getActivity()));



            }
        });


    }


}
