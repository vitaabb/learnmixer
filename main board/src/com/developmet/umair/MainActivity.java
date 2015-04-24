package com.developmet.umair;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class MainActivity extends Activity implements OnTouchListener,OnDragListener{
	int state=0;
	ArrayList drawables;
	 	
	    private BaseAdapter adapter;
	    private int draggedIndex = -1;
	private static final String LOGCAT = null;
	String msg;
	//ImageView img;
	
	Button pdfbtn;
	Button videobtn;
	Button textbtn;
	Button imgbtn;
	private LayoutParams layoutParams;
	@SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.actionbar)));
        textbtn		=(Button) findViewById(R.id.textdocbtn);
        pdfbtn		=(Button)	findViewById(R.id.pdfdocbtn);
        videobtn	=(Button) findViewById(R.id.videodocbtn);
        imgbtn		=(Button) findViewById(R.id.videodocbtn);
        Button videodocbutton=(Button)findViewById(R.id.videodocbutton);
        videodocbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getBaseContext(),VideoDovViewerActivity.class));

			}
		});
        textbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getBaseContext(),MainViewerActivity.class));
				
			}
		}) ;
        final Button youttubebtn=(Button)findViewById(R.id.youtubebtn);
        youttubebtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String videoUrl = "https://drive.google.com/drive/my-drive";

				//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)));
				
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:VIDEO_ID"));
				startActivity(i);
			}
		});
        
        final Button chromebtn=(Button)findViewById(R.id.chromebtn);
        chromebtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String urlString="http://mysuperwebsite";
				Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setPackage("com.android.chrome");
				try {
				    startActivity(intent);
				} catch (ActivityNotFoundException ex) {
				    // Chrome browser presumably not installed so allow user to choose instead
				    intent.setPackage(null);
				    startActivity(intent);
				}

				
			}
		});
        final Button gdrivebtn=(Button)findViewById(R.id.gdrivebtn);
        gdrivebtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Url = "https://drive.google.com/drive/my-drive";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));	
			}
		});
        final Button slideshowbtn=(Button)findViewById(R.id.slideshowbtn);
        
        	slideshowbtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String Url = "https://docs.google.com/presentation/u/0/";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
				}
			});
        youttubebtn.setVisibility(View.INVISIBLE);
		chromebtn.setVisibility(View.INVISIBLE);
		gdrivebtn.setVisibility(View.INVISIBLE);
		slideshowbtn.setVisibility(View.INVISIBLE);



        drawables = new ArrayList();
        drawables.add(R.drawable.text);
        drawables.add(R.drawable.video);
        drawables.add(R.drawable.image);
        drawables.add(R.drawable.pdf);
        drawables.add(R.drawable.folder);
        
        findViewById(R.id.pdfdocbtn).setOnTouchListener(this);
		findViewById(R.id.videodocbtn).setOnTouchListener(this);
		//findViewById(R.id.textdocbtn).setOnTouchListener(this);
		findViewById(R.id.imagedocbtn).setOnTouchListener(this);
		findViewById(R.id.mainbodylayout).setOnDragListener(this);
		findViewById(R.id.bottomlayout).setOnDragListener(this);
		
		
		Button morebutton =(Button)findViewById(R.id.morebtn);
		morebutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(state==0)
				{
					state=1;
					youttubebtn.setVisibility(View.VISIBLE);
					chromebtn.setVisibility(View.VISIBLE);
					gdrivebtn.setVisibility(View.VISIBLE);
					slideshowbtn.setVisibility(View.VISIBLE);
				}
				else 
				{
					state=0;
					youttubebtn.setVisibility(View.INVISIBLE);
					chromebtn.setVisibility(View.INVISIBLE);
					gdrivebtn.setVisibility(View.INVISIBLE);
					slideshowbtn.setVisibility(View.INVISIBLE);
				}
				
			}
		});
       
    }
	public boolean onTouch(View view, MotionEvent motionEvent) { 
	    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
	      DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
		  view.startDrag(null, shadowBuilder, view, 0);
		  view.setVisibility(View.INVISIBLE);
		  return false;
	    }
	    else {
	    	return true;
	    }
}  
	  public boolean onDrag(View layoutview, DragEvent dragevent) {
	      int action = dragevent.getAction();
	      switch (action) {
	      case DragEvent.ACTION_DRAG_STARTED:
	          Log.d(LOGCAT, "Drag event started");
	    	break;
	      case DragEvent.ACTION_DRAG_ENTERED:
	    	  Log.d(LOGCAT, "Drag event entered into "+layoutview.toString());
	    	break;
	      case DragEvent.ACTION_DRAG_EXITED:
	    	  Log.d(LOGCAT, "Drag event exited from "+layoutview.toString());
	    	break;
	      case DragEvent.ACTION_DROP:
	    	Log.d(LOGCAT, "Dropped");
	    	View view = (View) dragevent.getLocalState();
	        ViewGroup owner = (ViewGroup) view.getParent();
	        owner.removeView(view);
	        RelativeLayout container = (RelativeLayout) layoutview;
	        container.addView(view);
	        view.setVisibility(View.VISIBLE);
	        break;
	      case DragEvent.ACTION_DRAG_ENDED:
	    		  Log.d(LOGCAT, "Drag ended");
		      break;
	      default:
	        break;
	      }
	      return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
