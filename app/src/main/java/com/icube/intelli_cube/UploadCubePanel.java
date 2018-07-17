package com.icube.intelli_cube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UploadCubePanel extends AppCompatActivity {

    EditText txtCubeName;

    Button btn_cancel;
    Button btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_cube_panel);

        txtCubeName = (EditText) findViewById(R.id.txtCubeName);
        btn_accept = (Button) findViewById(R.id.btn_accept);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        btn_accept.setOnClickListener(acceptClick);
        btn_cancel.setOnClickListener(cancelClick);

    }

    // Save changes and go to the cube panel...
    // Adds shortcut button to menu...
    View.OnClickListener acceptClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    // Cancel action and go back to menu...
    View.OnClickListener cancelClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent intent = new Intent(UploadCubePanel.this, MenuPanel.class);
            startActivity(intent);
        }
    };




}
