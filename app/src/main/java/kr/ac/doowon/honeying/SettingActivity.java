package kr.ac.doowon.honeying;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.TextView idTxt;
    private android.widget.TextView logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
    }

    @Override
    public void bindView() {
        this.logoutBtn = (TextView) findViewById(R.id.logoutBtn);
        this.idTxt = (TextView) findViewById(R.id.idTxt);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
