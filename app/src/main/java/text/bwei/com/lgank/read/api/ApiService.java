package text.bwei.com.lgank.read.api;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import text.bwei.com.lgank.read.bean.ReadBean;

/**
 * Created by dell on 2017/12/19.
 */

public interface ApiService {

    @GET("api/data/all/20/{pages}")
    Observable<ReadBean> getread(@Path("pages") int pages);
}
