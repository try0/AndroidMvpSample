package jp.try0.android.mvpsample.api;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 指定されたBusあてにイベントを送信するApi通信コールバック
 *
 * @param <T>
 */
public class EventPushCallBack<T> implements Callback<T> {

    private final EventBus eventBus;

    private IApiCommunicationEventFactory<T> eventFactory = new IApiCommunicationEventFactory<T>() {

        @Override
        public ApiCommunicationEvent create(Call<T> call, Response<T> response) {
            return ApiCommunicationEvent.create(call, response);
        }

        @Override
        public ApiCommunicationEvent create(Call<T> call, Throwable t) {
            return ApiCommunicationEvent.create(call, t);
        }
    };

    /**
     * コンストラクター
     *
     * @param eventBus
     */
    public EventPushCallBack(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        ApiCommunicationEvent<T> event = eventFactory.create(call, response);
        eventBus.post(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        ApiCommunicationEvent<T> event = eventFactory.create(call, t);
        eventBus.post(event);
    }

    public void setEventFactory(IApiCommunicationEventFactory<T> eventFactory) {
        if (eventFactory == null) {
            throw new IllegalArgumentException("");
        }
        this.eventFactory =  eventFactory;
    }
}
