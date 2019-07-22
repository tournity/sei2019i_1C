package com.tournity.App.Group.Repository.Models;

import android.content.Context;

import com.tournity.App.Group.Entities.GroupEntity;
import com.tournity.App.Group.Repository.Repositories.GroupRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.ArrayList;

public class GroupModel {
    GroupEntity  groupEntity;

    public GroupModel(GroupEntity myGroupArray) {
        this.groupEntity = myGroupArray;
    }

    public static void listGroups(Context context, final ModelListener<ArrayList<GroupModel>> listener){
        RepositoryListener repositoryListener = new RepositoryListener<ArrayList<GroupEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<GroupEntity>  entities) {
                ArrayList arrayList = new ArrayList<GroupModel>();
                for (GroupEntity entity:entities) {
                    GroupModel groupModel = new GroupModel(entity);
                    arrayList.add(groupModel);
                }
                listener.onSuccess(arrayList);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        GroupRepository.selectAll(context,repositoryListener);
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
        GroupRepository.insert(context,group,repoListener);
    }

    public String getName() {
        return groupEntity.getName();
    }
}
