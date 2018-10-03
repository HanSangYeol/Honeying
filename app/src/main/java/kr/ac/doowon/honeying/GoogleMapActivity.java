package kr.ac.doowon.honeying;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends BaseActivity implements OnMapReadyCallback{

    private android.widget.Spinner areaSpinner;
    private android.widget.ImageView filterBtn;
    private android.widget.LinearLayout mapLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        this.mapLayout = (LinearLayout) findViewById(R.id.mapLayout);



        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng SEOUL = new LatLng(37.815531, 126.801175);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("파주");
        markerOptions.snippet("현재 위치");
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 16));
    }

    @Override
    public void setupEvents() {
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void bindView() {
        this.filterBtn = (ImageView) findViewById(R.id.filterBtn);
        this.areaSpinner = (Spinner) findViewById(R.id.areaSpinner);
    }
}
