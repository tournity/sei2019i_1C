package com.tournity.Bloc.Services;

import android.content.Context;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.App.Authentication.Repository.Repositories.AuthenticationRepository;
import com.tournity.Bloc.Listeners.SessionListener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

public class SessionService {
    private static String ACCESS_TOKEN = "tokenzito";
    private static AccountEntity  CURRENT_USER;
    private static SessionListener SESSION_LISTENER;
    public static String SESSION_PREFERENCES;

    public static String getAccessToken(){
     return ACCESS_TOKEN;
    }

    public static void setOnChangeSesionState (SessionListener listener){
        SESSION_LISTENER = listener;
    }

    public static void setTokenAndAuthorize (Context ctx, String token){
        ACCESS_TOKEN = token;
        RepositoryListener listener = new RepositoryListener<AccountEntity>() {
            @Override
            public void onQueryCompleted(AccountEntity entity) {
                setSession(entity.getToken(), entity);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                removeSession();
            }
        };
        AuthenticationRepository.authenticateWithToken(ctx, listener);
    }

    public static void setSession (String token, AccountEntity currentUser){
        ACCESS_TOKEN = token;
        CURRENT_USER = currentUser;
        if(SESSION_LISTENER != null){
            SESSION_LISTENER.onSessionChanged(true);
        }
    }

    public static void removeSession (){
        ACCESS_TOKEN = null;
        CURRENT_USER = null;
        if(SESSION_LISTENER != null){
            SESSION_LISTENER.onSessionChanged(false);
        }
    }

}
