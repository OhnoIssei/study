package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //アプリが起動した時に実行するメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //スーパークラスのonCreateの呼び出し（中身はわからないがonCreateを利用する際のお決まりのような物？）
        super.onCreate(savedInstanceState);
        //どのレイアウトファイルを画面に表示するか決めている
        setContentView(R.layout.content_main);
        Button bt = findViewById(R.id.button1);

        //ボタン押下時
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SubActivityに画面遷移
                Intent intent = new Intent(getApplication(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Button bt_list = findViewById(R.id.button6);

        //ボタン押下時
        bt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SubActivityに画面遷移
                Intent intent = new Intent(getApplication(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}





