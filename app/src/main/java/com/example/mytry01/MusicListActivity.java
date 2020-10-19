package com.example.mytry01;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.mytry01.adapter.MusicListAdapter;
import com.example.mytry01.domain.MusicInfo;
import com.example.mytry01.util.MusicUtil;

import java.util.List;


public class MusicListActivity extends AppCompatActivity {


    private MediaPlayer mp;
    private boolean isPause = false;
    private Button play;
    private Button pause;
    private Button stop;
    private Button back;
    private ListView musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && this.checkSelfPermission
                (Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            this.requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        musicList = findViewById(R.id.musicList);
        List<MusicInfo> list = MusicUtil.findAllMusic(this);
        MusicListAdapter musicListAdapter = new MusicListAdapter(this, list);
        musicList.setAdapter(musicListAdapter);
    }

    private void play() {
        try {
            mp.reset();
            mp = MediaPlayer.create(this, R.raw.test);//重新设置要播放的音频
            mp.start();//开始播放
            play.setEnabled(false);
            pause.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();//输出异常信息
        }
    }


    protected void onDestroy() {
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();//释放资源
        super.onDestroy();
    }


}