package com.tournity.App.CreateAndListGroup.Repository.Models;

import android.content.Context;

import com.tournity.App.CreateAndListGroup.Entities.GroupEntity;
import com.tournity.App.CreateAndListGroup.Repository.Repositories.ListGroupRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class ListGroupModel {
    GroupEntity [] myGroupArray;

    public ListGroupModel(GroupEntity[] myGroupArray) {
        this.myGroupArray = myGroupArray;
    }

    public static void listGroups(Context context, final ModelListener<ListGroupModel> listener){
        RepositoryListener repositoryListener = new RepositoryListener<GroupEntity []>() {
            @Override
            public void onQueryCompleted(GroupEntity [] entity) {
                ListGroupModel listGroupModel = new ListGroupModel(entity);
                listener.onSuccess(listGroupModel);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        ListGroupRepository.getAll(context,repositoryListener);
    }

    public GroupEntity[] getMyGroupArray() {
        return myGroupArray;
    }
}
