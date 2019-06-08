package jp.try0.android.mvpsample.api;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import jp.try0.android.mvpsample.api.res.GitHubUserInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGitHubApiService {

    String BASE_URL = "https://api.github.com";

    @GET("/users/{accountName}")
    Call<GitHubUserInfo> getUser(@Path("accountName") String accountName);

    class FetchUserEventBus extends EventBus {
    }

    class FetchUserEvent {
        public Response<GitHubUserInfo> response;
        public Call<GitHubUserInfo> call;
        public  Throwable throwable;
    }

    class FetchUserCallBack implements Callback<GitHubUserInfo> {

        private final FetchUserEventBus eventBus;

        public FetchUserCallBack(FetchUserEventBus eventBus) {
            this.eventBus = eventBus;
        }

        @Override
        public void onResponse(Call<GitHubUserInfo> call, Response<GitHubUserInfo> response) {
            IGitHubApiService.FetchUserEvent event = new IGitHubApiService.FetchUserEvent();
            event.call = call;
            event.response = response;
            eventBus.post(event);
        }

        @Override
        public void onFailure(Call<GitHubUserInfo> call, Throwable t) {
            IGitHubApiService.FetchUserEvent event = new IGitHubApiService.FetchUserEvent();
            event.call = call;
            event.throwable = t;
            eventBus.post(event);
        }
    }

}
