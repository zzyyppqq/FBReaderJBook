package com.paragon.dictionary.fbreader.higo.readbook.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhangyipeng on 16/1/16.
 */
public class SettingArray implements Serializable {
    private ArrayList<SettingItem> list;

    public ArrayList<SettingItem> getList() {
        return list;
    }

    public void setList(ArrayList<SettingItem> list) {
        this.list = list;
    }
}
