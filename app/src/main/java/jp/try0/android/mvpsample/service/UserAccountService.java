package jp.try0.android.mvpsample.service;

import android.util.Log;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import jp.try0.android.mvpsample.db.entity.User;

public class UserAccountService implements IUserAccountService {

    @Inject
    BoxStore sotre;

    @Inject
    public UserAccountService() {
    }

    @Override
    public void print() {
        Log.i("UserAccountService", "print user name");
    }

    @Override
    public void saveUser(final User user) {

        final Box<User> userBox = sotre.boxFor(User.class);

        sotre.runInTx(new Runnable() {
            @Override
            public void run() {
                userBox.put(user);
            }
        });
    }

    @Override
    public User getUser() {
        return sotre.boxFor(User.class).query().build().findFirst();
    }
}
