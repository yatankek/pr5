package com.example.pr5;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    public static <T> List<T> convertArrayToList(T array[])

    {

        List<T> list = Arrays.asList(array);

        return list;

    }
    ArrayList<String> users = new ArrayList<String>();
    ArrayList<String> selectedUsers = new ArrayList<String>();
    ArrayAdapter<String> productsAdapter;
    ListView products_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // считываем сообщение с прошлого intent,
        // чтобы далее можно было определить что выводить в Activity

        Intent i = getIntent();
        String str = i.getStringExtra("product");
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();

        // объявляем строковый массив, который далее будем
        // переопределять в зависимости от выбора пользователя
        String[] products2;

        // проверяем какую категорию выбрал пользователь
        // и в зависимости от этого меняем содержимое  будущего ListView
        switch (str) {
            case "Манга":
                products2 = getResources().getStringArray(R.array.Manga);
                break;
            case "Лайт новелла":
                products2 = getResources().getStringArray(R.array.LN);
                break;
            case "Веб новелла":
                products2 = getResources().getStringArray(R.array.VN);
                break;
            default:
                products2 = getResources().getStringArray(R.array.books);
        }

        //создаём ListView
        ListView products_view = (ListView) findViewById(R.id.my_list_view2);

        // Преобразуем строковый массив в список, чтобы можно было добавлять элементы.
        // Иначе будет ошибка, потому что в массив нельзя ничего добавлять
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, products2);

        // создаём adapter
        productsAdapter = new ArrayAdapter
                (this, android.R.layout.simple_list_item_multiple_choice, list);

        //устанавливаем adapter
        products_view.setAdapter(productsAdapter);

        products_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String user = productsAdapter.getItem(position);
                if(products_view.isItemChecked(position))
                    selectedUsers.add(user);




            }
        });


    }
    public void add(View view){

        EditText userName = findViewById(R.id.editTextText);
        String user = userName.getText().toString();
        productsAdapter.add(user);

    }

    public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int k =0; k < selectedUsers.size();k++){
            productsAdapter.remove(selectedUsers.get(k));
        }
        selectedUsers.clear();
    }

    public void second(View view) {
        Intent s_intent = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(s_intent);

    }
    public void third(View view) {
        Intent third_intent = new Intent(MainActivity2.this, ScrollView.class);
        startActivity(third_intent);

    }
    public void fifth(View view) {
        Intent fifth_intent = new Intent(MainActivity2.this, cl_Spinner.class);
        startActivity(fifth_intent);

    }


}