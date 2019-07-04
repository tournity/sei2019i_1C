package com.tournity.Repository.Repositories;

import android.content.Context;

import com.tournity.Entities.TeamEntity;
import com.tournity.Entities.TournamentEntity;

import java.io.IOException;

public class TeamRepository {
    public void Insert(Context context, TeamEntity TE) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
            nameValuePairs.add(new BasicNameValuePair("id", TE.getId()));
            nameValuePairs.add(new BasicNameValuePair("Group", TE.getGroup()));
            nameValuePairs.add(new BasicNameValuePair("Name", TE.getName()));
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
