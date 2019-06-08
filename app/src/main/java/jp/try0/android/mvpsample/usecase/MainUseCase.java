package jp.try0.android.mvpsample.usecase;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import javax.inject.Inject;

import jp.try0.android.mvpsample.api.ApiCommunicationEvent;
import jp.try0.android.mvpsample.api.IGitHubApiService;
import jp.try0.android.mvpsample.service.IUserAccountService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainUseCase implements IMainUseCase {

    @Inject
    IUserAccountService sUserAccount;


    @Inject
    public MainUseCase() {
    }


    @Override
    public void fetchUserInformation(String accountName) {
        sUserAccount.fetchUser(accountName);
    }
}
