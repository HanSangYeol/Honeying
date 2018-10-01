package kr.ac.doowon.honeying;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText inputidEdt;
    private android.widget.EditText inputpwEdt;
    private com.q42.android.scrollingimageview.ScrollingImageView scrollView;

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

        scrollView.setAlpha(0.7f);
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void bindView() {
        this.inputpwEdt = (EditText) findViewById(R.id.inputpwEdt);
        this.inputidEdt = (EditText) findViewById(R.id.inputidEdt);
        this.scrollView = (ScrollingImageView) findViewById(R.id.scrollView);
    }
}
