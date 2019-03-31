package com.example.evansadventureandroid;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evansadventureandroid.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        TextView myTextView = findViewById(R.id.mainTextView);
        EditText editText = findViewById(R.id.editText);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        ArrayList<Button> buttons = new ArrayList();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);

        mainMenu(res, myTextView, editText, buttons);
    }
    
    private void clearButtonListeners(ArrayList<Button> buttons)
    {
        for (int i = 0; i < buttons.size(); i++)
        {
            buttons.get(i).setOnClickListener(null);
        }
    }

    public void mainMenu(final Resources res,
                         final TextView textView,
                         final EditText editText,
                         final ArrayList<Button> buttons)
    {
        Game.game_in_progress = false;
        
        textView.setText(R.string.menu_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        clearButtonListeners(buttons);

        //set main menu button1 to new game
        buttons.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                newGame(res,
                        textView,
                        editText,
                        buttons);
            }
        });

        //set main menu button2 to load game
        buttons.get(1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                loadGame(res,
                        textView,
                        editText,
                        buttons);
            }
        });

        //set main menu button3 to exit game
        buttons.get(2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                exitGame(res,
                        textView,
                        editText,
                        buttons);
            }
        });

        //set main menu button4 to display map
        buttons.get(3).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                displayMap(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }

    public void newGame(final Resources res,
                        final TextView textView,
                        final EditText editText,
                        final ArrayList<Button> buttons)
    {
        textView.setText(R.string.new_game_text);

        editText.setText(null);
        editText.setText(R.string.name_field_text);
        editText.setVisibility(View.VISIBLE);

        clearButtonListeners(buttons);

        //set new game button5 to main menu
        buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(res,
                        textView,
                        editText,
                        buttons);
            }
        });

        //set new game button1 to confirm
        buttons.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                promptUserChoice(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }

    public void loadGame(final Resources res,
                         final TextView textView,
                         final EditText editText,
                         final ArrayList<Button> buttons)
    {
        textView.setText(R.string.load_game_text);

        editText.setText(null);
        editText.setText(R.string.location_field_text);
        editText.setVisibility(View.VISIBLE);

        clearButtonListeners(buttons);

        //set load game button5 to main menu
        buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }

    public void exitGame(final Resources res,
                         final TextView textView,
                         final EditText editText,
                         final ArrayList<Button> buttons)
    {
        textView.setText(R.string.exit_game_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        clearButtonListeners(buttons);

        //set exit game button5 to main menu
        buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }

    public void displayMap(final Resources res,
                           final TextView textView,
                           final EditText editText,
                           final ArrayList<Button> buttons)
    {
        textView.setText(R.string.map_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        clearButtonListeners(buttons);

        //if game in progress, set button5 to go user choice screen
        if(Game.game_in_progress = true)
        {
            buttons.get(4).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    promptUserChoice(res,
                            textView,
                            editText,
                            buttons);
                }
            });
        }
        else
        {
            //if game not in progress, set button5 to go to main menu
            buttons.get(4).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    mainMenu(res,
                            textView,
                            editText,
                            buttons);
                }
            });
        }

    }

    public void promptUserChoice(final Resources res,
                                 final TextView textView,
                                 final EditText editText,
                                 final ArrayList<Button> buttons)
    {
        Game.game_in_progress = true;

        textView.setText(R.string.user_choice_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        clearButtonListeners(buttons);

        //set exit game button5 to main menu
        buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(res,
                        textView,
                        editText,
                        buttons);
            }
        });

        //set button3 to display map
        buttons.get(2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                displayMap(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }
}