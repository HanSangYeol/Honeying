package kr.ac.doowon.honeying.Fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.doowon.honeying.Adapter.ReviewAdapter;
import kr.ac.doowon.honeying.Data.Review;
import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.Util.GlobalUtil;

public class Review_Recommend_Fragment extends Fragment {

    //DB연결을 위한 Connection
    Connection con;

    ReviewAdapter reviewAdapter;
    List<Review> reviewList = new ArrayList<>();

    Review review;

    private android.widget.ListView reviewListView;
    private android.widget.Spinner areaSpinner;
    private ImageView filterBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_recommend, container, false);
        this.filterBtn = (ImageView) view.findViewById(R.id.filterBtn);
        this.areaSpinner = (Spinner) view.findViewById(R.id.areaSpinner);
        this.reviewListView = (ListView) view.findViewById(R.id.reviewListView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues(){
        GetReview getReview = new GetReview();
        getReview.execute("");
        GlobalUtil.REVIEW_DATA();

        reviewList.addAll(GlobalUtil.REVIEW_LIST);
        reviewAdapter = new ReviewAdapter(getActivity(), reviewList);
        reviewListView.setAdapter(reviewAdapter);
    }

    private void setupEvents(){
        //TODO https://github.com/ChadCSong/ShineButton


    }


    public class GetReview extends AsyncTask<String, String, String> {
        String str = "";
        Boolean isSuccess = false;


        @Override
        protected void onPostExecute(String r) {

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                con = connectionclass();
                if (con == null) {
                    str = "인터넷 접속 여부를 확인해주세요.";
                } else {
                    String query = "select * from Review";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        String reviewImg = rs.getString("reviewImg");
                        String reviewImg2 = rs.getString("reviewImg2");
                        String reviewImg3 = rs.getString("reviewImg3");
                        String nickname = rs.getString("UserID");
                        int rating = rs.getInt("Rating");
                        int comment = rs.getInt("Comment");
                        String contents = rs.getString("Contents");
                        String res_name = rs.getString("RestaurantName");
                        String res_address = rs.getString("RestaurantAddress");

                        review = new Review("", reviewImg,reviewImg2, reviewImg3, nickname, rating, comment, contents, res_name, res_address);
                        GlobalUtil.REVIEW_LIST.add(review);
                    }
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
