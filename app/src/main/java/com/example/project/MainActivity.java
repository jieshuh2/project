package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.lang.Object;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    private Restaurant evo, pvp, mcDonald, chicken, sakanaya, teamoji, crepes, burger, latea, panda, subway, buffet;
    private CheckBox starving, hamburger, diet, chinese, japanese, korean, spicy, quick;
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
        latea = new Restaurant("Latea bubble tea lounge", 40.111020, -88.230890);
        burger = new Restaurant("Howdy Burger",36.146851, -95.958649);
        crepes = new Restaurant("Paris super crepes", 40.111017, -88.230604);
        panda = new Restaurant("Panda Express", 40.110490, -88.229151);
        subway = new Restaurant("Subway", 40.110448, -88.229524);
        buffet = new Restaurant("Sunny China Buffet", 40.097623, -88.191235);
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
        boolean[] result = new boolean[8];
        String[] check = {
                "Starving", "Hamburger", "Chinese", "Japanese", "Korean", "Avoid Spicy", "Snack", "Quick to Prepare"
        };
        builder.setView(view)
                .setMultiChoiceItems(check, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    result[which] = true;
                                } else {
                                    // Else, if the item is already in the array, remove it
                                    result[which] = false;
                                }
                            }
                        })
                .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        if (result[0]) {
                            evo.increase();
                            chicken.increase();
                            buffet.increase();
                            sakanaya.decrease();
                        }
                        if (result[1]) {
                            mcDonald.increase();
                            burger.increase();
                            burger.increase();
                        }
                        if (result[2]) {
                            panda.increase();
                            buffet.increase();
                            evo.increase();
                            evo.increase();
                            evo.increase();
                        }
                        if (result[3]) {
                            sakanaya.increase();
                            sakanaya.increase();
                            sakanaya.increase();
                        }
                        if (result[4]) {
                            chicken.increase();
                            chicken.increase();
                            chicken.increase();
                        }
                        if (result[5]) {
                            evo.clear();
                            chicken.decrease();
                            chicken.decrease();

                        }
                        if (result[6]) {
                            latea.increase();
                            teamoji.increase();
                            teamoji.increase();
                            crepes.increase();
                            crepes.increase();
                            crepes.increase();

                        }
                        if (result[7]) {
                            subway.increase();
                            subway.increase();
                            mcDonald.increase();
                            mcDonald.increase();
                            panda.increase();
                            panda.increase();
                        }
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
        Restaurant[] restaurants = {
                evo,  pvp, mcDonald, chicken, sakanaya, teamoji, latea, burger, burger, crepes, panda, subway, buffet
        };
        Restaurant choice = evo;
        for (int i = 0; i < restaurants.length; i++) {
            if (choice.getScore() < restaurants[i].getScore()) {
                choice = restaurants[i];
            }
            if (choice.getScore() == restaurants[i].getScore()) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    choice = restaurants[i];
                }
            }
        }
        return choice;
    }
}

