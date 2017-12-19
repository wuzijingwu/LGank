package text.bwei.com.lgank.android.presenter;

import java.util.List;

import text.bwei.com.lgank.android.bean.AdndroidBean;
import text.bwei.com.lgank.android.model.Imodel;
import text.bwei.com.lgank.android.model.Onandroid;
import text.bwei.com.lgank.android.model.model;
import text.bwei.com.lgank.android.view.Iview;

/**
 * Created by dell on 2017/12/18.
 */

public class presenter {
    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getAndroid(String url,int pages) {
        imodel.Requestandroid(url,pages, new Onandroid() {
            @Override
            public void androidSuccess(List<AdndroidBean.ResultsBean> list) {
                iview.showandwroid(list);
            }
        });


    }

}
