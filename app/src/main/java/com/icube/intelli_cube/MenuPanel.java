package com.icube.intelli_cube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPanel extends AppCompatActivity {

    Button btnNewCube;
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnNewCube = (Button) findViewById(R.id.btnNewCube);
        btnSettings = (Button) findViewById(R.id.btnSettings);

        btnNewCube.setOnClickListener(newCubeClick);
        btnSettings.setOnClickListener(settingsClick);


    }

    View.OnClickListener newCubeClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Go to the main activity // todo: new panel here
            final Intent intent = new Intent(MenuPanel.this, UploadCubePanel.class);
            startActivity(intent);

        }
    };

    View.OnClickListener settingsClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO: chnage this to open a settings panel and in the settings panel allow to open control panel ...
            final Intent intent = new Intent(MenuPanel.this, SettingsPanel.class);
            startActivity(intent);
        }
    };
}
