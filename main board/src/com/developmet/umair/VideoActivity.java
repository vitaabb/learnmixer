package com.developmet.umair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {


    // Declare variables
    ProgressDialog pDialog;
    VideoView videoview;

    // Insert your Video URL
    String VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.activity_video);
        // Find your VideoView in your video_main.xml layout
        videoview = (VideoView) findViewById(R.id.video);
        // Execute StreamVideo AsyncTask

        // Create a progressbar
        pDialog = new ProgressDialog(VideoActivity.this);

        // Set progressbar title
        pDialog.setTitle("Video Streaming");

        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();

        try {
            // Start the MediaController
            MediaController mediaController = new MediaController(VideoActivity.this);

            mediaController.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediaController);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                pDialog.dismiss();
                videoview.start();
            }
        });


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
