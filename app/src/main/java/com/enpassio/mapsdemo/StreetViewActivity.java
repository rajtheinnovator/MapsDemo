package com.enpassio.mapsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);


    }

    @Override
    public void onStreetViewPanoramaReady(final StreetViewPanorama panorama) {
        panorama.setPosition(new LatLng(36.0579667, -112.1430996));
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        panorama.animateTo(camera, 10000);
    }
}
