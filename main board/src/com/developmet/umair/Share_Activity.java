package com.developmet.umair;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Share_Activity extends Activity {



    ImageButton btn3;
    ImageButton btn4;
    ImageButton btn5;
    ImageButton btn6;
    ImageButton btn7;
    ImageButton btn9;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share);



        btn3 = (ImageButton)findViewById(R.id.imageButton3);
        btn4 = (ImageButton)findViewById(R.id.imageButton4);
        btn5 = (ImageButton)findViewById(R.id.imageButton5);
        btn6 = (ImageButton)findViewById(R.id.imageButton6);
        btn7 = (ImageButton)findViewById(R.id.imageButton7);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.share_, menu);
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


    public void share(View view){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("Shared with Ken :)")
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();


                        startActivity(new Intent(Share_Activity.this, MyCollection.class));
                        finish();
                    }
                })
                .setIcon(R.drawable.shared)
                .setTitle("SHARED")

               .create();
        myAlert.show();








    }


    public void back(View view){



        startActivity(new Intent(Share_Activity.this, MyCollection.class));


    }

}
