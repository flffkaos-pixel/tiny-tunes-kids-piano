package com.example.kidspiano

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var web: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web = WebView(this)
        setContentView(web)
        web.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            mediaPlaybackRequiresUserGesture = false
            cacheMode = WebSettings.LOAD_DEFAULT
        }
        web.webViewClient = WebViewClient()
        // www/index.html 을 assets 로 복사해서 로드
        // app/src/main/assets/www/index.html 로 복사 후:
        // web.loadUrl("file:///android_asset/www/index.html")
        web.loadUrl("file:///android_asset/www/index.html")
    }
    override fun onBackPressed() {
        if (::web.isInitialized && web.canGoBack()) web.goBack()
        else super.onBackPressed()
    }
}
