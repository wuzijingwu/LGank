package text.bwei.com.lgank.ios.adapter;

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
import text.bwei.com.lgank.ios.bean.Iosbean;

/**
 * Created by dell on 2017/12/18.
 */

public class Myiosadapter extends RecyclerView.Adapter {

    List<Iosbean.ResultsBean> list;
    Context context;

    public Myiosadapter(List<Iosbean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ios_item, parent, false);
        return new MyiosViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyiosViewHolder myiosViewHolder = (MyiosViewHolder) holder;
        myiosViewHolder.text1_ios.setText(list.get(position).getDesc());
        myiosViewHolder.text2_ios.setText(list.get(position).getWho());
        String publishedAt = list.get(position).getPublishedAt();
        StringBuffer buffer = new StringBuffer(list.get(position).getPublishedAt());
        buffer.delete(buffer.indexOf("T"), buffer.lastIndexOf(""));
        SpannableString span = new SpannableString(buffer.toString());
        span.setSpan(new UnderlineSpan(), 0, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        myiosViewHolder.text3_ios.setText(span);

        if (list.get(position).getImages() != null) {
            myiosViewHolder.image_ios.setImageURI(list.get(position).getImages().get(0));
        } else {
            myiosViewHolder.image_ios.setImageResource(R.drawable.azz);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyiosViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_ios)
        SimpleDraweeView image_ios;
        @BindView(R.id.text1_ios)
        TextView text1_ios;
        @BindView(R.id.text2_ios)
        TextView text2_ios;
        @BindView(R.id.text3_ios)
        TextView text3_ios;

        public MyiosViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
