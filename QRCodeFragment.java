package com.example.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.journeyapps.barcodescanner.CaptureActivity;

import java.util.Objects;


public class QRCodeFragment extends Fragment {

    EditText qrvalue;
    ImageView qrview;
    Button qrbutton;
    TextView text;
    String c=null;
    boolean tr;
    Context cc;
    public QRCodeFragment(String a) {
        // Required empty public constructor
        c=a;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        cc=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q_r_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text=view.findViewById(R.id.text1);
        qrvalue=view.findViewById(R.id.qrname);
        qrview=view.findViewById(R.id.qrimage);
        qrbutton=view.findViewById(R.id.qrbutton);
        qrvalue.setText((CharSequence) c);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        qrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    setQR();
                    //text.setText("Ya");
            }
        });
    }

    private void setQR() {
        String data=qrvalue.getText().toString().trim();
        MultiFormatWriter writer=new MultiFormatWriter();
        BarcodeEncoder encoder=new BarcodeEncoder();
        BitMatrix bitMatrix=null;
        //if(qrvalue.getText().toString().trim()!=null){
            try {
                    bitMatrix=writer.encode(data, BarcodeFormat.QR_CODE,200,200);

                    Bitmap bitmap=encoder.createBitmap(bitMatrix);
                    qrview.setImageBitmap(bitmap);
                    qrvalue.setText(null);
        } catch (Exception e) {
                e.printStackTrace();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("注意")
                        .setMessage("不可空！！")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                //getActivity().finish();
            }
        text.setText("Ya");
       // }else {
            //AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            //alertDialog.setTitle("注意")
                    //.setMessage("不可空！！")
                   // .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                      //  @Override
                      //  public void onClick(DialogInterface dialogInterface, int i) {
                      //      dialogInterface.dismiss();
                      //  }
                   // }).show();
       // }
    }
    
}