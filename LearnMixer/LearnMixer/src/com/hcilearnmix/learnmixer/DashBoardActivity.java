package com.hcilearnmix.learnmixer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DashBoardActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		ImageView  img2 = (ImageView)findViewById(R.id.img_2);
		ImageView  img1 = (ImageView)findViewById(R.id.img_1);
		
		ImageView  img3 = (ImageView)findViewById(R.id.img_3);
		ImageView  img4 = (ImageView)findViewById(R.id.img_4);
		
		
		ImageView  img5 = (ImageView)findViewById(R.id.img_5);
		ImageView  img6 = (ImageView)findViewById(R.id.img_6);
		
		ImageView  img7 = (ImageView)findViewById(R.id.img_7);
		ImageView  img8 = (ImageView)findViewById(R.id.img_8);
		img1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(in);
			}
		});
		img2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MyCollection.class);
				startActivity(in);
			}
		});
		img3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MainActivity_class.class);
				startActivity(in);
			}
		});
		img4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MyCollection.class);
				startActivity(in);
			}
		});
		img5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(in);
			}
		});
		img6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MyCollection.class);
				startActivity(in);
			}
		});
		img7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(in);
			}
		});
		img8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MyCollection.class);
				startActivity(in);
			}
		});
	}
}
