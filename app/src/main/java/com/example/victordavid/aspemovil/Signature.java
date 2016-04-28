package com.example.victordavid.aspemovil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.gesture.GestureOverlayView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
public class Signature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
    }

    public void saveSig(View view) {

        try {
            GestureOverlayView gestureView = (GestureOverlayView) findViewById(R.id.signaturePad);
            gestureView.setDrawingCacheEnabled(true);
            Bitmap bm = Bitmap.createBitmap(gestureView.getDrawingCache());
            File f = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "signature.png");
            f.createNewFile();
            FileOutputStream os = new FileOutputStream(f);
            os = new FileOutputStream(f);
            //compress to specified format (PNG), quality - which is ignored for PNG, and out stream
            bm.compress(Bitmap.CompressFormat.PNG, 100, os);
            os.flush();
            os.close();
            Toast.makeText(getApplicationContext(),"Firma capturada", Toast.LENGTH_SHORT).show();
            this.finish();
            onBackPressed();
        } catch (Exception e) {
            Log.v("Gestures", e.getMessage());
            e.printStackTrace();

        }

    }
}
