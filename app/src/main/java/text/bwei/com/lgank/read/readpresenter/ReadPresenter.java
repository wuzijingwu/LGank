package text.bwei.com.lgank.read.readpresenter;

import java.util.List;

import text.bwei.com.lgank.read.ReadsFragment;
import text.bwei.com.lgank.read.bean.ReadBean;
import text.bwei.com.lgank.read.model.Ireadmodel;
import text.bwei.com.lgank.read.model.Onread;
import text.bwei.com.lgank.read.model.model;
import text.bwei.com.lgank.read.view.IreadView;

/**
 * Created by dell on 2017/12/19.
 */

public class ReadPresenter {
    IreadView ireadView;
    Ireadmodel ireadmodel;

    public ReadPresenter(ReadsFragment ireadView) {
        this.ireadView = ireadView;
        ireadmodel = new model();
    }

    public void getRead(String url, int pages) {
        ireadmodel.Requestread(url, pages, new Onread() {
            @Override
            public void dataRead(List<ReadBean.ResultsBean> list) {
                ireadView.showRead(list);
            }
        });


    }


}
