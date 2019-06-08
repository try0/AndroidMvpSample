package jp.try0.android.mvpsample.db.entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Unique;

@Entity
public class User {
    @Id(assignable = true)
    public long id;

    @Unique
    public String name;
}

