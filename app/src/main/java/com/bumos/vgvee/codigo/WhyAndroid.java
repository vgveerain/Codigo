package com.bumos.vgvee.codigo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;

public class WhyAndroid extends AppCompatActivity {


    private SimpleExoPlayer player;
    private Uri videoUri;
    String string;
    private long playbackPosition=0;
    private int currentWindow=0;
//  private ProgressBar progressBar;
    private PlayerView playerView;

    private String GRID_YOUTUBE_ID = "aJOTlE1K90k";
    private String BASE_URL = "https://www.youtube.com";
    private String youtubeLink = BASE_URL + "/watch?v=" + GRID_YOUTUBE_ID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why_android);

        playerView = findViewById(R.id.pView);

    }


    public void initializePlayer(){

        player = ExoPlayerFactory.newSimpleInstance(this,new DefaultTrackSelector());

        playerView.setPlayer(player);

        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(this,"video");


        final ExtractorMediaSource mediaSource = new ExtractorMediaSource.Factory(defaultDataSourceFactory)
                .createMediaSource(Uri.parse("http://dl8.heyserver.in/film/2018-6/Incredibles_2_Trailer_1_2018_Movieclips_Trailers.mp4"));


        player.prepare(mediaSource,true,false);
        player.setPlayWhenReady(true);
        player.seekTo(currentWindow,playbackPosition);


    }


    public void releasePlayer()
    {
        if(player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();

            playerView.setPlayer(null);
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUi();
        Log.e("TAG","Resume");
        if (player == null) {
            initializePlayer();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        // Log.e("TAG","Video Paused");
        releasePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Log.e("TAG","STOP");
        releasePlayer();
    }

}
