package jp.try0.android.mvpsample.content.main;

import jp.try0.android.mvpsample.content.IBasePresenter;
import jp.try0.android.mvpsample.content.IBaseView;

public interface MainContract {

    interface View extends IBaseView {

        void printedInformation();
    }

    interface Presenter extends IBasePresenter {
        void print();
    }

}
