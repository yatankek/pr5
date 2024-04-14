package com.example.pr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView products_view = (ListView) findViewById(R.id.my_list_view);

        String[] products = getResources().getStringArray(R.array.books);

        ArrayAdapter<String> productsAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, products);

        products_view.setAdapter(productsAdapter);
        products_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = products[position];
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("product", selectedItem);
                startActivity(intent);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });


    }
}