package text.bwei.com.lgank.fuli.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.lgank.fuli.api.ApiService;
import text.bwei.com.lgank.fuli.bean.FuliBean;


/**
 * Created by dell on 2017/12/19.
 */

public class model implements  Ifulimodel{
    @Override
    public void Requestfuli(String url, int pages, final Onfuli onfuli) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
//        10/1
        Observable<FuliBean> getfuli = apiService.getfuli(pages);
        getfuli.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FuliBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        List<FuliBean.ResultsBean> results = fuliBean.getResults();
                        onfuli.datafuli(results);

                    }
                });

    }
}
