package kr.ac.doowon.honeying.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.ac.doowon.honeying.Data.Restaurant;
import kr.ac.doowon.honeying.R;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {


    Context mContext;
    List<Restaurant> mList;
    LayoutInflater inf;

    public RestaurantAdapter(Context context, List<Restaurant> list){
        super(context, R.layout.list_item_restaurant, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.list_item_restaurant, null);
        }

        return row;

    }


    @Override
    public int getCount() {
        return 20;
    }
}
