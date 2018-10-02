package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;


public class SplashActivity extends BaseActivity {

    private android.widget.ImageView rogoImg;
    private com.romainpiel.shimmer.ShimmerTextView shimmerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);;
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        Shimmer shimmer= new Shimmer();
        shimmer.start(shimmerTxt);
    }

    @Override
    public void setupEvents() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    public void bindView() {
        this.shimmerTxt = (ShimmerTextView) findViewById(R.id.shimmerTxt);
        this.rogoImg = (ImageView) findViewById(R.id.rogoImg);
    }
}
