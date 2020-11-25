package inkyu.naver.com.splashtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({}, 10000)

//        SearchPreferenceManager.setStringValue(R.string.keyNightMode, "night")
    }
}