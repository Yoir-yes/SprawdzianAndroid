package com.example.sprawdzianfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<String> lista = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1,lista);
        Button button = findViewById(R.id.button);
        ListView listView = findViewById(R.id.ListView);
        EditText autor = findViewById(R.id.autor);
        EditText tytul = findViewById(R.id.tytul);
        button.setOnClickListener((View view) ->{
            String suma = autor.getText().toString() +" "+ tytul.getText().toString();
            lista.add(suma);
            listView.setAdapter(adapter);
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), MainActivity2.class);
                intent.putExtra("text", lista.get(position));
                startActivities(new Intent[]{intent});
            }
        });

    }


}