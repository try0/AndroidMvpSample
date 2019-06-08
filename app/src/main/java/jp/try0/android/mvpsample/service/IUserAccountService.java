package jp.try0.android.mvpsample.service;

import jp.try0.android.mvpsample.db.entity.User;

public interface IUserAccountService {

    /**
     * ユーザー情報を保存します。
     *
     * @param user
     */
    void addUser(User user);

    /**
     * ユーザー情報を取得します。
     *
     * @return
     */
    User getUser(String userName);

    /**
     * ユーザー情報をダウンロードします。
     *
     * @param accountName
     */
    void fetchUser(String accountName);
}
