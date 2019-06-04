package jp.try0.android.mvpsample.db;

import android.content.Context;
import android.util.Log;

import io.objectbox.BoxStore;
import jp.try0.android.mvpsample.db.entity.MyObjectBox;

public class ObjectBox {
    private static final String TAG = ObjectBox.class.getSimpleName();
    private static BoxStore boxStore;

    public static void init(Context context) {
        Log.d(TAG, "initialize ObjectBox");

        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();
    }

    public static BoxStore get() {
        return boxStore;
    }
}
