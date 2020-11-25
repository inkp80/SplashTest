package inkyu.naver.com.splashtest;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;

public class SplashApplication extends Application {

    protected static Context mApplicationContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        initNightMode();
    }

    void initNightMode() {
        String localMode = "night";

        if (localMode.equalsIgnoreCase("night")) {
            Log.d("inkp", "init : isNight");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else{
            Log.d("inkp", "init : isLight");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}