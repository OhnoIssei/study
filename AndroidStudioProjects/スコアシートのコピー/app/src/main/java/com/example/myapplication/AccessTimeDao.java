package com.example.myapplication;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface AccessTimeDao {

    //List<エンティティ名>を指定する。
    @Query("SELECT * FROM accesstime")
    List<AccessTime> getAll();

    @Query("SELECT * FROM accesstime WHERE id IN (:ids)")
    List<AccessTime> loadAllByIds(int[] ids);

    @Query("DELETE FROM accesstime")
    void  clear();

    @Query("DELETE FROM accesstime WHERE id = (:ids)")
    void  deleteById(int ids);

    @Query("UPDATE accesstime SET access_time = 3 WHERE id = (:ids)")
    void updateLine(int ids);

    @Query("UPDATE accesstime SET player_number = 3 WHERE id = (:ids)")
    void updateNumber(int ids);



    @Insert
    void insertAll(AccessTime... accessTimes);

    @Insert
    void insert(AccessTime accessTime);

    @Update
    void update(AccessTime accessTime);

    @Delete
    void delete(AccessTime accessTime);
}
