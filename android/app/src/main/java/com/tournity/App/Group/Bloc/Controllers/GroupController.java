package com.tournity.App.Group.Bloc.Controllers;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tournity.App.Group.Repository.Models.GroupModel;
import com.tournity.App.Group.View.Activities.ListGroupActivity;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

import java.util.ArrayList;

public class GroupController {
    protected ListGroupActivity context;

    public GroupController(Context context) {
        this.context = (ListGroupActivity) context;
    }

    public void listGroups() {
        ModelListener grListener = new ModelListener<ArrayList<GroupModel>>() {
            @Override
            public void onSuccess(ArrayList<GroupModel> models) {
                ArrayList<String> listGroupName = new ArrayList<>();
                for (GroupModel model:models) {
                    listGroupName.add(model.getName());
                }
                ArrayAdapter adapter = new ArrayAdapter(context,
                        android.R.layout.simple_expandable_list_item_1, listGroupName);
                context.listView.setAdapter(adapter);
            }

            @Override
            public void onError(ModelError error) {

            }
        };
        GroupModel.listGroups(context, grListener);
    }

    public void create(String name) {
        if (validateNameLength(name)) {
            ModelListener crGrListener = new ModelListener<GroupModel>() {
                @Override
                public void onSuccess(GroupModel model) {
                    Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(ModelError error) {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            };
            GroupModel.assemble(context, name, crGrListener);
        } else {
            Toast.makeText(context, "Invalid name", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateNameLength(String name) {
        return name.length() >= 3;
    }
}
