package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {
    public int McDonald;
    public int EVO;
    public int PVP;
    public int FatSandwich;
    public int LaiLai;
    public int Teamoji;
    public int Sakanaya;
    public RadioGroup checkbox;
    public View map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = findViewById(R.id.mapView2);
        map.setVisibility(View.GONE);
        checkbox = findViewById(R.id.Radiogroup);
    }
}
