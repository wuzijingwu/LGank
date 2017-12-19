package text.bwei.com.lgank.ios.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import text.bwei.com.lgank.ios.bean.Iosbean;

/**
 * Created by dell on 2017/12/18.
 */

public interface ApiService {
    //    @GET("api/data/Android/10/{pages}")
//    Observable<AdndroidBean> getdatas(@Path("pages") int pages);
    @GET("api/data/iOS/20/{pages}")
    Observable<Iosbean> getios(@Path("pages") int pages);

}
