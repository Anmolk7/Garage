package com.example.anmol.garage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Auto_Workshops extends AppCompatActivity {
    Spinner spinner,spinner1;
    ArrayAdapter<CharSequence> adapter,adapter1;
    String city_name,area;
    String username;
    String password;
    ListView listView;
    ArrayAdapter<String> adapter2;
    String[] city={"ShreeRam Autoworkshop","Ganesh Bike WorkShop","Mohan's Repair"};



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto__workshops);
       // listView=(ListView)findViewById(R.id.listView);
        //adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
        //listView.setAdapter(adapter2);


        spinner=(Spinner)findViewById(R.id.spinner3);
        spinner1=(Spinner)findViewById(R.id.spinner4);
        adapter=ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                city_name= (String) parent.getItemAtPosition(position);
                //   Toast.makeText(RegisterActivity.this, city_name, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter1=ArrayAdapter.createFromResource(this,R.array.area,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                area= (String) parent.getItemAtPosition(position);
                //   Toast.makeText(RegisterActivity.this, city_name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }
    public void show(View view)
    {
        if(spinner.getSelectedItem().equals("Kathmandu")&&spinner1.getSelectedItem().equals("Old Baneshwor"))
        {
            listView=(ListView)findViewById(R.id.listView);
            adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
            listView.setAdapter(adapter2);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    switch (position)
                    {
                        case 0:
                            startActivity(new Intent(Auto_Workshops.this,Information.class));
                            break;

                        case 1:
                            //Toast.makeText(getApplicationContext(),"Transport",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Auto_Workshops.this,Information.class));
                            break;
                        case 2:
                            //Toast.makeText(getApplicationContext(),"Transport",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Auto_Workshops.this,Information.class));
                            break;
                        case 3:
                            //Toast.makeText(getApplicationContext(),"Transport",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Auto_Workshops.this,Information.class));
                            break;
                    }
                }
            });
        }
    }
public void nearby(View view)
{
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("google.navigation:q=nearest+workshop"));
    startActivity(intent);
}

}
