package com.tournity.App.CreateAndListGroup.Bloc.Controllers;

import android.app.Activity;
import android.content.Context;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tournity.App.CreateAndListGroup.Repository.Models.ListGroupModel;
import com.tournity.App.CreateAndListGroup.View.Activities.ListGroupActivity;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

import java.util.ArrayList;

public class ListGroupController {
    protected ListGroupActivity context;

    public ListGroupController(Context context) {
        this.context = (ListGroupActivity) context;
    }
    public void listGroups(){
        final ArrayList<String>listGroupName = new ArrayList<>();
        ModelListener grListener = new ModelListener<ListGroupModel>() {
            @Override
            public void onSuccess(ListGroupModel model) {

                for (int i=0;i<model.getMyGroupArray().length;i++){
                    listGroupName.add(model.getMyGroupArray()[i].getName());
                }
                ArrayAdapter adapter = new ArrayAdapter(context,
                        android.R.layout.simple_expandable_list_item_1,listGroupName);
                context.listView.setAdapter(adapter);
            }

            @Override
            public void onError(ModelError error) {

            }
        };
    }
}
