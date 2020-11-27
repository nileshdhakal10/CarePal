package com.example.monitoring;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements message.messageListener, warning.warningListener {
    DatabaseReference myRef;
    doctor phNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText saveNum = (EditText) findViewById(R.id.id_data);
        Button save_button = (Button) findViewById(R.id.button_save);
        Button yes_button = (Button) findViewById(R.id.yes_button);
        Button no_button = (Button) findViewById(R.id.no_button);
        Button contact_button = (Button) findViewById(R.id.contact_button);
        myRef = FirebaseDatabase.getInstance().getReference().child("Doctor");
        phNumber = new doctor();

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessage();
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWarning();
            }
        });

        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long ph = Long.parseLong(saveNum.getText().toString().trim());

                phNumber.setPh(ph);
                myRef.push().setValue(phNumber);
                Toast.makeText(getApplicationContext(),"Phone number saved",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openMessage(){
        DialogFragment inform = new message();
        inform.show(getSupportFragmentManager(), "");
    }

    public void openWarning()
    {
        warning warn = new warning();
        warn.show(getSupportFragmentManager(),"warn");
    }

    @Override
    public void onOkClicked() {
        openYes();
    }
    public void clicked() { openYes(); }

    public void openYes(){
        Intent intent = new Intent(MainActivity.this, take.class);
        startActivity(intent);
    }

    public void openContact() {
        Intent intent = new Intent(MainActivity.this, contact_info.class);
        startActivity(intent);
    }

}



