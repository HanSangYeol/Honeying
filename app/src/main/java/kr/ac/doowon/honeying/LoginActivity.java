package kr.ac.doowon.honeying;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.q42.android.scrollingimageview.ScrollingImageView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.ac.doowon.honeying.Data.User;
import kr.ac.doowon.honeying.Util.ContextUtil;

public class LoginActivity extends BaseActivity {


    Connection con;

    float getdpi, setdpi;
    public static LoginActivity loginActivity;
    private ScrollingImageView scrollView;
    private EditText inputidEdt;
    private EditText inputpwEdt;
    private MaterialRippleLayout loginBtn;
    private TextView findidBtn;
    private TextView findpwBtn;
    private TextView signupBtn;
    private TextView passBtn;

    int ScreenWidth;
    int ScreenHeight;
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
        scrollView.setAlpha(0.2f);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ScreenWidth = size.x;
        ScreenHeight = size.y;
        Log.e("heigth", ScreenHeight+"");
        scrollView.setScaleX((ScreenHeight/355)-1);
        scrollView.setScaleY((ScreenHeight/355)-1);
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
                CheckLogin checkLogin = new CheckLogin();// this is the Asynctask, which is used to process in background to reduce load on app process
                checkLogin.execute("");
//                if (inputidEdt.getText().toString().equals("")){
//                    Toast.makeText(mContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
//                    if(inputpwEdt.getText().toString().equals("")){
//                        Toast.makeText(mContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else{
//                    GlobalUtil.USER_DATA();
//                    GlobalUtil.USER_LIST.add(new User(1,  inputidEdt.getText().toString(), inputpwEdt.getText().toString(), ""));
//                    DBManager.CheckLogin checkLogin = manager.new CheckLogin();
//                    checkLogin.execute("");
//                }

//                GlobalUtil.USER_DATA();
//                for (User tempUser : GlobalUtil.USER_LIST){
////                    Log.d("id", tempUser.getLogin_Id());
//                    if (inputidEdt.getText().toString().equals(tempUser.getLogin_Id()) && inputpwEdt.getText().toString().equals(tempUser.getPw())) {
//                        user = new User(1,inputidEdt.getText().toString(), inputpwEdt.getText().toString(), "samh2006@naver.com");
//                        ContextUtil.login(mContext, user);
//                        Intent intent = new Intent(mContext, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//                        break;
//                    } else {
//                        Toast.makeText(mContext, "로그인에 실패하였습니다.\nID와 PW를 확인해주세요.", Toast.LENGTH_SHORT).show();
//                    }
//                }

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

    public class CheckLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;


        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(mContext, r, Toast.LENGTH_SHORT).show();
            if (isSuccess) {
                Toast.makeText(mContext, "Login Successfull", Toast.LENGTH_LONG).show();
                //finish();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            if (inputidEdt.getText().toString().trim().equals("") || inputpwEdt.getText().toString().trim().equals(""))
                z = "아이디와 비밀번호를 입력해주세요.";
            else {
                try {
                    con = connectionclass();        // Connect to database
                    if (con == null) {
                        z = "인터넷 접속 여부를 확인해주세요.";
                    } else {
                        // Change below query according to your own database.
                        String query = "select * from login where user_name= '" + inputidEdt.getText().toString() + "' and pass_word = '" + inputpwEdt.getText().toString() + "'  ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            z = "로그인 성공";
                            isSuccess = true;
                            con.close();
                            user = new User(1, inputidEdt.getText().toString(), inputpwEdt.getText().toString(), "samh2006@naver.com");
                            ContextUtil.login(mContext, user);
                            Intent intent = new Intent(mContext, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            z = "로그인 실패";
                            isSuccess = false;
                        }
                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = ex.getMessage();
                }
            }
            return z;
        }
    }


    @SuppressLint("NewApi")
    public Connection connectionclass() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://srhyun.doowon.ac.kr/honeying;user=sa;password=sa!t3;";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("error here 1 : ", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("error here 2 : ", e.getMessage());
        } catch (Exception e) {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}
