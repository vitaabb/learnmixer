package com.kvitochka.myviewer;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;




public class pdf_activity extends ActionBarActivity {


    private ImageView img;
    private int currentPage =0;
    private Button next, previous;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_activity);


        next =(Button)findViewById(R.id.next);
        previous =(Button)findViewById(R.id.previous);



        next.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                currentPage++;
                render();
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                currentPage--;
                render();
            }
        });


        render();

    }


    private void render(){

        try{

            img =(ImageView)findViewById(R.id.img);
            int REQ_WIDTH = img.getWidth();
            int REQ_HEIGHT = img.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(REQ_WIDTH,REQ_HEIGHT, Bitmap.Config.ARGB_4444);
            File file = new File("/res/drawable/demo.pdf");
            PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));

            if(currentPage < 0){
                currentPage =0;
                }else if(currentPage> renderer.getPageCount()){

                currentPage=renderer.getPageCount()-1;

            }


            Matrix m= img.getImageMatrix();
            Rect rect = new Rect(0,0,REQ_WIDTH,REQ_HEIGHT);
            renderer.openPage(currentPage).render(bitmap,rect,m, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

            img.setImageBitmap(bitmap);
            img.setImageMatrix(m);
            img.invalidate();

        }catch (Exception e){
            e.printStackTrace();

        }


    }





}
