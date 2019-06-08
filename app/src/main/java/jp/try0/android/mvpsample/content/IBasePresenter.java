package jp.try0.android.mvpsample.content;

import android.util.Log;

public interface IBasePresenter {

    default void initializePresenter() {
        Log.d(getClass().getSimpleName(), "initialize presenter");
    }

    default void finalizePresenter() {
        Log.d(getClass().getSimpleName(), "finalize presenter");
    }
}
