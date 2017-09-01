package com.example.heni.MyApp.activities;

import android.os.Bundle;
import android.view.Menu;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.utilities.YouTubeFailureRecoveryActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

/**
 * Created by heni on 17/8/17.
 */

public class YouTubeVideoPlayer extends YouTubeFailureRecoveryActivity {
    public static String EXTRA_YOUTUBE_VIDEO_ID = "videoID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_video_player);

        YouTubePlayerFragment youTubePlayerFragment =
                (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubePlayerFragment.initialize(getString(R.string.youTubeKey), this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            //player.cueVideo(getIntent().getStringExtra(EXTRA_YOUTUBE_VIDEO_ID));
            //player.setFullscreen(true);
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            //player.setShowFullscreenButton(false);
            player.setFullscreen(true);
            player.loadVideo(getIntent().getStringExtra(EXTRA_YOUTUBE_VIDEO_ID));
        }
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
    }
}
