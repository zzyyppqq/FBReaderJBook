package com.paragon.dictionary.fbreader.higo.readbook.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.paragon.dictionary.fbreader.higo.readbook.bean.SettingItem;

import org.geometerplus.zlibrary.ui.android.R;

import java.util.ArrayList;

/**
 * Created by zhangyipeng on 16/1/16.
 */
public class BookSettingAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<SettingItem> list;
    private View view;

    public BookSettingAdapter(Context context, ArrayList<SettingItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.book_setting_item, null);

        TextView tv_desc = (TextView) view.findViewById(R.id.setting_desc);
        ImageView iv_icon = (ImageView) view.findViewById(R.id.setting_icon);
        tv_desc.setText(list.get(position).getName());
        Integer icon = list.get(position).getIcon();
        if(icon!=null) {
            iv_icon.setImageResource(icon);
        }
        return view;
    }
}
