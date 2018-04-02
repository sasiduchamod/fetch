package com.example.sasidu.fetch;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SASIDU on 4/2/2018.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {

    String data="";
    @Override

    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("https://api.themoviedb.org/3/genre/movie/list?api_key=26061262b87bbb9018b834fe23feb236&language=en-US");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null)
            {
                line = bufferedReader.readLine();
                data = data+line;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        dataMainActivity.data.setText(this.data);
    }

}
