package jp.try0.android.mvpsample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.try0.android.mvpsample.api.IGitHubApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("unused")
@Module
public class ApiModule {


    @Singleton
    @Provides
    OkHttpClient provideHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        return okHttpClient;
    }

    @Singleton
    @Provides
    IGitHubApiService provideGithubApiService(OkHttpClient httpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IGitHubApiService.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGitHubApiService apiService = retrofit.create(IGitHubApiService.class);
        return  apiService;
    }

}
