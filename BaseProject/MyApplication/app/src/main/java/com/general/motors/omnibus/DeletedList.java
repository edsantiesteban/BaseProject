package com.general.motors.omnibus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DeletedList extends Fragment{

    DeletedListHelper helper;

    public static DeletedList newInstance(){
        return new DeletedList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new DeletedListHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deleted_view_layout, container, false);
        helper.setupDeletedListView(view);
        return view;
    }
}
