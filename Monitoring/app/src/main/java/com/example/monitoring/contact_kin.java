package com.example.monitoring;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class contact_kin extends AppCompatActivity {
   DatabaseReference myRef;
   doctor phNumber;
   String ph,number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kin_layout);

        Button callButton = (Button) findViewById(R.id.button_callKin);
        Button smsButton = (Button) findViewById(R.id.button_sendTextKin);
        EditText editText = (EditText) findViewById(R.id.id_editTextKin);
        myRef = FirebaseDatabase.getInstance().getReference().child("Contact");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ph = dataSnapshot.child("ph").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    public void makePhoneCall() {

        String number = "tel:" + "343434";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(number));
        startActivity(intent);
    }
}
