package com.example.mytry01.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mytry01.R;
import com.example.mytry01.domain.MusicInfo;

import java.util.List;

public class MusicListAdapter extends BaseAdapter {

    private List<MusicInfo> list;
    private Context context;

    public MusicListAdapter(Context context, List<MusicInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MusicInfo musicInfo = list.get(i);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.music_item, null);
            ItemBuilder builder = new ItemBuilder();
            builder.musicName = view.findViewById(R.id.itemName);
            builder.musicName.setText(musicInfo.getMusicName());
            builder.musicAuthor = view.findViewById(R.id.musicAuthor);
            builder.musicAuthor.setText(musicInfo.getMusicAuthor());
            builder.itemIcon = view.findViewById(R.id.itemIcon);
            builder.itemIcon.setBackgroundResource(R.drawable.play_no);
            view.setTag(builder);
        } else {
            ItemBuilder builder = (ItemBuilder) view.getTag();
            builder.musicName.setText(musicInfo.getMusicName());
            builder.musicAuthor.setText(musicInfo.getMusicAuthor());
            builder.itemIcon.setBackgroundResource(R.drawable.play_no);
        }
        return view;
    }

    private class ItemBuilder {
        public TextView musicName, musicDuration,musicAuthor;
        public ImageButton itemIcon;
    }
}
