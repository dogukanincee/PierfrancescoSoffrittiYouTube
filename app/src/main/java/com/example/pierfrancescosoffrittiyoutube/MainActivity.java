package com.example.pierfrancescosoffrittiyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private static YouTubePlayerView pierYouTubePlayerView;
    @SuppressLint("StaticFieldLeak")
    private static RelativeLayout lytYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pierYouTubePlayerView = findViewById(R.id.youtube_player_view);
        lytYoutube = findViewById(R.id.lytYoutube);

        if (lytYoutube.getVisibility() == View.VISIBLE) {
            lytYoutube.setVisibility(View.GONE);
        }

        String url = "7R3OszPvPTU";
        
        pierYouTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(com.pierfrancescosoffritti.androidyoutubeplayer.core.player.@NotNull YouTubePlayer youTubePlayer) {
                lytYoutube.setVisibility(View.VISIBLE);
                pierYouTubePlayerView.setVisibility(View.VISIBLE);
                Log.i("Youtube", String.valueOf(pierYouTubePlayerView));
                youTubePlayer.loadVideo(url, 0);
                Log.i("Youtube", "YoutubeInitializeSuccess");
            }
        });

    }
}