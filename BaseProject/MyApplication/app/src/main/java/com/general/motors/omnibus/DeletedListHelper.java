package com.general.motors.omnibus;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

public class DeletedListHelper {
    private ListView deletedListView;
    private ToDoListObject toDoListObject;

    public DeletedListHelper(Context context){
        if(toDoListObject == null){
            toDoListObject = ToDoListObject.getInstance();
            toDoListObject.fetchData(context);
        }
    }

    public void setupDeletedListView(View view) {
        deletedListView = (ListView) view.findViewById(R.id.deltetedListItems);
        deletedListView.setAdapter(toDoListObject.getDeletedListAdapter());
    }
}
