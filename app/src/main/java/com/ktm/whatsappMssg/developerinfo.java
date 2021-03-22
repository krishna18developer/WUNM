package com.ktm.whatsappMssg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class developerinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developerinfo);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        TextView contactbtn = (TextView) findViewById(R.id.contact_id);
        contactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "contact.ktm1812@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding The WUNM APP");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, ""));
            }
        });

    }
}