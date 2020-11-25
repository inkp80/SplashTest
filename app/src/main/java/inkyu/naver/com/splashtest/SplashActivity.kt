package inkyu.naver.com.splashtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP


        if (isDarkMode()) {
            Log.d("inkp", "splash : is Dark")
            window.setBackgroundDrawableResource(R.drawable.window_background)
//            setContentView(R.layout.activity_splash_dark)

            val view = findViewById<View>(R.id.textView)
            view?.run {

                afterMeasured {

//                    postDelayed({
//                        startActivity(intent)
//                        finish()
//                    }, 400)

//                    startActivity(intent)
//                    finish()
                    Log.d("inkp", "we got the view : afterMeasure")
                }
            }

            startActivity(intent)
            finish()
        } else {
            Log.d("inkp", "splash : is Light")
            window.setBackgroundDrawableResource(R.drawable.window_background)
//            setContentView(R.layout.activity_splash_light)
            val view = findViewById<View>(R.id.textView)
            view?.run {

                afterMeasured {
//                    startActivity(intent)
//                    finish()
                    Log.d("inkp", "we got the view : afterMeasure")
                }
            }

            startActivity(intent)
            finish()
        }


    }
}