package jp.try0.android.mvpsample.service;

import jp.try0.android.mvpsample.db.entity.User;

public interface IUserAccountService {

    void print();

    void saveUser(User user);

    User getUser();
}
