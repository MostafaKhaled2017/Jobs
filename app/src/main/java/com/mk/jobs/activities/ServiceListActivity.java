package com.mk.jobs.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mk.jobs.R;

/**
 * Created by Mostafa on 7/27/2018.
 */

public class ServiceListActivity extends AppCompatActivity{
    String title;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_service_list);
        Intent intent = getIntent();
        if(intent != null)
            title = intent.getStringExtra("child_name");
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = findViewById(R.id.service_toolbar_title);
        setSupportActionBar(toolbar);
        toolbarTitle.setText(title);//TODO
        toolbarTitle.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
    }
}
