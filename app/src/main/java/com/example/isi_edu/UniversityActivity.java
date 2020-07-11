package com.example.isi_edu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UniversityActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_university, container, false);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)
                getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in isiFass and move the camera
        LatLng isiFass = new LatLng(14.6924775,-17.4545013);
        mMap.addMarker(new MarkerOptions()
                .position(isiFass)
                .title("ISI Fass")
                .snippet("Contact: +221338224178, Site Web: www.groupeisi.com"));

        // Add a marker in isiKeurMassar and move the camera
        LatLng isiKeurMassar = new LatLng(14.7864558,-17.2889386);
        mMap.addMarker(new MarkerOptions()
                .position(isiKeurMassar)
                .title("ISI Keur Massar")
                .snippet("Contact: +221338784349, Site Web: www.groupeisi.com"));

        // Add a marker in isiMere and move the camera
        LatLng isiMere = new LatLng(14.6833507,-17.4581522);
        mMap.addMarker(new MarkerOptions()
                .position(isiMere)
                .title("ISI Mere")
                .snippet("Contact: +221338221981, Site Web: www.groupeisi.com"));

        // Pour ajouter un cercle autour d'un marquer
        CircleOptions co = new CircleOptions()
                .center(isiMere)
                .radius(500)
                .fillColor(Color.GREEN)
                .strokeColor(Color.BLUE)
                .strokeColor(5);

        mMap.addCircle(co);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(isiMere));
    }
}
