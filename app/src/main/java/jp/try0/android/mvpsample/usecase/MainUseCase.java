package jp.try0.android.mvpsample.usecase;

import javax.inject.Inject;

import jp.try0.android.mvpsample.service.IUserAccountService;

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
