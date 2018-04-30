package com.example.a24pbu.mp7;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


public class HttpBasicAuth {

    public static void main(String[] args) {

        try {
            URL url = new URL ("https://api.mysportsfeeds.com/v1.2/pull/nba/2018-playoff/cumulative_player_stats.json?playerstats=2PA,2PM,3PA,3PM,FTA,FTM");
            String info = "jasonN:ziplocz1";
            byte[] user = info.getBytes();
            Base64.Encoder username = Base64.getEncoder();
            String encoding = username.encodeToString (user);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}