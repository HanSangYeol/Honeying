package kr.ac.doowon.honeying;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends BaseActivity {

    long backPressedTimeInMillis = 0;

    private android.widget.Spinner monthspinner;
    private android.widget.Spinner dayspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this, R.array.date_month, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthspinner.setAdapter(monthAdapter);

        ArrayAdapter dayAdapter = ArrayAdapter.createFromResource(this, R.array.date_month, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayspinner.setAdapter(dayAdapter);
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void bindView() {
        this.dayspinner = (Spinner) findViewById(R.id.dayspinner);
        this.monthspinner = (Spinner) findViewById(R.id.monthspinner);
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
        }

        backPressedTimeInMillis = currentTimeInMillis;
    }

}
