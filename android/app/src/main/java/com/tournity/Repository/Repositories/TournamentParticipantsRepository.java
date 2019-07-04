package com.tournity.Repository.Repositories;

import android.content.Context;

import com.tournity.Entities.TournamentParticipantsEntity;

import java.io.IOException;

public class TournamentParticipantsRepository {
    public void Insert(Context context, TournamentParticipantsEntity TE) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
            nameValuePairs.add(new BasicNameValuePair("id", TE.getId()));
            nameValuePairs.add(new BasicNameValuePair("Name", TE.getName()));
            nameValuePairs.add(new BasicNameValuePair("Description", TE.getDescription()));
            nameValuePairs.add(new BasicNameValuePair("icon", TE.getIcon()));
            nameValuePairs.add(new BasicNameValuePair("Player list", TE.getPlayerList()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }
}
