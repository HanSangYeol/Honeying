package kr.ac.doowon.honeying.Fragment;

import android.os.Bundle;
import android.print.PrintJob;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import kr.ac.doowon.honeying.R;

public class Category_Fragment extends Fragment{

    private android.widget.ImageView searchBtn;
    private android.widget.ImageView seemapBtn;
    private android.widget.ImageView food1Img;
    private android.widget.ImageView food2Img;
    private android.widget.ImageView food3Img;
    private android.widget.ViewFlipper bannerFlipper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container,false);
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
        bannerFlipper.setOutAnimation(getActivity(), android.R.anim.fade_out);
        bannerFlipper.setFlipInterval(5000);//플리핑 간격(1000ms)
        bannerFlipper.startFlipping();
    }

    private void setEvents(){

    }
}
