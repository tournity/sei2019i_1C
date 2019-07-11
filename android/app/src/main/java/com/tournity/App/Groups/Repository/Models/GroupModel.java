package com.tournity.App.Groups.Repository.Models;

import android.content.Context;

import com.tournity.App.Groups.Entities.GroupEntity;
import com.tournity.App.Groups.Repository.Repositories.GroupRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class GroupModel {
    GroupEntity [] myGroupArray;

    public GroupModel(GroupEntity[] myGroupArray) {
        this.myGroupArray = myGroupArray;
    }

    public static void listGroups(Context context, final ModelListener<GroupModel> listener){
        RepositoryListener repositoryListener = new RepositoryListener<GroupEntity []>() {
            @Override
            public void onQueryCompleted(GroupEntity [] entity) {
                GroupModel groupModel = new GroupModel(entity);
                listener.onSuccess(groupModel);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        GroupRepository.getAll(context,repositoryListener);
    }

    public GroupEntity[] getMyGroupArray() {
        return myGroupArray;
    }
    public static void assemble(Context context,String name,final ModelListener<GroupModel> listener){
        GroupEntity group = new GroupEntity();
        group.setName(name);
        RepositoryListener repoListener = new RepositoryListener<GroupEntity>() {
            @Override
            public void onQueryCompleted(GroupEntity entity) {
                listener.onSuccess(null);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        GroupRepository.createGroup(context,group,repoListener);
    }
}
