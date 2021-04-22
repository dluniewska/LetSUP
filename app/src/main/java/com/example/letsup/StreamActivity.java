package com.example.letsup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.VideoView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamActivity extends AppCompatActivity {

    WebView myWebView;
   // String v_url="<iframe src=\"https://imageserver.webcamera.pl/umiesc/gdansk\" width=\"800\" height=\"450\" " + "border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
    String v_url = LiveStreamActivity.sharedValue;
    ProgressDialog pd;
    //<iframe src="https://imageserver.webcamera.pl/umiesc/gdansk" width="800" height="450" border="0" frameborder="0" scrolling="no"></iframe>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streams);
        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setDomStorageEnabled(true);

        if(v_url.contains("iframe")){
            Matcher matcher = Pattern.compile("src=\"([^\"]+)\"").matcher(v_url);
            matcher.find();
            String src = matcher.group(1);
            v_url=src;

            try {
                URL myURL = new URL(src);
                myWebView.loadUrl(src);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else {

            myWebView.loadDataWithBaseURL(null, "<style>img{display: inline;height: auto;max-width: 100%;}</style>"
                    + myWebView, "text/html", "UTF-8", null);}

    }
}
