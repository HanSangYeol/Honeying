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
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import kr.ac.doowon.honeying.Adapter.ReviewAdapter;
import kr.ac.doowon.honeying.Data.Review;
import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.Util.GlobalUtil;

public class Review_Recommend_Fragment extends Fragment {

    ReviewAdapter reviewAdapter;
    List<Review> reviewList = new ArrayList<>();

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
        GlobalUtil.REVIEW_DATA();

        reviewList.addAll(GlobalUtil.REVIEW_LIST);
        reviewAdapter = new ReviewAdapter(getActivity(), reviewList);
        reviewListView.setAdapter(reviewAdapter);
    }

    private void setupEvents(){
        //TODO https://github.com/ChadCSong/ShineButton


    }
}
