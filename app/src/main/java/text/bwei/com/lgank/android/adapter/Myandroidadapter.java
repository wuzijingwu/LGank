package text.bwei.com.lgank.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.lgank.R;
import text.bwei.com.lgank.android.bean.AdndroidBean;

/**
 * Created by dell on 2017/12/18.
 */

public class Myandroidadapter extends RecyclerView.Adapter {
    List<AdndroidBean.ResultsBean> list;
    Context context;

    public Myandroidadapter(List<AdndroidBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.android_item, parent, false);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.text1_android.setText(list.get(position).getDesc());


        List<String> images = list.get(position).getImages();
        if (images != null) {
            myViewHolder.sdv_image.setImageURI(images.get(0).toString());
       

        } else {
            myViewHolder.sdv_image.setImageResource(R.drawable.azz);
        }
//

        myViewHolder.text2_android.setText(list.get(position).getWho());
        String publishedAt = list.get(position).getPublishedAt();
        StringBuffer buffer = new StringBuffer(list.get(position).getPublishedAt());
        buffer.delete(buffer.indexOf("T"), buffer.lastIndexOf(""));
        SpannableString span = new SpannableString(buffer.toString());
        span.setSpan(new UnderlineSpan(), 0, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        myViewHolder.text3_android.setText(span);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv_image)
        SimpleDraweeView sdv_image;
        @BindView(R.id.text1_android)
        TextView text1_android;
        @BindView(R.id.text2_android)
        TextView text2_android;
        @BindView(R.id.text3_android)
        TextView text3_android;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
