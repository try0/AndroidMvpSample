package jp.try0.android.mvpsample.service;

import android.util.Log;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import jp.try0.android.mvpsample.db.entity.User;
import jp.try0.android.mvpsample.di.DaggerAppComponent;

public class UserAccountService implements IUserAccountService {

    @Inject
    BoxStore boxStore;

    @Inject
    public UserAccountService() {
    }

    @Override
    public void print() {
        Log.i("UserAccountService", "print user name");
    }

    @Override
    public void addUser(final User user) {

        final Box<User> userBox = boxStore.boxFor(User.class);

        boxStore.runInTx(() -> {
            userBox.put(user);
        });
    }

    @Override
    public User getUser() {
        return boxStore.boxFor(User.class).query().build().findFirst();
    }
}
