package com.tournity.App.CreateAndListGroup.Repository.Models;

import android.content.Context;

import com.tournity.App.CreateAndListGroup.Entities.GroupEntity;
import com.tournity.App.CreateAndListGroup.Repository.Repositories.CreateGroupRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class CreateGroupModel {
    public static void assemble(Context context,String name,final ModelListener<CreateGroupModel> listener){
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
        CreateGroupRepository.createGroup(context,group,repoListener);
    }
}
