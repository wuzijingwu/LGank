package text.bwei.com.lgank.fuli.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import text.bwei.com.lgank.fuli.bean.FuliBean;


/**
 * Created by dell on 2017/12/19.
 */

public interface ApiService {
//    api/data/%E7%A6%8F%E5%88%A9/10/1

    @GET("api/data/%E7%A6%8F%E5%88%A9/10/{pages}")
    Observable<FuliBean> getfuli(@Path("pages") int pages);
}


