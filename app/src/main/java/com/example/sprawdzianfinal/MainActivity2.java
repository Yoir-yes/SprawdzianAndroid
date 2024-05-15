package com.example.sprawdzianfinal;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int[] photos = {R.drawable.ksiazka1,R.drawable.ksiazka2,R.drawable.ksiazka3,R.drawable.ksiazka4,R.drawable.ksiazka5,R.drawable.ksiazka6,R.drawable.ksiazka7};
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String text = bundle.getString("text");
        TextView szczeguly = findViewById(R.id.Autor);
        szczeguly.setText(text);
        Random random = new Random();
        ImageView zdjecie = findViewById(R.id.imageView2);
        zdjecie.setImageResource(photos[random.nextInt(6)]);
    }
}