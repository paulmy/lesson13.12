package com.example.lesson101220191;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {
    public static Character manager;
    public static Story story;
    String name;
    TextView textstory, textView;
    Button[] buttons = new Button[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        name = getIntent().getStringExtra("intentname");
        textstory = findViewById(R.id.textstory);
        textView = findViewById(R.id.textView);
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        for (Button b : buttons) {
            b.setOnClickListener(this);
        }

        textstory.setText("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n "
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        manager = new Character(name);


    }

    public void GameStory(Story story, int k) {
        while (true) {
            manager.A += story.current_situation.dA;
            manager.K += story.current_situation.dK;
            manager.R += story.current_situation.dR;
            textView.setText("=====\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n=====");
            textstory.setText("============="
                    + story.current_situation.subject + "==============");
            textstory.append("\n" + story.current_situation.text);
            if (story.isEnd()) {
               // textstory.setText("====================the end!===================");
                return;
            }
            story.go(k);
        }
    }

    @Override
    public void onClick(View v) {
        story = new Story();
        switch (v.getId()) {
            case R.id.btn1:
                GameStory(story, 1);
                break;
            case R.id.btn2:
                GameStory(story, 2);
                break;
            case R.id.btn3:
                GameStory(story, 3);
                break;

        }


    }


}
