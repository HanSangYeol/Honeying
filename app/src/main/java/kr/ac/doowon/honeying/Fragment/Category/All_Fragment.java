package kr.ac.doowon.honeying.Fragment.Category;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
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
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.doowon.honeying.Adapter.RestaurantAdapter;
import kr.ac.doowon.honeying.Data.Restaurant;
import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.RestaurantDetailActivity;
import kr.ac.doowon.honeying.Util.GlobalUtil;
import kr.ac.doowon.honeying.Util.GpsInfo;

public class All_Fragment extends Fragment {

    RestaurantAdapter restaurantAdapter;
    List<Restaurant> restaurantList = new ArrayList<>();
    private android.widget.ListView Listview;

    Connection con;
    //주소 => 위도,경도 메서드
    final Geocoder geocoder = new Geocoder(getActivity());
    //현재위치 위도,경도 가져오기
    GpsInfo gps = new GpsInfo(getActivity());
    double latitude = gps.getLatitude();
    double longitude = gps.getLongitude();

    //현재위치와 가게와의 거리 구하기
    LocationDistance locationDistance = new LocationDistance();

    //현재위치와 가게와의 거리 저장 변수
    double distance;

    //GlobalData에 저장할 가게변수
    Restaurant restaurant;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_all, container, false);
        this.Listview = (ListView) view.findViewById(R.id.Listview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setupEvents(){
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), RestaurantDetailActivity.class);
                intent.putExtra("titleImg", restaurantList.get(i).getStoreimg());
                intent.putExtra("titleTxt", restaurantList.get(i).getShopname());
                intent.putExtra("areaTxt", restaurantList.get(i).getArea());
                intent.putExtra("ratingTxt", restaurantList.get(i).getGrade());
                intent.putExtra("longitude", restaurantList.get(i).getLongitude());
                intent.putExtra("latitude", restaurantList.get(i).getLatitude());
                intent.putExtra("distanceTxt", restaurantList.get(i).getGrade());
                intent.putExtra("reviewTxt", restaurantList.get(i).getReview());
                startActivity(intent);
            }
        });
    }
    private void setValues(){
        GetRestaurant getRestaurant = new GetRestaurant();
        getRestaurant.execute("");
        GlobalUtil.RESTAURANT_DATA();

        restaurantList.addAll(GlobalUtil.RESTAURANT_LIST);
        restaurantAdapter = new RestaurantAdapter(getActivity(), restaurantList);
        Listview.setAdapter(restaurantAdapter);


    }

    public class GetRestaurant extends AsyncTask<String, String, String> {
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
                    String query = "select * from Restaurant";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        int category = rs.getInt("Category");
                        String title = rs.getString("Name");
                        String location = rs.getString("location");
                        double[] lat_lon = Address_Change(location);
                        distance = locationDistance.distance(latitude, longitude, lat_lon[0], lat_lon[1], "kilometer");
                        String storeimg = rs.getString("image");
                        int Rating = rs.getInt("Rating");

                        restaurant = new Restaurant(1, storeimg, title, Rating, 0, location, distance, category,longitude, latitude);
                        GlobalUtil.RESTAURANT_LIST.add(restaurant);
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

    public double[] Address_Change(String input_address){

        List<Address> list = null;

        try{
            list = geocoder.getFromLocationName(input_address, 1);
        }catch (IOException e){
            e.printStackTrace();
        }

        Address addr = list.get(0);
        double lat = addr.getLatitude();
        double lon = addr.getLongitude();


        return new double[] {lat, lon};
    }

    public class LocationDistance {

       //두 지점간의 거리 계산
        // 1 : 위도, 경도 2 : 위도, 경도

        private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

            double theta = lon1 - lon2;
            double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515;

            if (unit == "kilometer") {
                dist = dist * 1.609344;
            } else if(unit == "meter"){
                dist = dist * 1609.344;
            }
            return (dist);
        }

        private double deg2rad(double deg) {
            return (deg * Math.PI / 180.0);
        }

        private double rad2deg(double rad) {
            return (rad * 180 / Math.PI);
        }

    }

}
