package com.general.motors.omnibus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TodoListViewPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;
    public TodoListViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ToDoList.newInstance();
            case 1:
                return DeletedList.newInstance();
            default:
                return null;
        }
    }
}