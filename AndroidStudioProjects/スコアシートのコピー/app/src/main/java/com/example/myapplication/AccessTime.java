package com.example.myapplication;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

//データベース保管されるレコードは全てEntityのインスタンスとして得られるようになっている
@Entity
public class AccessTime {
    //主キー
    @PrimaryKey(autoGenerate = true)
    private int id;
    //名前
    @ColumnInfo(name = "access_time")
    private String accessTime;
    //番号
    @ColumnInfo(name = "player_number",defaultValue = "0")
    private int playerNumber;

    //2PIN
    @ColumnInfo(name = "point2_in",defaultValue="0")
    private int point2in;
    //2POUT

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "ALTER TABLE AccessTime ADD COLUMN player_number INTEGE　NOT NULL DEFAULT 0");
        }
    };
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "ALTER TABLE AccessTime ADD COLUMN player_number INTEGER");
        }
    };
    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "ALTER TABLE AccessTime ADD COLUMN point2_in INTEGER");
        }
    };



    /*

    @ColumnInfo(defaultValue="0")
    private int point2out;
    //3PIN
    @ColumnInfo(defaultValue="0")
    private int point3in;
    //3POUT
    @ColumnInfo(defaultValue="0")
    private int point3out;
    //FTIN
    @ColumnInfo(defaultValue="0")
    private int point1in;
    //FTOUT
    @ColumnInfo(defaultValue="0")
    private int point1out;
    //OR
    @ColumnInfo(defaultValue="0")
    private int offenseRebound;
    //DR
    @ColumnInfo(defaultValue="0")
    private int defenseRebound;
    //AST
    @ColumnInfo(defaultValue="0")
    private int assist;
    //STL
    @ColumnInfo(defaultValue="0")
    private int Steel;
    //BLK
    @ColumnInfo(defaultValue="0")
    private int block;
    //TO
    @ColumnInfo(defaultValue="0")
    private int turnOver;
    */

    //アクセスタイムカラムに値を入れる
    public AccessTime(String accessTime) {this.accessTime = accessTime;}
    public String getAccessTime() {return accessTime;}
    public void setAccessTime(String accessTime) {this.accessTime = accessTime;}
    //idカラムに値を入れる
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setPlayerNumber(int playerNumber) {this.id = playerNumber;}
    public int getPlayerNumber() {return playerNumber;}

    public void setPoint2in(int point2in) {this.id = point2in;}
    public int getPoint2in() {return point2in;}



    //idカラムに入っている値を返す
    //アクセスタイムカラムに値を入れる。AccessTime関数と同じ？
}
