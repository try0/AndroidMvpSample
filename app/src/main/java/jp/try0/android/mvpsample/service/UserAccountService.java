package jp.try0.android.mvpsample.service;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import jp.try0.android.mvpsample.api.IGitHubApiService;
import jp.try0.android.mvpsample.api.res.GitHubUserInfo;
import jp.try0.android.mvpsample.db.entity.User;
import jp.try0.android.mvpsample.db.entity.User_;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAccountService implements IUserAccountService {

    @Inject
    BoxStore boxStore;

    @Inject
    IGitHubApiService gitHubApiService;

    @Inject
    IGitHubApiService.FetchUserEventBus fetchUserEventBus;

    @Inject
    public UserAccountService() {
    }

    @Override
    public void addUser(final User user) {

        final Box<User> userBox = boxStore.boxFor(User.class);

        boxStore.runInTx(() -> {
            userBox.put(user);
        });
    }

    @Override
    public User getUser(String userName) {
        return boxStore.boxFor(User.class).query()
                .equal(User_.name, userName)
                .build()
                .findFirst();
    }

    @Override
    public void fetchUser(String accountName) {
        Call<GitHubUserInfo> userInfoCall = gitHubApiService.getUser(accountName);
        userInfoCall.enqueue(new IGitHubApiService.FetchUserCallBack(fetchUserEventBus));
    }
}
