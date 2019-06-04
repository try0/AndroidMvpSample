package jp.try0.android.mvpsample;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import jp.try0.android.mvpsample.di.DaggerAppComponent;
import jp.try0.android.mvpsample.di.module.AppModule;

public class MvpSampleApp extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
