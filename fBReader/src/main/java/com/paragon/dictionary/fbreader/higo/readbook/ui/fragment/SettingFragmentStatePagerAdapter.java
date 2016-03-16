package com.paragon.dictionary.fbreader.higo.readbook.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zhangyipeng on 16/1/16.
 */
public class SettingFragmentStatePagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;
    public SettingFragmentStatePagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments=fragments;

    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
