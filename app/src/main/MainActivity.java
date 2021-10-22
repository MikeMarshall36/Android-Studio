package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox cnb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        cnb = findViewById(R.id.check);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(R.id.group1, cnb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        StringBuilder sb = new StringBuilder();
        sb.append("Item Menu");
        String order;
        order = String.valueOf(item.getOrder());
        if (order == "9"){
            System.exit(0);
        } else {
            sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
            sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
            sb.append("\r\n order: " + String.valueOf(item.getOrder()));
            sb.append("\r\n title: " + item.getTitle());
            tv.setText(sb.toString());
        }
        return super.onOptionsItemSelected(item);

    }

}
