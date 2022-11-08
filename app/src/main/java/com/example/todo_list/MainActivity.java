package com.example.todo_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    // variable
   Toolbar all_list ;
   LinearLayout show_all_list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variable
        all_list = findViewById(R.id.All_lists);
        show_all_list = findViewById(R.id.show_all_lists);
        setSupportActionBar(all_list);

    }
}