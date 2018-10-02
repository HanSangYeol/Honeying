package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends BaseActivity {

    long backPressedTimeInMillis = 0;

    private android.widget.Spinner monthspinner;
    private android.widget.Spinner dayspinner;
    private android.widget.ImageView backBtn;
    private android.widget.TextView singupBtn;

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

        ArrayAdapter dayAdapter = ArrayAdapter.createFromResource(this, R.array.date_day, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayspinner.setAdapter(dayAdapter);
    }

    @Override
    public void setupEvents() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        singupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 회원가입
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                Toast.makeText(mContext, "회원가입이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
                LoginActivity.loginActivity.finish();
            }
        });

    }

    @Override
    public void bindView() {
        this.singupBtn = (TextView) findViewById(R.id.singupBtn);
        this.dayspinner = (Spinner) findViewById(R.id.dayspinner);
        this.monthspinner = (Spinner) findViewById(R.id.monthspinner);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
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
