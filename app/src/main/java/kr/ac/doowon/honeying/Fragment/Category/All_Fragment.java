package kr.ac.doowon.honeying.Fragment.Category;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.ac.doowon.honeying.Adapter.RestaurantAdapter;
import kr.ac.doowon.honeying.Data.Restaurant;
import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.RestaurantDetailActivity;
import kr.ac.doowon.honeying.Util.GlobalUtil;

public class All_Fragment extends Fragment {

    RestaurantAdapter restaurantAdapter;
    List<Restaurant> restaurantList = new ArrayList<>();
    private android.widget.ListView Listview;

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
        GlobalUtil.RESTAURANT_DATA();

        restaurantList.addAll(GlobalUtil.RESTAURANT_LIST);
        restaurantAdapter = new RestaurantAdapter(getActivity(), restaurantList);
        Listview.setAdapter(restaurantAdapter);


    }
}
