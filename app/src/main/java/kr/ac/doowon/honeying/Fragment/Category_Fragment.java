package kr.ac.doowon.honeying.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.RestaurantListActivity;

public class Category_Fragment extends Fragment{

    int RESULT_ACTIVITY = 1000;

    private android.widget.ImageView searchBtn;
    private android.widget.ImageView seemapBtn;
    private android.widget.ImageView food1Img;
    private android.widget.ImageView food2Img;
    private android.widget.ImageView food3Img;
    private android.widget.ViewFlipper bannerFlipper;
    private android.widget.LinearLayout allBtn;
    private android.widget.LinearLayout koreanBtn;
    private android.widget.LinearLayout snackbarBtn;
    private android.widget.LinearLayout chineseBtn;
    private android.widget.LinearLayout japaneseBtn;
    private android.widget.LinearLayout pastaBtn;
    private android.widget.LinearLayout porkcutletBtn;
    private android.widget.LinearLayout porkfeetBtn;
    private android.widget.LinearLayout cafeBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container,false);
        this.cafeBtn = (LinearLayout) view.findViewById(R.id.cafeBtn);
        this.porkfeetBtn = (LinearLayout) view.findViewById(R.id.porkfeetBtn);
        this.porkcutletBtn = (LinearLayout) view.findViewById(R.id.porkcutletBtn);
        this.pastaBtn = (LinearLayout) view.findViewById(R.id.pastaBtn);
        this.japaneseBtn = (LinearLayout) view.findViewById(R.id.japaneseBtn);
        this.chineseBtn = (LinearLayout) view.findViewById(R.id.chineseBtn);
        this.snackbarBtn = (LinearLayout) view.findViewById(R.id.snackbarBtn);
        this.koreanBtn = (LinearLayout) view.findViewById(R.id.koreanBtn);
        this.allBtn = (LinearLayout) view.findViewById(R.id.allBtn);
        this.bannerFlipper = (ViewFlipper) view.findViewById(R.id.bannerFlipper);
        this.food3Img = (ImageView) view.findViewById(R.id.food3Img);
        this.food2Img = (ImageView) view.findViewById(R.id.food2Img);
        this.food1Img = (ImageView) view.findViewById(R.id.food1Img);
        this.seemapBtn = (ImageView) view.findViewById(R.id.seemapBtn);
        this.searchBtn = (ImageView) view.findViewById(R.id.searchBtn);
        setEvents();
        setValues();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setValues(){
        Glide.with(getActivity()).load(R.drawable.food1).into(food1Img);
        Glide.with(getActivity()).load(R.drawable.food2).into(food2Img);
        Glide.with(getActivity()).load(R.drawable.food3).into(food3Img);
        Animation showIn = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
        bannerFlipper.setInAnimation(showIn);
        bannerFlipper.setOutAnimation(getActivity(), android.R.anim.slide_in_left);
        bannerFlipper.setFlipInterval(5000);//플리핑 간격(1000ms)
        bannerFlipper.startFlipping();
    }

    private void setEvents(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RestaurantListActivity.class);
                intent.putExtra("categoryNumber", Integer.parseInt(view.getTag().toString()));
                startActivityForResult(intent, RESULT_ACTIVITY);
                getActivity().overridePendingTransition(R.anim.rightin_activity, R.anim.not_move_activity);
            }
        };
        allBtn.setOnClickListener(onClickListener);
        koreanBtn.setOnClickListener(onClickListener);
        snackbarBtn.setOnClickListener(onClickListener);
        chineseBtn.setOnClickListener(onClickListener);
        japaneseBtn.setOnClickListener(onClickListener);
        pastaBtn.setOnClickListener(onClickListener);
        porkcutletBtn.setOnClickListener(onClickListener);
        porkfeetBtn.setOnClickListener(onClickListener);
        cafeBtn.setOnClickListener(onClickListener);
    }
}
