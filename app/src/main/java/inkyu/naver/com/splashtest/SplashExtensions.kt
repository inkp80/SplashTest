package inkyu.naver.com.splashtest

import android.content.Context
import android.content.res.Configuration
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatDelegate


fun Context.isDarkMode(): Boolean {
    return this.resources.configuration.isDarkMode()
}

fun Configuration.isDarkMode(): Boolean {
    return when {
        AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES -> true
        AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO -> false
        else -> this.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
}

inline fun View.afterMeasured(crossinline f: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}