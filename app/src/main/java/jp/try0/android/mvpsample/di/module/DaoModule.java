package jp.try0.android.mvpsample.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;
import jp.try0.android.mvpsample.db.ObjectBox;

/**
 * データ関連モジュール
 */
@SuppressWarnings("unused")
@Module
public class DaoModule {

    @Singleton
    @Provides
    public BoxStore provideBoxStore(Context context) {

        ObjectBox.init(context);
        return ObjectBox.get();
    }
}
