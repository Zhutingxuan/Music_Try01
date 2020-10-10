package com.example.mytry01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BtLoginactivityBack;
    private Button BtLoginactivityLogin;
    private EditText EtLoginactivitynumber;
    private EditText EtLoginactivitypassword;
    private DBOpenHelper mDBOpenHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        mDBOpenHelper = new DBOpenHelper(this);

        EtLoginactivitynumber.setText(getIntent().getStringExtra("Number1"));
        EtLoginactivitypassword.setText(getIntent().getStringExtra("Password1"));


    }


    private void initView(){

        //初始化控件
        BtLoginactivityBack = findViewById(R.id.back);
        BtLoginactivityLogin = findViewById(R.id.login);
        EtLoginactivitynumber = findViewById(R.id.number);
        EtLoginactivitypassword = findViewById(R.id.password);


        //设置点击事件监听
        BtLoginactivityBack.setOnClickListener(this);
        BtLoginactivityLogin.setOnClickListener(this);



    }

    public void onClick(View view){
        switch (view.getId()){

            case R.id.back:
                startActivity(new Intent(this,FirstActivity.class));
                finish();
                break;

            case R.id.login:
                String name = EtLoginactivitynumber.getText().toString().trim();
                String password = EtLoginactivitypassword.getText().toString().trim();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
                    ArrayList<User> data = mDBOpenHelper.getAllData();
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++){
                        User user = data.get(i);
                        if (name.equals(user.getName()) && password.equals(user.getPassword())){
                            match = true;
                            break;
                        }else{
                            match = false;
                        }
                    }
                    if(match){
                        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this,MusicListActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}