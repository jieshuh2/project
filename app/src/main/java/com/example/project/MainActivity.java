package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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
    public Button start;
    public View map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = findViewById(R.id.mapView2);
        map.setVisibility(View.GONE);
        RadioButton starving = findViewById(R.id.radioButton6);
        starving.setOnCheckedChangeListener();
        RadioButton diet = findViewById(R.id.radioButton9);
        diet.setOnCheckedChangeListener();
        RadioButton spicy = findViewById(R.id.radioButton7);
        spicy.setOnCheckedChangeListener();
        RadioButton quick = findViewById(R.id.radioButton8);
        quick.setOnCheckedChangeListener();
        RadioButton vegetarian = findViewById(R.id.radioButton10);
        vegetarian.setOnCheckedChangeListener();
        RadioButton asian = findViewById(R.id.radioButton11);
        asian.setOnCheckedChangeListener();
        RadioButton american = findViewById(R.id.radioButton12);
        american.setOnCheckedChangeListener();
        RadioButton europe = findViewById(R.id.radioButton13);
        europe.setOnCheckedChangeListener();
        checkbox = findViewById(R.id.Radiogroup);
        start = findViewById (R.id.button2);
        start.setOnClickListener();
    }
}
