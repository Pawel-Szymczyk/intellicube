package com.icube.intelli_cube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsPanel extends AppCompatActivity {

    Button btnGeneral;
    Button btnControlPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_panel);

        btnGeneral = (Button) findViewById(R.id.btnGeneral);
        btnControlPanel = (Button) findViewById(R.id.btnControlPanel);

        btnGeneral.setOnClickListener(btnGeneralClick);
        btnControlPanel.setOnClickListener(btnControlPanelClick);
    }

    View.OnClickListener btnGeneralClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO: use settings activity to create rest of options here ... ?
        }

    };

    View.OnClickListener btnControlPanelClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(SettingsPanel.this, ControlPanel.class);
            startActivity(intent);
        }
    };
}
