package text.bwei.com.lgank.fuli.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.lgank.R;
import text.bwei.com.lgank.fuli.bean.FuliBean;

/**
 * Created by dell on 2017/12/19.
 */

public class MyFuliAdapter extends RecyclerView.Adapter {

    List<FuliBean.ResultsBean> list;
    Context context;

    public MyFuliAdapter(List<FuliBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fuli_item, parent, false);
        return new MyfuliViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyfuliViewHolder myfuliViewHolder = (MyfuliViewHolder) holder;
        myfuliViewHolder.mImageFuli.setImageURI(list.get(position).getUrl());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyfuliViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_fuli)
        SimpleDraweeView mImageFuli;

        public MyfuliViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
