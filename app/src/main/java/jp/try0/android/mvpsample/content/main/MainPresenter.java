package jp.try0.android.mvpsample.content.main;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import javax.inject.Inject;

import jp.try0.android.mvpsample.api.ApiCommunicationEvent;
import jp.try0.android.mvpsample.api.IGitHubApiService;
import jp.try0.android.mvpsample.api.res.GitHubUserInfo;
import jp.try0.android.mvpsample.usecase.IMainUseCase;
import okhttp3.ResponseBody;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;

    @Inject
    IMainUseCase useCase;

    @Inject
    IGitHubApiService.FetchUserEventBus eventBus;

    @Inject
    public MainPresenter(MainContract.View view){
        this.view = view;
    }


    @Override
    public void initializePresenter() {
        eventBus.register(this);
    }

    @Override
    public void finalizePresenter() {
        eventBus.unregister(this);
    }

    @Override
    public void printUserInformation(String accountName) {
        Log.i("MainPresenter", "print");

        useCase.fetchUserInformation(accountName);

    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFetchedUserInformation(ApiCommunicationEvent<GitHubUserInfo> event) {
        try {
            view.printUserInformation(event.getResponse().body());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
