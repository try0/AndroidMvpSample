package jp.try0.android.mvpsample.content;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * ベースアクティビティ
 *
 * @param <T> プレセンター
 */
public abstract class BaseActivity<T extends IBasePresenter> extends DaggerAppCompatActivity {

    @Inject
    T presenter;


    protected T presenter() {
        return presenter;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter().initializePresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter().finalizePresenter();
    }
}
