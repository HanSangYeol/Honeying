package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

public class RestaurantDetailActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.TextView restaurantTxt;
    private android.widget.ImageView restaurantImg;
    private android.widget.ImageView star1;
    private android.widget.ImageView star2;
    private android.widget.ImageView star3;
    private android.widget.ImageView star4;
    private android.widget.ImageView star5;
    private com.balysv.materialripple.MaterialRippleLayout favoriteBtn;
    private com.balysv.materialripple.MaterialRippleLayout writereviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {

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
    public void bindView() {
        this.writereviewBtn = (MaterialRippleLayout) findViewById(R.id.writereviewBtn);
        this.favoriteBtn = (MaterialRippleLayout) findViewById(R.id.favoriteBtn);
        this.star5 = (ImageView) findViewById(R.id.star5);
        this.star4 = (ImageView) findViewById(R.id.star4);
        this.star3 = (ImageView) findViewById(R.id.star3);
        this.star2 = (ImageView) findViewById(R.id.star2);
        this.star1 = (ImageView) findViewById(R.id.star1);
        this.restaurantImg = (ImageView) findViewById(R.id.restaurantImg);
        this.restaurantTxt = (TextView) findViewById(R.id.restaurantTxt);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
