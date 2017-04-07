package com.general.motors.omnibus;


import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListFragmentHelper {

    private ListView listView;
    private ToDoListObject toDoListObject;

    public ToDoListFragmentHelper(Context context){
        if(toDoListObject == null){
            toDoListObject = ToDoListObject.getInstance();
            toDoListObject.fetchData(context);
        }
    }

    public void setListView(View view) {
        listView = (ListView) view.findViewById(R.id.listItems);
        listView.setAdapter(toDoListObject.getAddListAdapter());
        setupRemoveTodoFunctionality();
    }

    private void setupRemoveTodoFunctionality() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toDoListObject.removeItem(position);
                return false;
            }
        });

    }

    private void onAddItem(View view){
        if(toDoListObject != null){
            EditText todo = (EditText) view.findViewById(R.id.newItem);
            toDoListObject.addItem(todo.getText().toString());
        }
    }

    public void setupAddListItemView(final View view) {
        Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddItem(view);
            }
        });
    }
}
