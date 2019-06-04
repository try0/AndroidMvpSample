package jp.try0.android.mvpsample.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jp.try0.android.mvpsample.content.main.MainActivity;
import jp.try0.android.mvpsample.content.main.MainActivityModule;

/**
 * ActivityModule
 */
@Module(includes = UseCaseModule.class)
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    public abstract MainActivity mainActivity();





}
