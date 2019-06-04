package jp.try0.android.mvpsample.di.module;

import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import jp.try0.android.mvpsample.MvpSampleApp;

/**
 * Application Module
 */
@Module
public class AppModule {

    private final MvpSampleApp app;

    public AppModule(MvpSampleApp app) {
        this.app = app;
    }

    @Provides
    MvpSampleApp provideMvpSampleApp() {
        return app;
    }

    @Provides
    Context provideContext() {
        return app;
    }

}
