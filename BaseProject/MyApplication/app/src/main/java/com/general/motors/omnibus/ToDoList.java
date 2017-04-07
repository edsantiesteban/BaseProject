package com.general.motors.omnibus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ToDoList extends Fragment{

    private ToDoListFragmentHelper helper;

    public static ToDoList newInstance(){
        return new ToDoList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new ToDoListFragmentHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_listview, container, false);
        helper.setListView(view);
        return view;
    }


}
