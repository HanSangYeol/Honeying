package kr.ac.doowon.honeying;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WriteReviewActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.TextView restaurantTxt;
    private android.widget.EditText inputreviewEdt;
    private android.widget.LinearLayout okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {

    }

    @Override
    public void setupEvents() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void bindView() {
        this.okBtn = (LinearLayout) findViewById(R.id.okBtn);
        this.inputreviewEdt = (EditText) findViewById(R.id.inputreviewEdt);
        this.restaurantTxt = (TextView) findViewById(R.id.restaurantTxt);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
