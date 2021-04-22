package com.example.letsup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class StreamActivity extends AppCompatActivity {

    VideoView videoView;
    String v_url="https://imageserver.webcamera.pl/umiesc/gdansk";
    ProgressDialog pd;
//<iframe src="https://imageserver.webcamera.pl/umiesc/gdansk" width="800" height="450" border="0" frameborder="0" scrolling="no"></iframe>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streams);
        videoView = (VideoView) findViewById(R.id.videoView);
        pd = new ProgressDialog(StreamActivity.this);
        pd.setMessage("Buffering video. Please wait");
        pd.show();
        Uri uri = Uri.parse(v_url);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
            }
        });
    }




}