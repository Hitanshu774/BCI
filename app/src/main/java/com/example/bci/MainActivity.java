package com.example.bci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGetContactPressed(View view) {
        getPhoneContacts();

    }

    public void getPhoneContacts(){
        //checking permission given or not
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, 0);
            //if permission not granted then once more requested.


            //Now requesting contact application for sharing data with us
            ContentResolver contentResolver = getContentResolver();
            //Sending uri to read the date
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            //Data received and can be accessed by the cursor
            Cursor cursor = contentResolver.query(uri, null, null, null, null);

            //Checking total number of contacts received
            Log.i("CONTACT_PROVIDER_DEMO", "Total number of contacts : " + Integer.toString(cursor.getCount()));

            //Now check if cursor has some data
            if(cursor.getCount() > 0){
                //if present then cursor will read the data
                while(cursor.moveToNext()){
//                    String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//
//                    Log.i("CONTACT_PROVIDER_DEMO", contactName);
                }
            }

        }
    }
}