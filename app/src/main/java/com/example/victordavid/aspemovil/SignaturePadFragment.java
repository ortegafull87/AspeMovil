package com.example.victordavid.aspemovil;

import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class SignaturePadFragment extends Fragment {
    private static final String NOMBRE_FRAGMENT = "Firma";
    View v;
    public SignaturePadFragment() {
        // Required empty public constructor
    }

    private ActionBar getActionBar() {
        return ((Home) getActivity()).getSupportActionBar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActionBar().setTitle(NOMBRE_FRAGMENT);
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_signature_pad, container, false);
                /*Listener Para Fecha Inicio*/
        Button saveSignature = (Button)v.findViewById(R.id.DoneButton);
        saveSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    GestureOverlayView gestureView = (GestureOverlayView) v.findViewById(R.id.signaturePad);
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
                    Toast.makeText(getContext(),"Firma capturada", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.v("Gestures", e.getMessage());
                    e.printStackTrace();

                }
            }

        });

        return v;
    }

}
