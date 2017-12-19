package text.bwei.com.lgank.ios.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.lgank.ios.api.ApiService;
import text.bwei.com.lgank.ios.bean.Iosbean;


/**
 * Created by dell on 2017/12/18.
 */

public class model implements Imodel {
    @Override
    public void RequestIos(String url, int pages, final OnIosseclect onIosseclect) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
//        10/1
        Observable<Iosbean> getios = apiService.getios(pages);

        getios.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Iosbean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Iosbean iosbean) {
                        List<Iosbean.ResultsBean> results = iosbean.getResults();
                        onIosseclect.dataIos(results);

                    }
                });

    }
}
