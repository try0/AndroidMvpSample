package jp.try0.android.mvpsample.api;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import jp.try0.android.mvpsample.api.res.GitHubUserInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGitHubApiService {

    String BASE_URL = "https://api.github.com";

    @GET("/users/{accountName}")
    Call<GitHubUserInfo> getUser(@Path("accountName") String accountName);

    class FetchUserEventBus extends EventBus
    {
    }

}
