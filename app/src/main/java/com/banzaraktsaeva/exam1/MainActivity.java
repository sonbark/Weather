package com.banzaraktsaeva.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView todayView;
    ListView listView;
    static String today;
    static String[] cities = {"Москва", "Денвер", "Рио", "Токио", "Берлин", "Найроби", "Хельсинки", "Осло"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todayView = (TextView) findViewById(R.id.todayView);
        Date date = new Date();
        today = dateToString(date);
        todayView.setText(today);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_city, cities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String city = textView.getText().toString();

                Intent intent = new Intent(MainActivity.this, City.class);
                intent.putExtra("cityIndex", position);
                startActivity(intent);
            }
        });
    }

    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(date);
    }
}
