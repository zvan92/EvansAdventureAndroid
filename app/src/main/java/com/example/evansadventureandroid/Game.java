package com.example.evansadventureandroid;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Game {
    public static boolean game_in_progress;
    public static String character_name;
    public static int turns_completed;

    public void run(final Resources res,
                    final TextView textView,
                    final EditText editText,
                    final ArrayList<Button> buttons)
    {
        mainMenu(res,
                textView,
                editText,
                buttons);
    }

    private void mainMenu(final Resources res,
                         final TextView textView,
                         final EditText editText,
                         final ArrayList<Button> buttons)
    {
        game_in_progress = false;

        textView.setText(R.string.menu_screen_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(buttons);

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

    private void promptForDirection(final Resources res,
                                   final TextView textView,
                                   final EditText editText,
                                   final ArrayList<Button> buttons)
    {
        game_in_progress = true;

        textView.setText(R.string.prompt_direction_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(buttons);

        //set button5 to return to user choice screen
        buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                promptUserChoice(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }

    private void displayMap(final Resources res,
                           final TextView textView,
                           final EditText editText,
                           final ArrayList<Button> buttons)
    {
        textView.setText(R.string.map_screen_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(buttons);

        //if game in progress, set button5 to go user choice screen
        if(game_in_progress = true)
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

    private void promptUserChoice(final Resources res,
                                 final TextView textView,
                                 final EditText editText,
                                 final ArrayList<Button> buttons)
    {
        game_in_progress = true;

        textView.setText(res.getString(R.string.turns_completed_text) +
                turns_completed +
                res.getString(R.string.user_choice_asking_text) +
                character_name + "?" +
                res.getString(R.string.user_choice_options_text));

        editText.setText(null);
        editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(buttons);

        //set button1 to prompt move direction
        buttons.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                promptForDirection(res,
                        textView,
                        editText,
                        buttons);
            }
        });

        //set button5 to return to main menu
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

    private void exitGame(final Resources res,
                         final TextView textView,
                         final EditText editText,
                         final ArrayList<Button> buttons)
    {
        textView.setText(R.string.exit_game_text);

        editText.setText(null);
        editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(buttons);

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

    private void loadGame(final Resources res,
                         final TextView textView,
                         final EditText editText,
                         final ArrayList<Button> buttons)
    {
        textView.setText(R.string.load_game_text);

        editText.setText(null);
        editText.setText(R.string.location_field_text);
        editText.setVisibility(View.VISIBLE);

        Tools.clearButtonListeners(buttons);

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

    private void newGame(final Resources res,
                        final TextView textView,
                        final EditText editText,
                        final ArrayList<Button> buttons)
    {
        textView.setText(R.string.new_game_text);

        editText.setText(null);
        editText.setText(R.string.name_field_text);
        editText.setVisibility(View.VISIBLE);

        Tools.clearButtonListeners(buttons);

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
                //collect the name entered in the name field and store it as player name
                character_name = editText.getText().toString();
                promptUserChoice(res,
                        textView,
                        editText,
                        buttons);
            }
        });
    }
}
