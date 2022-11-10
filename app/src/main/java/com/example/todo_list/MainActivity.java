package com.example.todo_list;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // variable
   Toolbar all_list ;
   Spinner show_all_list ;
   ImageView round_tick_img;
   LinearLayout all_list_ll;
   TextView all_list_tv;
   ArrayList<Store_spinner_element> spinner_list = new ArrayList<>();



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variable
        all_list = findViewById(R.id.All_lists);
        show_all_list = findViewById(R.id.show_all_lists);
        round_tick_img =  findViewById(R.id.round_tick_img);
        all_list_ll = findViewById(R.id.all_list_ll);
        all_list_tv = findViewById(R.id.all_list_tv);

        // set Spinner

        spinner_add_element();

        MyAdaptor adaptor = new MyAdaptor(this,R.layout.spinner_layout,spinner_list);

        show_all_list.setAdapter(adaptor);

       show_all_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               all_list_tv.setText(spinner_list.get(position).spinner_name);
               if(position==7)
               {
                   Dialog dialog = new Dialog(MainActivity.this);
                   dialog.setContentView(R.layout.new_list);
                   dialog.show();
                   TextView add,cancel;
                   EditText editText;
                   add =dialog.findViewById(R.id.add_txt_dialog);
                   cancel = dialog.findViewById(R.id.cancel_txt_dialog);
                   editText = dialog.findViewById(R.id.Dialog_EditText);
                   cancel.setOnClickListener(v -> dialog.dismiss());
                   add.setOnClickListener(v -> {
                       String new_list_name = editText.getText().toString();
                       if(new_list_name.length()==0)
                           Toast.makeText(MainActivity.this, "Input new list name", Toast.LENGTH_SHORT).show();
                       else
                       {
                           Store_spinner_element store_spinner_element = new Store_spinner_element(R.drawable.ic_bars_solid,new_list_name);
                           spinner_list.add(store_spinner_element);
                           adaptor.notifyDataSetChanged();
                           Toast.makeText(MainActivity.this, "List added", Toast.LENGTH_SHORT).show();
                           all_list_tv.setText(new_list_name);
                           dialog.dismiss();


                       }
                   });



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
        all_list_ll.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
            show_all_list.performClick();
        });
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