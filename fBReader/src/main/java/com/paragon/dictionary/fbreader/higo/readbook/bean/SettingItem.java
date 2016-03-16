package com.paragon.dictionary.fbreader.higo.readbook.bean;

import java.io.Serializable;

/**
 * Created by zhangyipeng on 16/1/16.
 */
public class SettingItem implements Serializable{

    private String name;
    private String action;
    private Integer icon;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}
