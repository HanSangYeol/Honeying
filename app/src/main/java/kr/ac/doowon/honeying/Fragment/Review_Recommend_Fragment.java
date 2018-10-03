package kr.ac.doowon.honeying.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import kr.ac.doowon.honeying.Adapter.ReviewAdapter;
import kr.ac.doowon.honeying.Data.Review;
import kr.ac.doowon.honeying.R;

public class Review_Recommend_Fragment extends Fragment {

    ReviewAdapter reviewAdapter;
    List<Review> reviewList;

    private android.widget.ImageView seemapBtn;
    private android.widget.ListView reviewListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_recommend, container,false);
        this.reviewListView = (ListView) view.findViewById(R.id.reviewListView);
        this.seemapBtn = (ImageView) view.findViewById(R.id.seemapBtn);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues(){
        reviewAdapter = new ReviewAdapter(getActivity(), reviewList);
        reviewListView.setAdapter(reviewAdapter);
    }

    private void setupEvents(){
        //TODO https://github.com/ChadCSong/ShineButton
    }
}
