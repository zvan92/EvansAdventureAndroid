package com.example.evansadventureandroid;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create View references
        Resources res = getResources();
        TextView myTextView = findViewById(R.id.mainTextView);
        EditText editText = findViewById(R.id.editText);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        //create UI object and pass View references to its constructor
        UI ui = new UI(res, myTextView, editText, button1, button2, button3, button4, button5);

        //create and run game instance, passing in UI object
        Game game = new Game();
        game.run(ui);
    }
    















}