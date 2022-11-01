package com.example.myapplication;
import static com.example.myapplication.AccessTime.MIGRATION_1_2;
import static com.example.myapplication.AccessTime.MIGRATION_2_3;
import static com.example.myapplication.AccessTime.MIGRATION_3_4;

import android.content.Context;
import androidx.room.Room;

public class AppDatabaseSingleton {
    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance != null) {
            return instance;

        }
        //databaseBuilderのインスタンス作成
        //ROOMの設定
        instance = Room.databaseBuilder(context,
                AppDatabase.class, "database-name").
                addMigrations(MIGRATION_1_2)
                .addMigrations(MIGRATION_2_3)
                .addMigrations(MIGRATION_3_4)
                .allowMainThreadQueries().build();
        return instance;
    }
}
