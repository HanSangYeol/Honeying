package kr.ac.doowon.honeying;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantDetailActivity extends BaseActivity implements OnMapReadyCallback {

    String RESTAURANT_IMG;
    String RESTAURANT_NAME;
    String RESTAURANT_AREA;
    int RATING;
    float LONGITUDE;
    float LATITUDE;
    int DISTANCE;
    int REVIEW;

    private android.widget.ImageView backBtn;
    private android.widget.TextView restaurantTxt;
    private android.widget.ImageView restaurantImg;
    private com.balysv.materialripple.MaterialRippleLayout favoriteBtn;
    private com.balysv.materialripple.MaterialRippleLayout writereviewBtn;
    private TextView areaTxt;
    private android.widget.RatingBar rating;
    private android.widget.LinearLayout mapLayout;
    private TextView distanceTxt;
    private TextView reviewTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        RESTAURANT_IMG = getIntent().getStringExtra("titleImg");
        RESTAURANT_NAME = getIntent().getStringExtra("titleTxt");
        RESTAURANT_AREA = getIntent().getStringExtra("areaTxt");
        RATING = getIntent().getIntExtra("ratingTxt", 0);
        LONGITUDE = getIntent().getFloatExtra("longitude", 0.0f);
        LATITUDE = getIntent().getFloatExtra("latitude", 0.0f);
        DISTANCE = getIntent().getIntExtra("distanceTxt", 0);
        REVIEW = getIntent().getIntExtra("review", 0);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        Glide.with(mContext).load(RESTAURANT_IMG).into(restaurantImg);
        restaurantTxt.setText(RESTAURANT_NAME);
        areaTxt.setText(RESTAURANT_AREA);
        rating.setNumStars(RATING);
        distanceTxt.setText(DISTANCE+"");
        reviewTxt.setText(REVIEW+"");

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void setupEvents() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        writereviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, WriteReviewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng SEOUL = new LatLng(LONGITUDE, LATITUDE);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title(RESTAURANT_NAME);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 16));
    }

    @Override
    public void bindView() {
        this.mapLayout = (LinearLayout) findViewById(R.id.mapLayout);
        this.areaTxt = (TextView) findViewById(R.id.areaTxt);
        this.writereviewBtn = (MaterialRippleLayout) findViewById(R.id.writereviewBtn);
        this.favoriteBtn = (MaterialRippleLayout) findViewById(R.id.favoriteBtn);
        this.rating = (RatingBar) findViewById(R.id.rating);
        this.reviewTxt = (TextView) findViewById(R.id.reviewTxt);
        this.distanceTxt = (TextView) findViewById(R.id.distanceTxt);
        this.restaurantTxt = (TextView) findViewById(R.id.restaurantTxt);
        this.restaurantImg = (ImageView) findViewById(R.id.restaurantImg);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
