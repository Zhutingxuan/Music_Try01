package com.example.mytry01;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NumberList extends AppCompatActivity implements View.OnClickListener {

    private TextView TvNumberlistnumber1;
    private TextView TvNumberlistpassword1;
    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_list);

        initView();
    }

    public void initView() {
        TvNumberlistnumber1 = findViewById(R.id.number1);
        TvNumberlistpassword1 = findViewById(R.id.password1);
        back = findViewById(R.id.back);


        TvNumberlistnumber1.setOnClickListener(this);
        TvNumberlistpassword1.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        String str1 = TvNumberlistnumber1.getText().toString();
        String str2 = TvNumberlistpassword1.getText().toString();



        switch (view.getId()) {

            case R.id.number1:

                Intent intent1 = new Intent(this, LoginActivity.class);


                intent1.putExtra("Number1",str1);
                intent1.putExtra("Password1",str2);

                startActivity(intent1);

                finish();
                break;

            case R.id.back:
                Intent intent2 = new Intent(this,FirstActivity.class);
                startActivity(intent2);
                finish();
                break;


        }
    }
}