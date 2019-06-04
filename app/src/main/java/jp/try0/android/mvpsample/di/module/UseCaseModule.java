package jp.try0.android.mvpsample.di.module;

import dagger.Binds;
import dagger.Module;
import jp.try0.android.mvpsample.usecase.IMainUseCase;
import jp.try0.android.mvpsample.usecase.MainUseCase;

@Module
public abstract class UseCaseModule {

    @Binds
   abstract IMainUseCase bindMainUseCase(MainUseCase useCase);
}
