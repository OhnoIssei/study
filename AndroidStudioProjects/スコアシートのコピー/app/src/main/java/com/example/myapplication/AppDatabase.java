package com.example.myapplication;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AccessTime.class},
        version = 4,
        autoMigrations = {@AutoMigration (from = 1, to = 4)},
        exportSchema = true
        )

public abstract class AppDatabase extends RoomDatabase {
    //アクセスタイムDAOの呼び出し
    public abstract AccessTimeDao accessTimeDao();


}

