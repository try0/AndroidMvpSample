package jp.try0.android.mvpsample.di.module;

import dagger.Binds;
import dagger.Module;
import jp.try0.android.mvpsample.service.IUserAccountService;
import jp.try0.android.mvpsample.service.UserAccountService;

/**
 * サービスモジュール
 */
@SuppressWarnings("unused")
@Module
public abstract class ServiceModule {
    @Binds
    abstract IUserAccountService bindUserAccountService(UserAccountService service);
}
