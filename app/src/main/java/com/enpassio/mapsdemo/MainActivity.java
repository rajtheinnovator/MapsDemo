package com.enpassio.mapsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMap = (Button) findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                }
            }
        });

        Button btnSatellite = (Button) findViewById(R.id.btn_satellite);
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                }
            }
        });

        Button btnHybrid = (Button) findViewById(R.id.btn_hybrid);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                }
            }
        });

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;
        LatLng bengaluru = new LatLng(12.923728, 77.611455);
        CameraPosition target = CameraPosition.builder().target(bengaluru).zoom(18).bearing(90).tilt(60).build();


        MarkerOptions spurthy = new MarkerOptions().position(bengaluru).title("Spurthy").visible(true).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        MarkerOptions swaraj = new MarkerOptions().position(new LatLng(12.923519, 77.612030)).title("Swaraj").visible(true).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        MarkerOptions newOption = new MarkerOptions().position(new LatLng(12.921543, 77.611172)).title("new Option");

        m_map.addPolyline(new PolylineOptions().geodesic(true).add(new LatLng(12.923728, 77.611455))
                .add(new LatLng(12.923519, 77.612030))
                .add(new LatLng(12.921543, 77.611172))
                .add(new LatLng(12.923728, 77.611455)));

        m_map.addMarker(newOption);
        m_map.addMarker(spurthy);
        m_map.addMarker(swaraj);
        m_map.addCircle(new CircleOptions().center(bengaluru).radius(15).strokeColor(Color.BLUE).fillColor(Color.LTGRAY));

        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 1000, null);

    }
}
