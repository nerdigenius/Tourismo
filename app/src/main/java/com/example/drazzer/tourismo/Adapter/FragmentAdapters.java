package com.example.drazzer.tourismo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drazzer on 12/11/2017.
 */

public class FragmentAdapters extends FragmentStatePagerAdapter {
    private final List<Fragment> fragments=new ArrayList<>();
    public FragmentAdapters(FragmentManager fm) {
        super(fm);
    }

    private void addFragment(Fragment fragment)
    {
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
