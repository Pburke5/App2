package com.example.a24pbu.mp7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public class HttpUtils {
        private static final String BASE_URL = "http://api.twitter.com/1/";

        private static AsyncHttpClient client = new AsyncHttpClient();

        public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(url), params, responseHandler);
        }

        public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(getAbsoluteUrl(url), params, responseHandler);
        }

        public static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(url, params, responseHandler);
        }

        public static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(url, params, responseHandler);
        }

        private static String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }
    }
    RequestParams rp = new RequestParams();
    rp.add("username", "aaa"); rp.add("password", "aaa@123");

    HttpUtils.post(AppConstant.URL_FEED, rp, new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            // If the response is JSONObject instead of expected JSONArray
            Log.d("asd", "---------------- this is response : " + response);
            try {
                JSONObject serverResp = new JSONObject(response.toString());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
            // Pull out the first event on the public timeline

        }
    });
    <uses-permission android:name="android.permission.INTERNET" />

}
