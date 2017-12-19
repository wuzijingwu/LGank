package text.bwei.com.lgank.android.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import text.bwei.com.lgank.android.bean.AdndroidBean;

/**
 * Created by dell on 2017/12/18.
 */

public interface ApiService {
    //    api/data/Android/10/1
    @GET("api/data/Android/10/{pages}")
    Observable<AdndroidBean> getdatas(@Path("pages") int pages);
//    @POST
//    Observable<AdndroidBean> getandroid(@Url String url, @QueryMap Map<String, Integer> map);


}
