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

import java.util.List;

import kr.ac.doowon.honeying.Adapter.RestaurantAdapter;
import kr.ac.doowon.honeying.Data.Restaurant;
import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.RestaurantDetailActivity;

public class Japanese_meal_Fragment extends Fragment {

    RestaurantAdapter restaurantAdapter;
    List<Restaurant> restaurantList;
    private android.widget.ListView Listview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_japanese_meal, container, false);
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
                startActivity(intent);
            }
        });
    }
    private void setValues(){
        restaurantAdapter = new RestaurantAdapter(getActivity(), restaurantList);
        Listview.setAdapter(restaurantAdapter);


    }
}
