package kr.ac.doowon.honeying.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

    @Override
    public int getCount() {
        return mList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.list_item_restaurant, null);
        }

        Restaurant data = mList.get(position);

        ImageView titleImg = (ImageView)row.findViewById(R.id.titleImg);
        TextView restaurantTxt = (TextView)row.findViewById(R.id.restaurantTxt);
        TextView areaTxt = (TextView)row.findViewById(R.id.areaTxt);
        TextView ratingTxt = (TextView)row.findViewById(R.id.ratingTxt);
        TextView reviewTxt = (TextView)row.findViewById(R.id.reviewTxt);
        TextView distanceTxt = (TextView)row.findViewById(R.id.distanceTxt);

        Glide.with(mContext).load(data.getStoreimg()).into(titleImg);
        restaurantTxt.setText(data.getShopname());
        areaTxt.setText(data.getArea());
        ratingTxt.setText(data.getGrade()+"");
        reviewTxt.setText(data.getReview()+"");
        distanceTxt.setText(data.getStreet()+"");

        return row;

    }



}
