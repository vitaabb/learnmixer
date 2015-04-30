package com.kvitochka.myviewer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Share_Activity extends ActionBarActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_);










    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share_, menu);
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

    public void share(View view){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("Shared with Kensuke")
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




    public void share2(View view){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("Shared with Group1")
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



    public void share3(View view){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("Shared with Group2")
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
