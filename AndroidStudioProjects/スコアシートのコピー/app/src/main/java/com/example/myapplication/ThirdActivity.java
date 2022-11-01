package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

//一覧画面
public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //スーパークラスのonCreateの呼び出し（中身はわからないがonCreateを利用する際のお決まりのような物？）
        super.onCreate(savedInstanceState);
        //どのレイアウトファイルを画面に表示するか決めている
        setContentView(R.layout.fragment_first);

        //オブジェクトを取得（オブジェクトの動作を決める時に必要）
        TextView tv = findViewById(R.id.index);
        TextView tv2 = findViewById(R.id.index2);
        TextView tv3 = findViewById(R.id.index3);
        TextView tv4 = findViewById(R.id.index4);

        //データベースの値を全て取得
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        AppDatabase db = AppDatabaseSingleton.getInstance(getApplicationContext());
        AccessTimeDao accessTimeDao = db.accessTimeDao();
        List<AccessTime> atList = accessTimeDao.getAll();

        for (AccessTime at: atList) {
            sb.append(at.getId()).append("\n");
        }
        tv.setText(sb.toString());

        for (AccessTime at: atList) {
            sb2.append(at.getAccessTime()).append("\n");
        }
        tv2.setText(sb2.toString());

        for (AccessTime at: atList) {
            sb3.append(at.getPlayerNumber()).append("\n");
        }
        tv3.setText(sb3.toString());

        for (AccessTime at: atList) {
            sb4.append(at.getPoint2in()).append("\n");
        }
        tv4.setText(sb4.toString());





        //戻るボタン押下時処理
        Button bt_list = findViewById(R.id.button1);
        bt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SubActivityに画面遷移
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });

        //全消去ボタン押下時処理
        Button bt_delete = findViewById(R.id.button2);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                AppDatabase db = AppDatabaseSingleton.getInstance(getApplicationContext());
                AccessTimeDao accessTimeDao = db.accessTimeDao();
                accessTimeDao.clear();
                List<AccessTime> atList = accessTimeDao.getAll();
                for (AccessTime at: atList) {
                    sb.append(at.getId()).append("\n");
                }
                tv.setText(sb.toString());

                for (AccessTime at: atList) {
                    sb2.append(at.getAccessTime()).append("\n");
                }
                tv2.setText(sb2.toString());
            }
        });

        //カラム指定で削除
        Button bt_deleteLine = findViewById(R.id.button3);
        bt_deleteLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                AppDatabase db = AppDatabaseSingleton.getInstance(getApplicationContext());
                AccessTimeDao accessTimeDao = db.accessTimeDao();
                accessTimeDao.deleteById(3);
                List<AccessTime> atList = accessTimeDao.getAll();
                for (AccessTime at: atList) {
                    sb.append(at.getId()).append("\n");
                }
                tv.setText(sb.toString());

                for (AccessTime at: atList) {
                    sb2.append(at.getAccessTime()).append("\n");
                }
                tv2.setText(sb2.toString());
            }
        });

        //更新ボタン
        Button bt_update = findViewById(R.id.button4);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                AppDatabase db = AppDatabaseSingleton.getInstance(getApplicationContext());
                AccessTimeDao accessTimeDao = db.accessTimeDao();
                accessTimeDao.updateLine(3);
                accessTimeDao.updateNumber(4);
                List<AccessTime> atList = accessTimeDao.getAll();
                for (AccessTime at: atList) {
                    sb.append(at.getId()).append("\n");
                }
                tv.setText(sb.toString());

                for (AccessTime at: atList) {
                    sb2.append(at.getAccessTime()).append("\n");
                }
                tv2.setText(sb2.toString());
            }
        });
    }

}
