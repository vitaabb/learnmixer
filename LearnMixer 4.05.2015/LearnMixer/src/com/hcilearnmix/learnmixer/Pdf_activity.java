package com.hcilearnmix.learnmixer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Pdf_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_activity);

    }

    public void gotoMyCollection(View view){

        startActivity(new Intent(Pdf_activity.this, MyCollection.class));

    }
}