package com.example.heni.MyApp.utilities;

import android.content.Intent;
import android.widget.Toast;

import com.example.heni.MyApp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

/**
 * Created by heni on 21/8/17.
 */

public abstract class YouTubeFailureRecoveryActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(getString(R.string.error_player), youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(getString(R.string.app_name), this);
        }
    }

    protected abstract YouTubePlayer.Provider getYouTubePlayerProvider();

}
