package jp.try0.android.mvpsample.di.module;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.try0.android.mvpsample.api.IGitHubApiService;

@Module
public class EventBusModule {

    @Provides
    EventBus provideDefaultEventBus() {
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    IGitHubApiService.FetchUserEventBus provideFetchUserEventBus() {
        return new IGitHubApiService.FetchUserEventBus();
    }
}
