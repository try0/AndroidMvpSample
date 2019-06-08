package jp.try0.android.mvpsample.content.main;

import jp.try0.android.mvpsample.api.res.GitHubUserInfo;
import jp.try0.android.mvpsample.content.IBasePresenter;
import jp.try0.android.mvpsample.content.IBaseView;

public interface MainContract {

    interface View extends IBaseView {

        void printUserInformation(GitHubUserInfo userInformation);
    }

    interface Presenter extends IBasePresenter {
        void printUserInformation(String accountName);
    }

}
