package kr.ac.doowon.honeying;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    Context mContext = this;

    public abstract void setValues();
    public abstract void setupEvents();
    public abstract void bindView();

}
