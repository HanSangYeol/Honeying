package kr.ac.doowon.honeying.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.ac.doowon.honeying.R;
import kr.ac.doowon.honeying.SettingActivity;

public class MyPage_Fragment extends Fragment {

    private android.widget.ImageView settingBtn;
    private android.widget.ImageView shoppingbasketBtn;
    private android.widget.ImageView profileImg;
    private android.widget.TextView nameTxt;
    private android.widget.TextView savemoneyTxt;
    private android.widget.TextView pointTxt;
    private android.widget.LinearLayout loginstatus;
    private de.hdodenhof.circleimageview.CircleImageView orderinquiryBtn;
    private de.hdodenhof.circleimageview.CircleImageView itemofinterestBtn;
    private android.widget.LinearLayout consultingBtn;
    private android.widget.LinearLayout myconsultingBtn;
    private android.widget.LinearLayout estimateconsultingBtn;
    private de.hdodenhof.circleimageview.CircleImageView reviewBtn;
    private de.hdodenhof.circleimageview.CircleImageView favoriteBtn;
    private android.widget.LinearLayout questionBtn;
    private android.widget.LinearLayout registerBtn;
    private android.widget.LinearLayout eventBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);
        this.eventBtn = (LinearLayout) view.findViewById(R.id.eventBtn);
        this.registerBtn = (LinearLayout) view.findViewById(R.id.registerBtn);
        this.questionBtn = (LinearLayout) view.findViewById(R.id.questionBtn);
        this.favoriteBtn = (CircleImageView) view.findViewById(R.id.favoriteBtn);
        this.reviewBtn = (CircleImageView) view.findViewById(R.id.reviewBtn);
        this.loginstatus = (LinearLayout) view.findViewById(R.id.loginstatus);
        this.pointTxt = (TextView) view.findViewById(R.id.pointTxt);
        this.savemoneyTxt = (TextView) view.findViewById(R.id.savemoneyTxt);
        this.nameTxt = (TextView) view.findViewById(R.id.nameTxt);
        this.profileImg = (ImageView) view.findViewById(R.id.profileImg);
        this.settingBtn = (ImageView) view.findViewById(R.id.settingBtn);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setEvent();
        setValues();
    }

    private void setValues(){

    }

    private void setEvent(){
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
