package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.q42.android.scrollingimageview.ScrollingImageView;

import kr.ac.doowon.honeying.Data.User;
import kr.ac.doowon.honeying.Util.ContextUtil;
import kr.ac.doowon.honeying.Util.GlobalUtil;

public class LoginActivity extends BaseActivity {


    public static LoginActivity loginActivity;
    private ScrollingImageView scrollView;
    private EditText inputidEdt;
    private EditText inputpwEdt;
    private MaterialRippleLayout loginBtn;
    private TextView findidBtn;
    private TextView findpwBtn;
    private TextView signupBtn;
    private TextView passBtn;

    User user;

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
        loginActivity = this;
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
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalUtil.USER_DATA();
                for (User tempUser : GlobalUtil.USER_LIST){
//                    Log.d("id", tempUser.getLogin_Id());
                    if (inputidEdt.getText().toString().equals(tempUser.getLogin_Id()) && inputpwEdt.getText().toString().equals(tempUser.getPw())) {
                        user = new User(1,inputidEdt.getText().toString(), inputpwEdt.getText().toString(), "samh2006@naver.com");
                        ContextUtil.login(mContext, user);
                        Intent intent = new Intent(mContext, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    } else {
                        Toast.makeText(mContext, "로그인에 실패하였습니다.\nID와 PW를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    public void bindView() {
        this.passBtn = (TextView) findViewById(R.id.passBtn);
        this.signupBtn = (TextView) findViewById(R.id.signupBtn);
        this.findpwBtn = (TextView) findViewById(R.id.findpwBtn);
        this.findidBtn = (TextView) findViewById(R.id.findidBtn);
        this.loginBtn = (MaterialRippleLayout) findViewById(R.id.loginBtn);
        this.inputpwEdt = (EditText) findViewById(R.id.inputpwEdt);
        this.inputidEdt = (EditText) findViewById(R.id.inputidEdt);
        this.scrollView = (ScrollingImageView) findViewById(R.id.scrollView);
    }
}
