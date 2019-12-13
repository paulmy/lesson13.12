package com.example.lesson101220191;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameperson = findViewById(R.id.inputname);

    }

    public void InGame(View view) {
        /*if (nameperson.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Введите имя героя", Toast.LENGTH_SHORT).show();
        } else {*/

        //

        try {
            String name = nameperson.getText().toString();
            if (name.length() > 0) {
                Intent intent = new Intent(MainActivity.this, Game.class);
                intent.putExtra("intentname", name);

                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(), ""+(5/0), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Введите имя героя", Toast.LENGTH_SHORT).show();
        }
    }
}

