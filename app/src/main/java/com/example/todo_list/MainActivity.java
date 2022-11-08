package com.example.todo_list;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecurityPermission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // variable
   Toolbar all_list ;
   Spinner show_all_list ;
   ArrayList<Store_spinner_element> spinner_list = new ArrayList<>();



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variable
        all_list = findViewById(R.id.All_lists);
        show_all_list = findViewById(R.id.show_all_lists);

        // set Spinner

        spinner_add_element();

        MyAdaptor adaptor = new MyAdaptor(this,R.layout.spinner_layout,spinner_list);

        show_all_list.setAdapter(adaptor);

       show_all_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(position==7)
               {
                   Dialog dialog = new Dialog(MainActivity.this);
                   dialog.setContentView(R.layout.new_list);
                   dialog.show();



               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });






        setSupportActionBar(all_list);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.home_menu,menu);
        menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }




    public void spinner_add_element()
    {
          final int [] spinner_img = new int[8];
          spinner_img[0]=R.drawable.ic_house_solid;
          for(int i=1;i<=7;i++) {
              if(i!=6)
              spinner_img[i] = R.drawable.ic_bars_solid;
              else
              spinner_img[6] = R.drawable.ic_square_check_solid;
          }

        final String [] spinner_name={"All Lists","Default","Personal","Shopping","Wishlist","Work","Finished","New List"};

          for(int i=0;i<8;i++) {
              Store_spinner_element store_spinner_element = new Store_spinner_element(spinner_img[i], spinner_name[i]);
              spinner_list.add(store_spinner_element);
          }




    }
}