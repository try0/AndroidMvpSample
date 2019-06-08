package jp.try0.android.mvpsample.usecase;

import android.util.Log;

import javax.inject.Inject;

import jp.try0.android.mvpsample.db.entity.User;
import jp.try0.android.mvpsample.service.IUserAccountService;

public class MainUseCase implements IMainUseCase {

    @Inject
    IUserAccountService sUserAccount;

    @Inject
    public MainUseCase() {
    }

    @Override
    public void print() {


        sUserAccount.print();

        User user = new User();
        user.name = "User Name";

        sUserAccount.addUser(user);

        User selected = sUserAccount.getUser();
        Log.i("MainUseCase", selected.name);
    }
}
