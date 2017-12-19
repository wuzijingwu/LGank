package text.bwei.com.lgank.android.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.lgank.android.api.ApiService;
import text.bwei.com.lgank.android.bean.AdndroidBean;

/**
 * Created by dell on 2017/12/18.
 */

public class model implements Imodel {
    @Override
    public void Requestandroid(String url, int pages, final Onandroid onandroid) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
//        10/1
        Observable<AdndroidBean> getandroid = apiService.getdatas(pages);

        getandroid.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AdndroidBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AdndroidBean adndroidBean) {
                        List<AdndroidBean.ResultsBean> results = adndroidBean.getResults();
                        onandroid.androidSuccess(results);
                    }
                });


    }
}
