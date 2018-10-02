package kr.ac.doowon.honeying;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import kr.ac.doowon.honeying.Adapter.CategoryAdapter;

public class RestaurantListActivity extends BaseActivity {

    int RESLUT_NUM = 0;

    private android.widget.ImageView searchBtn;
    private android.widget.ImageView seemapBtn;
    private android.support.design.widget.TabItem tabItem1;
    private android.support.design.widget.TabItem tabItem2;
    private android.support.design.widget.TabItem tabItem3;
    private android.support.design.widget.TabItem tabItem4;
    private android.support.design.widget.TabItem tabItem5;
    private android.support.design.widget.TabItem tabItem6;
    private android.support.design.widget.TabItem tabItem7;
    private android.support.design.widget.TabItem tabItem8;
    private android.support.design.widget.TabItem tabItem9;
    private android.support.design.widget.TabLayout tabLayout;
    private android.support.v4.view.ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        RESLUT_NUM = getIntent().getIntExtra("categoryNumber", 0);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        viewPager.setAdapter(new CategoryAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        TabLayout.Tab tab = tabLayout.getTabAt(RESLUT_NUM);
        tab.select();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void bindView() {
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.tabItem9 = (TabItem) findViewById(R.id.tabItem9);
        this.tabItem8 = (TabItem) findViewById(R.id.tabItem8);
        this.tabItem7 = (TabItem) findViewById(R.id.tabItem7);
        this.tabItem6 = (TabItem) findViewById(R.id.tabItem6);
        this.tabItem5 = (TabItem) findViewById(R.id.tabItem5);
        this.tabItem4 = (TabItem) findViewById(R.id.tabItem4);
        this.tabItem3 = (TabItem) findViewById(R.id.tabItem3);
        this.tabItem2 = (TabItem) findViewById(R.id.tabItem2);
        this.tabItem1 = (TabItem) findViewById(R.id.tabItem1);
        this.seemapBtn = (ImageView) findViewById(R.id.seemapBtn);
        this.searchBtn = (ImageView) findViewById(R.id.searchBtn);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()){
            overridePendingTransition(R.anim.not_move_activity, R.anim.rightout_activity);
        }
    }
}
