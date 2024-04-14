package com.example.pr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i = getIntent();

        RecyclerView recyclerView = findViewById(R.id.list);
        //Устанавливает макет отображения - гориозонтально
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Пример списка строк
        List <String> items = Arrays.asList("Мне нравится японская культура. У них интересная история развитися и великолепные достопримечательности", "Я снимал улицу вчера\n" +
                "Я увидел как дерутся коты\n" +
                "Я увидел как улетали птицы\n" +
                "Я снимал всё\n"
                , "А это гигачады");
        List <Integer> items2 = Arrays.asList(R.drawable.based,R.drawable.video,R.drawable.giga);
        //Создаем адаптер
        SimpleAdapter adapter = new SimpleAdapter(items,items2);
        //Устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

    }
}