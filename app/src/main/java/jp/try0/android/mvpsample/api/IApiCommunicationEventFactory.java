package jp.try0.android.mvpsample.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface IApiCommunicationEventFactory<T> {
    ApiCommunicationEvent create(Call<T> call, Response<T> response);
    ApiCommunicationEvent create(Call<T> call, Throwable t);
}
