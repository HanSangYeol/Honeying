package kr.ac.doowon.honeying;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import kr.ac.doowon.honeying.BaseActivity;
import kr.ac.doowon.honeying.R;

public class FindIDActivity extends BaseActivity {

    private EditText inputemailEdt;
    private LinearLayout okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);
    }

    @Override
    public void setValues() {

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void bindView() {
        this.inputemailEdt = (EditText)findViewById(R.id.inputemailEdt);
        this.okBtn = (LinearLayout)findViewById(R.id.okBtn);
    }

    @Override
    public void onBackPressed() {
        inputemailEdt.clearFocus();
        inputemailEdt.setFocusable(false);
        inputemailEdt.setFocusableInTouchMode(true);
        inputemailEdt.setFocusable(true);
    }
}
