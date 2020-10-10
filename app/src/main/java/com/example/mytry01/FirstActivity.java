package com.example.mytry01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BtFirstactivitylogin;
    private Button BtFirstactivityregister;
    private Button BtFirstactivityinsert;
    private Button BtFirstactivityexit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();

    }

    public void initView(){
        BtFirstactivitylogin = findViewById(R.id.login);
        BtFirstactivityregister = findViewById(R.id.register);
        BtFirstactivityinsert = findViewById(R.id.insert);
        BtFirstactivityexit = findViewById(R.id.exit);

        BtFirstactivitylogin.setOnClickListener(this);
        BtFirstactivityregister.setOnClickListener(this);
        BtFirstactivityinsert.setOnClickListener(this);
        BtFirstactivityexit.setOnClickListener(this);

    }

    public void onClick(View view){
        switch (view.getId()){

            case R.id.login:
                Intent intent1 = new Intent(this,LoginActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.register:
                Intent intent2 = new Intent(this,RegisterActivity.class);
                startActivity(intent2);
                finish();
                break;

            case R.id.insert:
                Intent intent3 = new Intent(this,NumberList.class);
                startActivity(intent3);
                finish();
                break;

            case R.id.exit:
                finish();
                break;
        }
    }
}