package com.example.iialtanskii.iialtanskii_2_parcial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MapStyleOptions;

public class Tab2Map extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.tab2map, container, false);

        mMapView = (MapView) mView.findViewById(R.id.mapView);
        mMapView.getMapAsync(this);

        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //mMapView = (MapView) mView.findViewById(R.id.map);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        boolean success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        getContext(), R.raw.style_json));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng FFcrep = new LatLng(-33.862,151.208);
        LatLng YAR = new LatLng(-33.862462,151.209647);
        LatLng MUS = new LatLng(-33.8625525,151.208926);
        LatLng JPM = new LatLng(-33.8623102,151.2077072);
        LatLng SHM = new LatLng(-33.8627258,151.2092999);
        LatLng IC = new LatLng(-33.862943,151.2123093);
        Marker Rest1 = googleMap.addMarker(new MarkerOptions().position(FFcrep)
                .title("Four Frogs Creperie")
                .snippet("1 Macquarie Pl, Sydney NSW 2000, Australia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        Marker Rest2 = googleMap.addMarker(new MarkerOptions().position(YAR)
                .title("Young Alfred Restaurant")
                .snippet("Customs House, 31 Alfred St, Sydney NSW 2000, Australia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        Marker Museum1 = googleMap.addMarker(new MarkerOptions().position(MUS)
                .title("Museum of Sydney")
                .snippet("Phillip St & Bridge Street, Sydney NSW 2000, Australia"));
        Marker Museum2 = googleMap.addMarker(new MarkerOptions().position(JPM)
                .title("Justice and Police Museum")
                .snippet("Albert St & Phillip St, Sydney NSW 2000, Australia"));
        Marker Hotel1 = googleMap.addMarker(new MarkerOptions().position(SHM)
                .title("Sydney Harbour Marriot Hotel")
                .snippet("30 Pitt St, Sydney NSW 2000, Australia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Marker Hotel2 = googleMap.addMarker(new MarkerOptions().position(IC)
                .title("InterContinental")
                .snippet("117 Macquarie St, Sydney NSW 2000, Australia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        CameraPosition Sidney = CameraPosition.builder().target(new LatLng(-33.862,151.208)).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Sidney));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public boolean onMarkerClick(final Marker marker) {
        Toast.makeText(getContext(), "set theme", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }
}
