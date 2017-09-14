package com.enpassio.mapsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

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
        CameraPosition target = CameraPosition.builder().target(bengaluru).zoom(18).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

    }
}
