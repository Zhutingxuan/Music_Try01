package com.example.mytry01.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.mytry01.domain.MusicInfo;

import java.util.LinkedList;
import java.util.List;

public class MusicUtil {

    final static String TAG = "MusicUtil";
    static Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    private static String[] projection = {MediaStore.Audio.Media.DISPLAY_NAME
            , MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.SIZE};

    public static List<MusicInfo> findAllMusic(Context context) {
        List<MusicInfo> list = new LinkedList<>();
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC);
        while (cursor.moveToNext()) {
            MusicInfo info = new MusicInfo();
            String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
            String musicName = "";
            if (name.contains(".mp3")) {
                System.out.println(1111);
                musicName = name.replaceAll(".mp3", " ");
            }
            //音频文件名
            info.setMusicName(musicName);
            Log.d(TAG, "name:" + info.getMusicName());

            //作者
            info.setMusicAuthor(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
            Log.d(TAG, "MusicAuthor:" + info.getMusicAuthor());
            //音频文件路径＋文件名
            info.setMusicPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
            Log.d(TAG, "path:" + info.getMusicPath());
            //歌曲时长
            info.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
            Log.d(TAG, "时长:" + info.getDuration());
            list.add(info);
        }
        return list;
    }

    public static String formatTime(int time) {
        int minute = time / 1000 / 60;
        int second = time / 1000 % 60;
        return second < 10 ? minute + ":0" + second : (minute + ":" + second);
    }
}
