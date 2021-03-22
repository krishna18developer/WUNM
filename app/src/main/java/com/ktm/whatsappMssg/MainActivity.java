package com.ktm.whatsappMssg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        String pre_url = "https://api.WhatsApp.com/send?phone=";
        final String[] cCode = {"91"};
        ImageView send = (ImageView) findViewById(R.id.send_btn);
        EditText phn_box = (EditText) findViewById(R.id.phone_box);
        TextView dbkt = (TextView) findViewById(R.id.dbkt_img);
        com.hbb20.CountryCodePicker countryCodePicker = findViewById(R.id.ccp);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phn_number = "" + phn_box.getText();
                phn_number = phn_number.replaceAll("[^0-9]", "");
                phn_box.setText(phn_number);
                if (phn_number.length() == 10)
                {
                    cCode[0] = "" + countryCodePicker.getSelectedCountryCode();
                    String url = pre_url + cCode[0] + phn_number;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
                else if(phn_number.length()<10)
                {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(() -> Toast.makeText(MainActivity.this, "The Entered Number is Less than 10 Digits", Toast.LENGTH_SHORT).show(), 2000);
                }
                else if(phn_number.length()>10)
                {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(() -> Toast.makeText(MainActivity.this, "The Entered Number is greater than 10 Digits", Toast.LENGTH_SHORT).show(), 2000);
                }
            }
        });
       dbkt.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               Intent i = new Intent(getApplicationContext(),developerinfo.class);
               startActivity(i);
               return true;
           }
       });
    }
}