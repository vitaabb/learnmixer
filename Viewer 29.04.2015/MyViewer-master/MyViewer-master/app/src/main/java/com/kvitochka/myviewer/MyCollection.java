package com.kvitochka.myviewer;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;


public class MyCollection extends ActionBarActivity   {

    /**
     * Define the number of items visible when the carousel is first shown.
     */
    private static final float INITIAL_ITEMS_COUNT = 1.2F;

    /**
     * Carousel container layout
     */
    private LinearLayout mCarouselContainer;

    ImageButton share;
    ImageButton back;
    ImageButton share2;
    ImageButton full;

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);






        // Get reference to carousel container
        mCarouselContainer = (LinearLayout) findViewById(R.id.carousel);






        back = (ImageButton)findViewById(R.id.imageButton2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCollection.this, MainActivity.class));
                finish();
            }
        });




        full= (ImageButton)findViewById(R.id.imageButton11);

        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCollection.this, pdf_activity.class));

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_collection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Compute the width of a carousel item based on the screen width and number of initial items.
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int imageWidth = (int) (displayMetrics.widthPixels / INITIAL_ITEMS_COUNT);

        // Get the array of puppy resources
        final TypedArray puppyResourcesTypedArray = getResources().obtainTypedArray(R.array.puppies_array);

        // Populate the carousel with items
        ImageView imageItem;
        for (int i = 0 ; i < puppyResourcesTypedArray.length() ; ++i) {
            // Create new ImageView
            imageItem = new ImageView(this);

            // Set the shadow background
            imageItem.setBackgroundResource(R.drawable.shadow);

            // Set the image view resource
            imageItem.setImageResource(puppyResourcesTypedArray.getResourceId(i, -1));

            // Set the size of the image view to the previously computed value
            imageItem.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, (int)(displayMetrics.heightPixels/INITIAL_ITEMS_COUNT)));

            /// Add image view to the carousel container
            mCarouselContainer.addView(imageItem);
        }
    }


    public void share(View view){

        startActivity(new Intent(MyCollection.this, Share_Activity.class));

    }



    public void change(View view){

        startActivity(new Intent(MyCollection.this, VideoActivity.class));

    }





}
