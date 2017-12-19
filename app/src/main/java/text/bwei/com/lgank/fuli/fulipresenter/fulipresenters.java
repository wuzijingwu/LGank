package text.bwei.com.lgank.fuli.fulipresenter;

import java.util.List;

import text.bwei.com.lgank.fuli.FuliFragment;
import text.bwei.com.lgank.fuli.bean.FuliBean;
import text.bwei.com.lgank.fuli.model.Ifulimodel;
import text.bwei.com.lgank.fuli.model.Onfuli;
import text.bwei.com.lgank.fuli.model.model;
import text.bwei.com.lgank.fuli.view.Ifuliview;

/**
 * Created by dell on 2017/12/19.
 */

public class fulipresenters {
    Ifulimodel ifulimodel;
    Ifuliview ifuliview;

    public fulipresenters(FuliFragment ifuliview) {
        this.ifuliview = ifuliview;
        ifulimodel = new model();
    }

    public void getFuli(String url, int pages) {
        ifulimodel.Requestfuli(url, pages, new Onfuli() {
            @Override
            public void datafuli(List<FuliBean.ResultsBean> list) {
                ifuliview.showfuli(list);
            }
        });


    }


}
