package kr.ac.doowon.honeying.Util;

import java.util.ArrayList;
import java.util.List;

import kr.ac.doowon.honeying.Data.Restaurant;
import kr.ac.doowon.honeying.Data.Review;

public class GlobalUtil {

    public static final List<Restaurant> RESTAURANT_LIST = new ArrayList<>();
    public static final List<Review> REVIEW_LIST = new ArrayList<>();

    public static void RESTAURANT_DATA(){
        RESTAURANT_LIST.clear();
    }

    public static void REVIEW_DATA(){
        REVIEW_LIST.clear();
    }

}
