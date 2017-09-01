package com.example.heni.MyApp.utilities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.heni.MyApp.R;

/**
 * Created by heni on 21/8/17.
 */

public class WebTab extends AppCompatActivity {
    public static final String EXTRA_URL = "URL";
    public static final String EXTRA_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_tab);
    }

}
