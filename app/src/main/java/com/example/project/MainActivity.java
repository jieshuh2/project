package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.annotation.Target;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    private Restaurant evo, pvp, mcDonald, chicken, sakanaya, teamoji;
    private CheckBox starving, vegetarian, diet, chinese, japanese, korean, spicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById (R.id.button2).setOnClickListener(v -> {
                mapAPI.clear();
                Dialog checkbox = onCreateDialog(null);
                checkbox.show();
        });
        evo = new Restaurant("EVO", 40.109509, -88.230744);
        pvp = new Restaurant ("PVP",40.110137, -88.229805);
        mcDonald = new Restaurant("mcDonald", 40.110445, -88.229792);
        chicken = new Restaurant ("bb.q premium chicken", 40.106590, -88.221313);
        sakanaya = new Restaurant("Sakanaya", 40.110103, -88.232850);
        teamoji = new Restaurant ("Teamoji", 40.110103, -88.229657);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_API);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
    }
    public Dialog onCreateDialog(final Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.checkbox, null);
        starving = findViewById(R.id.checkBox9);
        vegetarian = findViewById(R.id.checkBox10);
        chinese = findViewById((R.id.checkBox11));
        japanese = findViewById(R.id.checkBox12);
        korean = findViewById(R.id.checkBox13);
        spicy = findViewById(R.id.checkBox14);
        diet = findViewById(R.id.checkBox15);
        builder.setView(view)
                .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        Restaurant restaurant = choice();
                        mapAPI.addMarker(new MarkerOptions().position(restaurant.getLocation()).title(restaurant.getName()));
                        mapAPI.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant.getLocation(), 18.33F));
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        // User cancelled the dialog
                        dialog.cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    public Restaurant choice() {
        return pvp;
    }
}

