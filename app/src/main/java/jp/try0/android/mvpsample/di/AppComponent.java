package jp.try0.android.mvpsample.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import jp.try0.android.mvpsample.MvpSampleApp;
import jp.try0.android.mvpsample.di.module.ActivityModule;
import jp.try0.android.mvpsample.di.module.AppModule;
import jp.try0.android.mvpsample.di.module.DaoModule;
import jp.try0.android.mvpsample.di.module.ServiceModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        AppModule.class,
        ServiceModule.class,
        DaoModule.class,
        ActivityModule.class})
public interface AppComponent extends AndroidInjector<MvpSampleApp> {


}
