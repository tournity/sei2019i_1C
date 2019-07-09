package com.tournity.App.Authentication.Repository.Models;

import android.content.Context;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.App.Authentication.Repository.Repositories.AuthenticationRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class AuthenticationModel {
    AccountEntity currentUser;

    public AuthenticationModel(AccountEntity currentUser) {
        this.currentUser = currentUser;
    }

    public static void authorize(String email, String password, Context ctx, final ModelListener<AuthenticationModel> listener){
        AccountEntity authorizationData = new AccountEntity();
        authorizationData.setEmail(email);
        authorizationData.setEncryptedPassword(password);
        RepositoryListener repoListener = new RepositoryListener<AccountEntity>() {
            @Override
            public void onQueryCompleted(AccountEntity entity) {
                AuthenticationModel auth = new AuthenticationModel(entity);
                listener.onSuccess(auth);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        AuthenticationRepository.authenticate(authorizationData, ctx, repoListener);


    };
}
