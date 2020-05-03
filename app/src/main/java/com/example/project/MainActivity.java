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
    private CheckBox starving, vegetarian, diet, chinese, japanese, korean, spicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById (R.id.button2).setOnClickListener(v -> {
                Dialog checkbox = onCreateDialog(null);
                checkbox.show();
        });
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_API);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
    }
    public Dialog onCreateDialog(final Bundle savedInstanceState){
        setContentView(R.layout.checkbox);
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
                        if (starving.isChecked()) {

                        } else {

                        }
                        if (vegetarian.isChecked()) {

                        } else {

                        }
                        if (chinese.isChecked()) {

                        } else {

                        }
                        if (japanese.isChecked()) {

                        } else {

                        }
                        if (korean.isChecked()) {

                        } else {

                        }
                        if (spicy.isChecked()) {

                        } else {

                        }
                        if (diet.isChecked()) {

                        } else {

                        }
                        LatLng restaurant = new LatLng(40.109509, -88.230744);
                        mapAPI.addMarker(new MarkerOptions().position(restaurant).title("Unknown"));
                        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
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
}
