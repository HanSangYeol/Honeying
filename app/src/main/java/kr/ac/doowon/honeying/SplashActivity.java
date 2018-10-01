package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;


public class SplashActivity extends BaseActivity {

    private android.widget.ImageView rogoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
    }

    @Override
    public void setupEvents() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                fileList();
            }
        }, 2000);
    }

    @Override
    public void bindView() {
        this.rogoImg = (ImageView) findViewById(R.id.rogoImg);
    }
}
