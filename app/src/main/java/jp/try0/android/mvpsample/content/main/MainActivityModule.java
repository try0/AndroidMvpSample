package jp.try0.android.mvpsample.content.main;

import dagger.Binds;
import dagger.Module;

@SuppressWarnings("unused")
@Module
public interface MainActivityModule {

    @Binds
    MainContract.View bindView(MainActivity activity);

    @Binds
    MainContract.Presenter bindPresenter(MainPresenter presenter);
}