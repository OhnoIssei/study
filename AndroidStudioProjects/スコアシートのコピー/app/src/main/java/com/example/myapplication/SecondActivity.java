package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    //アプリが起動した時に実行するメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //スーパークラスのonCreateの呼び出し（中身はわからないがonCreateを利用する際のお決まりのような物？）
        super.onCreate(savedInstanceState);
        //どのレイアウトファイルを画面に表示するか決めている
        setContentView(R.layout.activity_main);

        //オブジェクトを取得（オブジェクトの動作を決める時に必要）
        //TextView tv = findViewById(R.id.index);
        Button bt = findViewById(R.id.button6);

        // データベースを呼び出す
        //getApplicationContext()＝アプリの環境情報やグローバル情報を取得
        //dbにアプリの情報を格納
        AppDatabase db = AppDatabaseSingleton.getInstance(getApplicationContext());
        // ボタンクリック時のListenerをセットする
        //buttonを押した時の動作を決めている
        //bt.setOnClickListener(new SecondActivity.ButtonClickListener(this, db, tv));
        bt.setOnClickListener(new SecondActivity.ButtonClickListener(this, db));

    }
    // ボタンクリック時のListenerクラス
    private class ButtonClickListener implements View.OnClickListener {
        private Activity activity;
        private AppDatabase db;
        //private TextView tv;
        //コンストラクタ
        //private ButtonClickListener(Activity activity, AppDatabase db, TextView tv) {
        private ButtonClickListener(Activity activity, AppDatabase db) {

            this.activity = activity;
            this.db = db;
            //this.tv = tv;
        }

        @Override
        public void onClick(View view) {
            // 非同期のデータベースアクセスクラスをコールする
            //new SecondActivity.DataStoreAsyncTask(db, activity, tv).execute();
            new SecondActivity.DataStoreAsyncTask(db, activity).execute();

            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);

        }
    }
    // 非同期でデータベースにアクセスするクラス
    private static class DataStoreAsyncTask extends AsyncTask<Void, Void, Integer> {
        private WeakReference<Activity> weakActivity;
        private AppDatabase db;
        //private TextView textView;
        private StringBuilder sb;

        //コンストラクタ
        //public DataStoreAsyncTask(AppDatabase db, Activity activity, TextView textView) {
        public DataStoreAsyncTask(AppDatabase db, Activity activity) {
            this.db = db;
            weakActivity = new WeakReference<>(activity);
            //this.textView = textView;
        }

        @Override
        protected Integer doInBackground(Void... params) {

            //データベースのインスタンスを取得
            AccessTimeDao accessTimeDao = db.accessTimeDao();
            //データベースに値を格納
            accessTimeDao.insert(new AccessTime("大野"));

            return 0;
        }

    }
}
