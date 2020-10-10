package com.example.mytry01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MusicListActivity extends AppCompatActivity {


    private MediaPlayer mp ;
    private boolean isPause=false;
    private Button play;
    private Button pause;
    private Button stop;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        play=(Button) findViewById(R.id.button1);
        pause=(Button) findViewById(R.id.button2);
        stop=(Button) findViewById(R.id.button3);
        back=(Button) findViewById(R.id.back);

        mp=MediaPlayer.create(this, R.raw.test);//创建mediaplayer对象



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                play();
                if (isPause) {
                    pause.setText("暂停");
                    isPause = false;

                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mp.isPlaying()&&!isPause){
                    mp.pause();
                    isPause=true;
                    pause.setText("继续");

                    play.setEnabled(true);
                }else{
                    mp.start();
                    pause.setText("暂停");

                    isPause=false;
                    play.setEnabled(false);
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mp.stop();
                pause.setEnabled(false);
                stop.setEnabled(false);
                play.setEnabled(true);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MusicListActivity.this,LoginActivity.class));
                finish();
            }
        });

    }

    private void play(){
        try{
            mp.reset();
            mp=MediaPlayer.create(this, R.raw.test);//重新设置要播放的音频
            mp.start();//开始播放
            play.setEnabled(false);
            pause.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();//输出异常信息
        }
    }




    protected void onDestroy() {
        // TODO Auto-generated method stub
        if(mp.isPlaying()){
            mp.stop();
        }
        mp.release();//释放资源
        super.onDestroy();
    }



}