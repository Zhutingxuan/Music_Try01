package com.example.mytry01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private DBOpenHelper mDBOpenHelper;
    private Button BtRegisteractivityregister;
    private Button BtRegisteractivityback;
    private EditText EtRegisteractivitynumber;
    private EditText EtRegisteractivitypassword;
    private EditText EtRegisteractivitypassword2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        mDBOpenHelper = new DBOpenHelper(this);

    }

    private void initView(){
        BtRegisteractivityregister = findViewById(R.id.register);
        BtRegisteractivityback = findViewById(R.id.back);
        EtRegisteractivitynumber = findViewById(R.id.number);
        EtRegisteractivitypassword = findViewById(R.id.password);
        EtRegisteractivitypassword2 = findViewById(R.id.password2);


        BtRegisteractivityregister.setOnClickListener(this);
        BtRegisteractivityback.setOnClickListener(this);
    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.back:
                Intent intent1 = new Intent(this,FirstActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.register:
                String name = EtRegisteractivitynumber.getText().toString().trim();
                String password = EtRegisteractivitypassword.getText().toString().trim();
                String password2 = EtRegisteractivitypassword2.getText().toString().trim();

                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(password2)){
                    mDBOpenHelper.add(name,password);
                    if (password.equals(password2) == false){
                        Toast.makeText(this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent2 = new Intent(this,LoginActivity.class);
                        startActivity(intent2);
                        finish();
                        Toast.makeText(this,"注册成功，请前往登录",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"信息不完善,注册失败",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}