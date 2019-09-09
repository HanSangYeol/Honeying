package kr.ac.doowon.honeying;

import android.media.Image;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import kr.ac.doowon.honeying.BaseActivity;
import kr.ac.doowon.honeying.R;

public class FindIDActivity extends BaseActivity {

    private EditText inputemailEdt;
    private LinearLayout okBtn;
    private ImageView backBtn;
    private InputMethodManager inputMethodManager;
    long backPressedTimeInMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
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
        this.inputemailEdt = (EditText)findViewById(R.id.inputemailEdt);
        this.okBtn = (LinearLayout)findViewById(R.id.okBtn);
        this.backBtn = (ImageView)findViewById(R.id.backBtn);
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
            inputMethodManager.hideSoftInputFromWindow(inputemailEdt.getWindowToken(), 0);
        }
        backPressedTimeInMillis = currentTimeInMillis;

    }
}
