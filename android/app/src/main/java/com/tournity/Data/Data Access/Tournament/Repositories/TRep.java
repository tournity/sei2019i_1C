import Tournament.Entities;

        package Tournament.Repositories;

public class TRep{
    public void Insert(Context context, TournamentEnt TE) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
            nameValuePairs.add(new BasicNameValuePair("id", TE.getId()));
            nameValuePairs.add(new BasicNameValuePair("Owner", TE.getOwner()));
            nameValuePairs.add(new BasicNameValuePair("Group", TE.getGroup()));
            nameValuePairs.add(new BasicNameValuePair("Name", TE.getName()));
            nameValuePairs.add(new BasicNameValuePair("Init_date", TE.getInit_date()));
            nameValuePairs.add(new BasicNameValuePair("Finish_date", TE.getFinish_date()));
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