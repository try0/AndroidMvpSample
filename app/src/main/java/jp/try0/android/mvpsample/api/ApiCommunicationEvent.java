package jp.try0.android.mvpsample.api;

import retrofit2.Call;
import retrofit2.Response;

public class ApiCommunicationEvent<T> {

    public static <RES> ApiCommunicationEvent<RES> create(Call<RES> call, Response<RES> response) {
        return new ApiCommunicationEvent<>(call, response);
    }

    public static <RES> ApiCommunicationEvent<RES> create(Call<RES> call, Throwable throwable) {
        return new ApiCommunicationEvent<>(call, throwable);
    }

    public final Call<T> call;

    private Response<T> response;

    private Throwable throwable;

    public ApiCommunicationEvent(Call<T> call) {
        this.call = call;
    }

    public ApiCommunicationEvent(Call<T> call, Response<T> response) {
        this.call = call;
        this.response = response;
    }

    public ApiCommunicationEvent(Call<T> call, Throwable throwable) {
        this.call = call;
        this.throwable = throwable;
    }

    public Call<T> getCall() {
        return call;
    }

    public Response<T> getResponse() {
        return response;
    }

    public void setResponse(Response<T> response) {
        this.response = response;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
