package com.example.mytry01.domain;

import lombok.Data;

public class MusicInfo {
    //歌曲名
    private String musicName;
    //歌曲作者
    private String musicAuthor;
    //歌曲时长
    private Integer duration;
    //歌曲路径
    private String musicPath;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }
}
