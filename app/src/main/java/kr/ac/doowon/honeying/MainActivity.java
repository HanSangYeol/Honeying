package kr.ac.doowon.honeying;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private android.widget.LinearLayout CategoryFragLayout;
    private android.widget.LinearLayout recommendFragLayout;
    private android.widget.LinearLayout reviewFragLayout;
    private android.widget.LinearLayout mypageFragLayout;
    private android.support.design.widget.BottomNavigationView bottomNavi;

    long backPressedTimeInMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {

    }

    @Override
    public void setupEvents() {

        bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.category_action:
                        CategoryFragLayout.setVisibility(View.VISIBLE);
                        recommendFragLayout.setVisibility(View.GONE);
                        reviewFragLayout.setVisibility(View.GONE);
                        mypageFragLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.recommend_action:
                        CategoryFragLayout.setVisibility(View.GONE);
                        recommendFragLayout.setVisibility(View.VISIBLE);
                        reviewFragLayout.setVisibility(View.GONE);
                        mypageFragLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.review_action:
                        CategoryFragLayout.setVisibility(View.GONE);
                        recommendFragLayout.setVisibility(View.GONE);
                        reviewFragLayout.setVisibility(View.VISIBLE);
                        mypageFragLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.mypage_action:
                        CategoryFragLayout.setVisibility(View.GONE);
                        recommendFragLayout.setVisibility(View.GONE);
                        reviewFragLayout.setVisibility(View.GONE);
                        mypageFragLayout.setVisibility(View.VISIBLE);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void bindView() {
        this.bottomNavi = (BottomNavigationView) findViewById(R.id.bottomNavi);
        this.mypageFragLayout = (LinearLayout) findViewById(R.id.mypageFragLayout);
        this.reviewFragLayout = (LinearLayout) findViewById(R.id.reviewFragLayout);
        this.recommendFragLayout = (LinearLayout) findViewById(R.id.recommendFragLayout);
        this.CategoryFragLayout = (LinearLayout) findViewById(R.id.CategoryFragLayout);
    }


    @Override
    public void onBackPressed() {
        long currentTimeInMillis = System.currentTimeMillis();

        if (currentTimeInMillis - backPressedTimeInMillis < 2000) {
//            2초 이내에 백버튼을 다시 눌렀으니 종료해야 함.
            finish();
            return;
        }
        else {
//            최초로 백버튼을 눌렀거나, 혹은 2초 이상의 시간이 지난 후에 누름.
            Toast.makeText(mContext, "한번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
            bottomNavi.setSelectedItemId(R.id.CategoryFragLayout);
        }

        backPressedTimeInMillis = currentTimeInMillis;
    }



}
