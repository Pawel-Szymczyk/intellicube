package com.icube.intelli_cube;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ConfigPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_panel);

        // Adds subtitle to action bar...
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Configuration");

        actionBar.setSubtitle("Stores data needed to connection...");
    }
}
