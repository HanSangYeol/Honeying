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

import de.hdodenhof.circleimageview.CircleImageView;
import kr.ac.doowon.honeying.Data.Review;
import kr.ac.doowon.honeying.R;

public class ReviewAdapter extends ArrayAdapter<Review> {

    Context mContext;
    List<Review> mList;
    LayoutInflater inf;

    public ReviewAdapter(Context context, List<Review> list){
        super(context, R.layout.list_item_review, list);
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
            row = inf.inflate(R.layout.list_item_review, null);
        }

        Review data = mList.get(position);

        CircleImageView profileImg = (CircleImageView)row.findViewById(R.id.profileImg);
        TextView nicknameTxt = (TextView)row.findViewById(R.id.nicknameTxt);
        TextView areaTxt = (TextView)row.findViewById(R.id.areatxt);
        TextView restaurantTxt = (TextView)row.findViewById(R.id.restaurantTxt);
        TextView commentTxt = (TextView)row.findViewById(R.id.contenttxt);
        ImageView reviewImg1 = (ImageView)row.findViewById(R.id.reviewImg1);
        ImageView reviewImg2 = (ImageView)row.findViewById(R.id.reviewImg2);
        ImageView reviewImg3 = (ImageView)row.findViewById(R.id.reviewImg3);
        TextView likeTxt = (TextView)row.findViewById(R.id.likeTxt);
        TextView reivewTxt = (TextView)row.findViewById(R.id.reviewTxt);

        Glide.with(mContext).load(data.getProfile()).into(profileImg);
        nicknameTxt.setText(data.getNickname());
        areaTxt.setText(data.getReviewarea());
        restaurantTxt.setText(data.getReviewshopname());
        commentTxt.setText(data.getReviewcomment());
        Glide.with(mContext).load(data.getReviewImg()).into(reviewImg1);
        Glide.with(mContext).load(data.getReviewImg2()).into(reviewImg2);
        Glide.with(mContext).load(data.getReviewImg3()).into(reviewImg3);
        likeTxt.setText(data.getGoodPoint()+"");
        reivewTxt.setText(data.getReviewContents()+"");

        return row;

    }

}
