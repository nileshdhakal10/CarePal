package com.example.vitatsignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MaintainTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_tips);

        String blPressureMsg = "BLOOD PRESSURE:\n\treduce" ;
        String blSugarMsg = "BLOOD SUGAR:\n\treduce";
        String ChoHDLMsg = "CHOLESTEROL HDL:\n\treduce";
        String ChoLDLMsg = "CHOLESTEROL LDL:\n\treduce";
        String TriMsg = "TRIGLYCERIDES:\n\treduce";

        TextView blPressureTv = findViewById(R.id.blPressMt);
        blPressureTv.setText(blPressureMsg);

        TextView blSugarTv = findViewById(R.id.blSugarMt);
        blSugarTv.setText(blSugarMsg);

        TextView ChoHDLTv = findViewById(R.id.ChoHDLMt);
        ChoHDLTv.setText(ChoHDLMsg);

        TextView ChoLDLTv = findViewById(R.id.ChoLDLMt);
        ChoLDLTv.setText(ChoLDLMsg);

        TextView TriTv = findViewById(R.id.TriMt);
        TriTv.setText(TriMsg);
    }
}