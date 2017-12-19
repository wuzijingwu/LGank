package text.bwei.com.lgank.ios.Iospresenter;

import java.util.List;

import text.bwei.com.lgank.ios.bean.Iosbean;
import text.bwei.com.lgank.ios.model.Imodel;
import text.bwei.com.lgank.ios.model.OnIosseclect;
import text.bwei.com.lgank.ios.model.model;
import text.bwei.com.lgank.ios.view.Iview;

/**
 * Created by dell on 2017/12/18.
 */

public class presenter {
    Iview iview;
    Imodel imodel;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();

    }

    public void getIos(String url, int pages) {
        imodel.RequestIos(url, pages, new OnIosseclect() {
            @Override
            public void dataIos(List<Iosbean.ResultsBean> list) {
                iview.showIos(list);
            }
        });


    }

}
