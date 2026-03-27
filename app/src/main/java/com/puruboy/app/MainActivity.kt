package com.puruboy.app

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var offlineLayout: View
    private val targetUrl = "https://puruboy-api.vercel.app/page/purtv-donghua"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        offlineLayout = findViewById(R.id.offlineLayout)
        val btnRetry = findViewById<Button>(R.id.btnRetry)

        setupWebView()
        checkConnectionAndLoad()

        btnRetry.setOnClickListener {
            checkConnectionAndLoad()
        }
    }

    private fun setupWebView() {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                showOffline()
            }
        }
    }

    private fun checkConnectionAndLoad() {
        if (isNetworkAvailable()) {
            webView.visibility = View.VISIBLE
            offlineLayout.visibility = View.GONE
            webView.loadUrl(targetUrl)
        } else {
            showOffline()
        }
    }

    private fun showOffline() {
        webView.visibility = View.GONE
        offlineLayout.visibility = View.VISIBLE
    }

    private fun isNetworkAvailable(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo?.isConnected == true
    }
}
