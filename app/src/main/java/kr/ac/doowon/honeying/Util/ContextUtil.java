package kr.ac.doowon.honeying.Util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.ac.doowon.honeying.Data.User;

public class ContextUtil {

    private static final String prefName = "Honeying";

    private static final String USER_ID = "USER_ID";
    private static final String USER_LOGIN_ID = "USER_LOGIN_ID";
    private static final String USER_PW = "USER_PW";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_ADDRESS = "USER_ADDRESS";
    private static final String USER_PHONE = "USER_PHONE";

    public static User userinfo;

    public static void login(Context context, User user){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(USER_ID, user.getId()).apply();
        pref.edit().putString(USER_LOGIN_ID, user.getLogin_Id()).apply();
        pref.edit().putString(USER_PW, user.getPw()).apply();

    }

    public static void logout(Context context){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(USER_ID, 0).apply();
        pref.edit().putString(USER_LOGIN_ID, "").apply();
        pref.edit().putString(USER_PW, "").apply();

    }

    public static User getLoginUserInfo(Context context){



        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getInt(USER_ID, 0) != 0){

            userinfo = new User();

            userinfo.setId(pref.getInt(USER_ID, 0));
            userinfo.setLogin_Id(pref.getString(USER_LOGIN_ID, ""));
            userinfo.setPw(pref.getString(USER_PW, ""));
        }else {
            userinfo = null;
        }

        return userinfo;
    }
}
