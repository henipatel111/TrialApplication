package com.example.heni.MyApp.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.heni.MyApp.R;

/**
 * Created by heni on 7/9/17.
 */

public class WebViewActivity  extends AppCompatActivity {

    WebView webView;
    boolean isNew = false;
    public static final String WEB_URL = "https://henipatelblog.wordpress.com/";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.my_web_view);
        loadURL();
        setUpWebView();
    }


   /* private void setWebView(){
        webView = (WebView) findViewById(R.id.my_web_view);
        webView.loadUrl("https://henipatelblog.wordpress.com/");
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
    }*/

    private void loadURL() {
        webView.loadUrl(WEB_URL);
    }

    private void setUpWebView() {
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setAllowFileAccess(true);
        webView.setScrollContainer(false);
        webView.setWebViewClient(new WebViewClient());
    }


    private class WebViewClient extends android.webkit.WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            boolean valid = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (isNew == false) {
                    valid = false;
                } else {
                    if (request.getUrl().equals(WEB_URL)) {
                        valid = false;
                    }
                }
            }
            isNew=true;
            return valid;
        }

    }

}
