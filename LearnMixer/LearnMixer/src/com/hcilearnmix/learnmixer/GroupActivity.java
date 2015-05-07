package com.hcilearnmix.learnmixer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class GroupActivity extends Activity {
	int state=0;

	private BaseAdapter adapter;
	private int draggedIndex = -1;
	private static final String LOGCAT = null;
	String msg;
	private int dragstart;
	RelativeLayout drophere;
	static int total , failure = 0;
	public static int istch = 0;
	public static int istch2 = 0;
	ImageView addmore,img_friend1,img_friend2,img_friend3,img_friend4,img_friend5,
	img_friend_b1,img_friend_b2,img_friend_b3,img_friend_b4,img_friend_b5,
	img_folder1,img_folder2,img_folder3,img_folder4,img_folder5,img_folder_6,
	img_folder_b1,img_folder_b2,img_folder_b3,img_folder_b4,img_folder_b5,img_folder_b6;
	private LayoutParams layoutParams;
	@SuppressLint("NewApi")

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.groupactivity);
		getActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.actionbar)));
		loadUI();
		dragAndDrop();
		//		img_folder1.setOnClickListener(new OnClickListener() {
		//			
		//			@Override
		//			public void onClick(View v) {
		//				Intent in = new Intent(getApplicationContext(), FriendActivity.class);
		//				startActivity(in);
		//				finish();
		//				
		//			}
		//		});

		//        videodocbutton.setOnClickListener(new View.OnClickListener() {
		//			
		//			@Override
		//			public void onClick(View v) {
		//				// TODO Auto-generated method stub
		//				startActivity(new Intent(getBaseContext(),VideoActivity.class));
		//
		//			}
		//		});
		//        textbtn.setOnClickListener(new View.OnClickListener() {
		//			
		//			@Override
		//			public void onClick(View v) {
		//				// TODO Auto-generated method stub
		//				startActivity(new Intent(getBaseContext(),MainViewerActivity.class));
		//				
		//			}
		//		}) ;
		addmore.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),FriendActivity.class);
				startActivity(in);
			}
		});
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

	private void loadUI() {
		drophere = (RelativeLayout)findViewById(R.id.bottomlayout);
		addmore = (ImageView)findViewById(R.id.addMore);
		img_friend1 = (ImageView)findViewById(R.id.img_friend1);
		img_friend2 = (ImageView)findViewById(R.id.img_friend2);
		img_friend3 = (ImageView)findViewById(R.id.img_friend3);
		img_friend4 = (ImageView)findViewById(R.id.img_friend4);
		img_friend5 = (ImageView)findViewById(R.id.img_friend5);
		img_friend_b1 = (ImageView)findViewById(R.id.img_friend_b1);
		img_friend_b2 = (ImageView)findViewById(R.id.img_friend_b2);
		img_friend_b3 = (ImageView)findViewById(R.id.img_friend_b3);
		img_friend_b4 = (ImageView)findViewById(R.id.img_friend_b4);
		img_friend_b5 = (ImageView)findViewById(R.id.img_friend_b5);
		img_folder1 = (ImageView)findViewById(R.id.img_folder1);
		img_folder2 = (ImageView)findViewById(R.id.img_folder2);
		img_folder3 = (ImageView)findViewById(R.id.img_folder3);
		img_folder4 = (ImageView)findViewById(R.id.img_folder4);
		img_folder5 = (ImageView)findViewById(R.id.img_folder5);
		img_folder_6 = (ImageView)findViewById(R.id.img_folder6);
		img_folder_b1 = (ImageView)findViewById(R.id.img_folder_b1);
		img_folder_b2 = (ImageView)findViewById(R.id.img_folder_b2);
		img_folder_b3 = (ImageView)findViewById(R.id.img_folder_b3);
		img_folder_b4 = (ImageView)findViewById(R.id.img_folder_b4);
		img_folder_b5 = (ImageView)findViewById(R.id.img_folder_b5);
		img_folder_b6 = (ImageView)findViewById(R.id.img_folder_b6);
	}

	public void dragAndDrop()
	{

		drophere.setOnDragListener(new View.OnDragListener() {


			@Override
			public boolean onDrag(View v, DragEvent event) {
				// TODO Auto-generated method stub
				final int action = event.getAction();
				switch(action) {
				case DragEvent.ACTION_DRAG_STARTED:
					dragstart =1;
					break;
				case DragEvent.ACTION_DRAG_EXITED:
					break;
				case DragEvent.ACTION_DRAG_ENTERED:
					break;
				case DragEvent.ACTION_DROP:{
					failure =1;
					//					failure = failure+1;
					return(true);
				}
				case DragEvent.ACTION_DRAG_ENDED:
				{
					Log.e("", "faliur"+failure);
					if(istch==1&&failure==1)
					{
						img_friend1.setVisibility(View.GONE);
						img_friend_b1.setVisibility(View.VISIBLE);
						failure = 0;
						istch =0;
					}
					else if(istch==1&&failure!=1)
					{
						failure = 0;
						Intent in = new Intent(getApplicationContext(), FriendActivity.class);
						startActivity(in);
						finish();
					} 
					else if (istch==2&&failure==1)
					{
						failure = 0;
						img_friend2.setVisibility(View.GONE);
						img_friend_b2.setVisibility(View.VISIBLE);
						istch =0;
					}
					else if(istch==2&&failure!=1)
					{
						failure = 0;
						Intent in = new Intent(getApplicationContext(), FriendActivity.class);
						startActivity(in);
						finish();

					}
					else if (istch==3&&failure==1)
					{
						failure = 0;
						img_friend3.setVisibility(View.GONE);
						img_friend_b3.setVisibility(View.VISIBLE);
						istch =0;
					}
					else if(istch==3&&failure!=1)
					{failure = 0;
					Intent in = new Intent(getApplicationContext(), FriendActivity.class);
					startActivity(in);
					finish();

					}  
					else if (istch==4&&failure==1)
					{failure = 0;
					img_friend4.setVisibility(View.GONE);
					img_friend_b4.setVisibility(View.VISIBLE);
					istch =0;
					}
					else if(istch==4&&failure!=1)
					{failure = 0;
					Intent in = new Intent(getApplicationContext(), FriendActivity.class);
					startActivity(in);
					finish();

					} else  if (istch==5&&failure==1)
					{failure = 0;
					img_friend5.setVisibility(View.GONE);
					img_friend_b5.setVisibility(View.VISIBLE);
					istch =0;
					}

					else if (istch==6&&failure==1)
					{failure = 0;
					img_friend1.setVisibility(View.VISIBLE);
					img_friend_b1.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==7&&failure==1)
					{failure = 0;
					img_friend2.setVisibility(View.VISIBLE);
					img_friend_b2.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==8&&failure==1)
					{failure = 0;
					img_friend3.setVisibility(View.VISIBLE);
					img_friend_b3.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==9&&failure==1)
					{failure = 0;
					img_friend4.setVisibility(View.VISIBLE);
					img_friend_b4.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==10&&failure==1)
					{failure = 0;
					img_friend5.setVisibility(View.VISIBLE);
					img_friend_b5.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==11&&failure==1)
					{failure = 0;
					img_folder1.setVisibility(View.GONE);
					img_folder_b1.setVisibility(View.VISIBLE);
					istch =0;
					}
					else if(istch==11&&failure!=1)
					{failure = 0;
					Intent in = new Intent(getApplicationContext(), MainViewerActivity.class);
					startActivity(in);
					finish();

					} 
					else if (istch==12&&failure==1)
					{failure = 0;
					img_folder2.setVisibility(View.GONE);
					img_folder_b2.setVisibility(View.VISIBLE);
					istch =0;
					}
					else if(istch==12&&failure!=1)
					{failure = 0;
					Intent in = new Intent(getApplicationContext(), MainViewerActivity.class);
					startActivity(in);
					finish();

					}  else if (istch==13&&failure==1)
					{failure = 0;
					img_folder3.setVisibility(View.GONE);
					img_folder_b3.setVisibility(View.VISIBLE);
					istch =0;
					}
					else if(istch==13&&failure!=1)
					{failure = 0;
					Intent in = new Intent(getApplicationContext(), MainViewerActivity.class);
					startActivity(in);
					finish();

					} 
					else if (istch==14&&failure==1)
					{failure = 0;
					img_folder1.setVisibility(View.VISIBLE);
					img_folder_b1.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==15&&failure==1)
					{failure = 0;
					img_folder2.setVisibility(View.VISIBLE);
					img_folder_b2.setVisibility(View.GONE);
					istch =0;
					}
					else if (istch==16&&failure==1)
					{failure = 0;
					img_folder3.setVisibility(View.VISIBLE);
					img_folder_b3.setVisibility(View.GONE);
					istch =0;
					}
					//					sucess.setText("Sucessful Drops :"+suc);
					//					text.setText("Total Drops: "+total);
					return(true);
				}
				default:
					break;
				}
				return true;
			}});
		img_friend1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=1;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend1);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=2;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend2);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend3.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=3;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend3);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});


		img_friend4.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=4;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend4);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend5.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=5;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend5);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});

		img_friend_b1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=6;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend_b1);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend_b2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=7;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend_b2);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend_b3.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=8;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend_b3);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend_b4.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=9;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend_b4);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_friend_b5.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=10;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_friend_b5);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_folder1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=11;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_folder1);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_folder2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=12;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_folder2);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_folder3.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=13;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_folder3);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_folder_b1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=14;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_folder_b1);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});

		img_folder_b2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=15;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_folder_b2);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img_folder_b3.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=16;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img_folder_b3);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});

	}



}
