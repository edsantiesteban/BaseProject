package com.general.motors.omnibus;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class ToDoListObject{
    private Context context;
    private ArrayAdapter<String> addedItemsListAdapter;
    private ArrayAdapter<String> deletedItemsListAdapter;
    private ArrayList<String> todoListItems;
    private ArrayList<String> deletedListItems;

    private static ToDoListObject ourInstance;

    public static ToDoListObject getInstance() {
        if( ourInstance == null){
            ourInstance = new ToDoListObject();
        }
        return ourInstance;
    }

    private ToDoListObject() {
        if(todoListItems == null){
            todoListItems = new ArrayList<String>();
        }
        if(deletedListItems == null){
            deletedListItems = new ArrayList<String>();
        }
    }

    public void addItem(String newToDoListItem){
        addedItemsListAdapter.add(newToDoListItem);
        addedItemsListAdapter.notifyDataSetChanged();
        persistData();
    }

    public void removeItem(int position){
        deletedListItems.add(todoListItems.get(position).toString());
        todoListItems.remove(position);

        addedItemsListAdapter.notifyDataSetChanged();
        deletedItemsListAdapter.notifyDataSetChanged();
        persistData();
    }

    public ListAdapter getAddListAdapter() {
        if (addedItemsListAdapter == null) {
            addedItemsListAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, todoListItems);
        }
        return addedItemsListAdapter;
    }

    public ListAdapter getDeletedListAdapter() {
        if (deletedItemsListAdapter == null) {
            deletedItemsListAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, deletedListItems);
        }
        return deletedItemsListAdapter;
    }

    public void persistData(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("Add_List_Size", todoListItems.size());
        for(int i=0;i<todoListItems.size();i++)
        {
            editor.remove("Add_Index_" + i);
            editor.putString("Add_Index_" + i, todoListItems.get(i));
        }

        editor.putInt("Delete_List_Size", deletedListItems.size());
        for(int i=0;i<deletedListItems.size();i++)
        {
            editor.remove("Delete_Index_" + i);
            editor.putString("Delete_Index_" + i, deletedListItems.get(i));
        }

        editor.commit();
    }

    public void fetchData(Context context){
        this.context = context;
        SharedPreferences sharedPreferences =   PreferenceManager.getDefaultSharedPreferences(context);

        int addSize = sharedPreferences.getInt("Add_List_Size", 0);
        int delSize = sharedPreferences.getInt("Delete_List_Size", 0);

        if(todoListItems != null || deletedListItems != null){
            todoListItems.clear();
            deletedListItems.clear();
        } else {
            todoListItems = new ArrayList<String>();
            deletedListItems = new ArrayList<String>();
        }

        for(int i=0;i<addSize;i++)
        {
            todoListItems.add(sharedPreferences.getString("Add_Index_" + i, null));
        }
        for(int i=0;i<delSize;i++)
        {
            deletedListItems.add(sharedPreferences.getString("Delete_Index_" + i, null));
        }
    }
}
