package text.bwei.com.lgank.read.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.lgank.read.api.ApiService;
import text.bwei.com.lgank.read.bean.ReadBean;


/**
 * Created by dell on 2017/12/19.
 */

public class model implements Ireadmodel {
    @Override
    public void Requestread(String url, int pages, final Onread onread) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
//        10/1
        Observable<ReadBean> getread = apiService.getread(pages);

        getread.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ReadBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ReadBean readBean) {
                        List<ReadBean.ResultsBean> results = readBean.getResults();
                        onread.dataRead(results);

                    }
                });
    }
}
