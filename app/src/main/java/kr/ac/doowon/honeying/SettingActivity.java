package kr.ac.doowon.honeying;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.ac.doowon.honeying.Util.ContextUtil;

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
        if (ContextUtil.getLoginUserInfo(mContext) == null){
            idTxt.setText("");
            logoutBtn.setText("로그인하기");
        }else {
            idTxt.setText(ContextUtil.getLoginUserInfo(mContext).getLogin_Id());
            logoutBtn.setText("로그아웃");
        }
    }

    @Override
    public void setupEvents() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextUtil.getLoginUserInfo(mContext) ==  null){
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    MainActivity.mainActivity.finish();
                }else {
                    ContextUtil.logout(mContext);
                    finish();
                }
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
