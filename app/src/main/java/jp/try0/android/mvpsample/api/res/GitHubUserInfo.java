package jp.try0.android.mvpsample.api.res;

import java.io.Serializable;

/**
 * @see https://developer.github.com/v3/users/
 */
public class GitHubUserInfo implements Serializable {

    public String login;
    public long id;
    public String nodeId;
    public String avatarUrl;
    public String gravatarId;

    public String url;
    public String htmlUrl;

    public String followersUrl;
    public String followingUrl;

    public String gistsUrl;
    public String starredUrl;
    public String subscriptionsUrl;

    public String organizationsUrl;
    public String reposUrl;
    public String eventsUrl;
    public String receivedEventsUrl;
    public String type;
    public boolean siteAdmin;
    public String name;


    public String company;
    public String blog;

    public String location;

    public String email;
    public boolean hireable;

    public String bio;

    public int publicRepos;
    public int publicGists;


    public int followers;
    public int following;

    public String createdAt;
    public String updatedAt;

}
