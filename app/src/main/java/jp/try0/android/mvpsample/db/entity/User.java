package jp.try0.android.mvpsample.db.entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class User {
    @Id(assignable = true)
    public long id;

    public String name;
}

