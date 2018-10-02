package kr.ac.doowon.honeying.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.ac.doowon.honeying.Fragment.Category.All_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Cafe_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Chinese_meal_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Japanese_meal_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Korean_meal_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Pasta_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Pork_cutlet_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Pork_feet_Fragment;
import kr.ac.doowon.honeying.Fragment.Category.Snack_bar_Fragment;

public class CategoryAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 9;

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new All_Fragment();
            case 1:
                return new Korean_meal_Fragment();
            case 2:
                return new Snack_bar_Fragment();
            case 3:
                return new Chinese_meal_Fragment();
            case 4:
                return new Japanese_meal_Fragment();
            case 5:
                return new Pasta_Fragment();
            case 6:
                return new Pork_cutlet_Fragment();
            case 7:
                return new Pork_feet_Fragment();
            case 8:
                return new Cafe_Fragment();
            default:
                return null;

        }
    }
}
