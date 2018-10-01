package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText inputidEdt;
    private android.widget.EditText inputpwEdt;
    private com.q42.android.scrollingimageview.ScrollingImageView scrollView;
    private android.widget.TextView findidBtn;
    private android.widget.TextView findpwBtn;
    private android.widget.TextView passBtn;
    private android.widget.TextView signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        scrollView.setAlpha(0.5f);
    }

    @Override
    public void setupEvents() {
        passBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void bindView() {
        this.signupBtn = (TextView) findViewById(R.id.signupBtn);
        this.passBtn = (TextView) findViewById(R.id.passBtn);
        this.findpwBtn = (TextView) findViewById(R.id.findpwBtn);
        this.findidBtn = (TextView) findViewById(R.id.findidBtn);
        this.inputpwEdt = (EditText) findViewById(R.id.inputpwEdt);
        this.inputidEdt = (EditText) findViewById(R.id.inputidEdt);
        this.scrollView = (ScrollingImageView) findViewById(R.id.scrollView);
    }
}
