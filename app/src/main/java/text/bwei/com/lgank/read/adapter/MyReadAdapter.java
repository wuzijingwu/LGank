package text.bwei.com.lgank.read.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.lgank.R;
import text.bwei.com.lgank.read.bean.ReadBean;

/**
 * Created by dell on 2017/12/19.
 */

public class MyReadAdapter extends RecyclerView.Adapter {
    List<ReadBean.ResultsBean> list;
    Context context;

    public MyReadAdapter(List<ReadBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.read_item, parent, false);
        return new MyReadViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyReadViewHolder myReadViewHolder = (MyReadViewHolder) holder;
        myReadViewHolder.text1_read.setText(list.get(position).getDesc());
        myReadViewHolder.text2_read.setText(list.get(position).getType());
        myReadViewHolder.text3_read.setText(list.get(position).getWho());
        myReadViewHolder.image_read.setImageURI(list.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyReadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_read)
        SimpleDraweeView image_read;
        @BindView(R.id.text1_read)
        TextView text1_read;
        @BindView(R.id.text2_read)
        TextView text2_read;
        @BindView(R.id.text3_read)
        TextView text3_read;


        public MyReadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
