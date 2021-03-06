package kr.ac.doowon.honeying;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.ac.doowon.honeying.Data.User;

public class SignUpActivity extends BaseActivity {

    Connection con;
    long backPressedTimeInMillis = 0;
    User SignUpUser;

    private android.widget.Spinner monthspinner;
    private android.widget.Spinner dayspinner;
    private android.widget.ImageView backBtn;
    private android.widget.TextView singupBtn;
    private android.widget.EditText inputidEdt;
    private android.widget.EditText inputpwEdt;
    private android.widget.EditText checkpwEdt;
    private android.widget.EditText inputemailEdt;
    private android.widget.CheckBox essentialChk1;
    private android.widget.CheckBox essentialChk2;
    private android.widget.CheckBox essentialChk3;
    private TextView birthyearTxt;
    private android.widget.RadioButton manRdo;
    private android.widget.RadioButton womanRdo;
    private android.widget.CheckBox allChk;
    private android.widget.CheckBox optionChk1;
    private android.widget.CheckBox optionChk2;
    private android.widget.CheckBox optionChk3;

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
                boolean CheckId = true;
                if(inputidEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    CheckId = false;
                }
                boolean CheckPw = true;
                if(inputpwEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    CheckPw = false;
                }
                boolean CheckSamePw = true;
                if(!checkpwEdt.getText().toString().equals(inputpwEdt.getText().toString())){
                    Toast.makeText(mContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    CheckPw = false;
                }
                boolean CheckEmail = true;
                if(inputemailEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    CheckEmail = false;
                }
                if(CheckId && CheckPw && CheckSamePw && CheckEmail){
                    DoSignUp sign = new DoSignUp();
                    sign.execute("");
//                    SignUpUser = new User(1, inputidEdt.getText().toString(), inputpwEdt.getText().toString(), inputemailEdt.getText().toString());
//                    if (GlobalUtil.USER_LIST.contains(SignUpUser)){
//                        Toast.makeText(mContext, "이미 사용중인 아이디입니다.", Toast.LENGTH_SHORT).show();
//                    }else {
//                        GlobalUtil.USER_LIST.add(SignUpUser);
//                        ContextUtil.login(mContext, SignUpUser);
//                        Toast.makeText(mContext, "회원가입 완료\n자동 로그인되었습니다.", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(mContext, MainActivity.class);
//                        startActivity(intent);
//                        LoginActivity.loginActivity.finish();
//                        finish();
//                    }
                }
            }
        });

        allChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allChk.isChecked()){
                    optionChk1.setChecked(true);
                    optionChk2.setChecked(true);
                    optionChk3.setChecked(true);
                }else {
                    optionChk1.setChecked(false);
                    optionChk2.setChecked(false);
                    optionChk3.setChecked(false);
                }
            }
        });

        View.OnClickListener chkOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChk1.isChecked() && optionChk2.isChecked() && optionChk3.isChecked()){
                    allChk.setChecked(true);
                }
//                else if(!optionChk1.isChecked() || !optionChk2.isChecked() || optionChk3.isChecked()){
//                    allChk.setChecked(false);
//                }
                else {
                    allChk.setChecked(false);
                }
            }
        };
        optionChk1.setOnClickListener(chkOnClickListener);
        optionChk2.setOnClickListener(chkOnClickListener);
        optionChk3.setOnClickListener(chkOnClickListener);

    }

    @Override
    public void bindView() {
        this.singupBtn = (TextView) findViewById(R.id.singupBtn);
        this.optionChk3 = (CheckBox) findViewById(R.id.optionChk3);
        this.optionChk2 = (CheckBox) findViewById(R.id.optionChk2);
        this.optionChk1 = (CheckBox) findViewById(R.id.optionChk1);
        this.allChk = (CheckBox) findViewById(R.id.allChk);
        this.womanRdo = (RadioButton) findViewById(R.id.womanRdo);
        this.manRdo = (RadioButton) findViewById(R.id.manRdo);
        this.birthyearTxt = (TextView) findViewById(R.id.birthyearTxt);
        this.dayspinner = (Spinner) findViewById(R.id.dayspinner);
        this.monthspinner = (Spinner) findViewById(R.id.monthspinner);
        this.essentialChk3 = (CheckBox) findViewById(R.id.essentialChk3);
        this.essentialChk2 = (CheckBox) findViewById(R.id.essentialChk2);
        this.essentialChk1 = (CheckBox) findViewById(R.id.essentialChk1);
        this.inputemailEdt = (EditText) findViewById(R.id.inputemailEdt);
        this.checkpwEdt = (EditText) findViewById(R.id.checkpwEdt);
        this.inputpwEdt = (EditText) findViewById(R.id.inputpwEdt);
        this.inputidEdt = (EditText) findViewById(R.id.inputidEdt);
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


    public class DoSignUp extends AsyncTask<String, String, String> {
        String str = "";
        Boolean isSuccess = false;


        @Override
        protected void onPostExecute(String r) {

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                con = connectionclass();        // Connect to database
                if (con == null) {
                    str = "인터넷 접속 여부를 확인해주세요.";
                } else {
                    // Change below query according to your own database.
                    String query = "select * from login where user_name= '" + inputidEdt.getText().toString() + "'";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        str = "회원가입 실패\\n이미 사용중인 아이디 입니다.";
                        isSuccess = true;
                    } else {
                        String insert_query = "INSERT INTO login (user_name, pass_word) VALUES ('" + inputidEdt.getText().toString() + "','"+ inputpwEdt.getText().toString() +"')";
                        PreparedStatement statement = con.prepareStatement(insert_query);
                        statement.executeUpdate();
                        str = "회원가입 완료\\n자동 로그인되었습니다.";
                        isSuccess = true;
                    }
                    con.close();
                }
            } catch (Exception ex) {
                isSuccess = false;
                str = ex.getMessage();
            }
            return str;
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
