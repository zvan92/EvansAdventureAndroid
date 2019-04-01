package com.example.evansadventureandroid;

import android.view.View;

public class Game {
    public static boolean game_in_progress;
    public static String character_name;
    public static int turns_completed;

    public void run(final UI ui)
    {
        mainMenu(ui);
    }

    private void mainMenu(final UI ui)
    {
        game_in_progress = false;

        ui.textView.setText(R.string.menu_screen_text);

        ui.editText.setText(null);
        ui.editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(ui.buttons);

        //set main menu button1 to new game
        ui.buttons.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                newGame(ui);
            }
        });

        //set main menu button2 to load game
        ui.buttons.get(1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                loadGame(ui);
            }
        });

        //set main menu button3 to exit game
        ui.buttons.get(2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                exitGame(ui);
            }
        });

        //set main menu button4 to display map
        ui.buttons.get(3).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                displayMap(ui);
            }
        });
    }

    private void promptForDirection(final UI ui)
    {
        game_in_progress = true;

        ui.textView.setText(R.string.prompt_direction_text);

        ui.editText.setText(null);
        ui.editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(ui.buttons);

        //set button5 to return to user choice screen
        ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                promptUserChoice(ui);
            }
        });
    }

    private void displayMap(final UI ui)
    {
        ui.textView.setText(R.string.map_screen_text);

        ui.editText.setText(null);
        ui.editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(ui.buttons);

        //if game in progress, set button5 to go user choice screen
        if(game_in_progress = true)
        {
            ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    promptUserChoice(ui);
                }
            });
        }
        else
        {
            //if game not in progress, set button5 to go to main menu
            ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    mainMenu(ui);
                }
            });
        }

    }

    private void promptUserChoice(final UI ui)
    {
        game_in_progress = true;

        ui.textView.setText(ui.res.getString(R.string.turns_completed_text) +
                turns_completed +
                ui.res.getString(R.string.user_choice_asking_text) +
                character_name + "?" +
                ui.res.getString(R.string.user_choice_options_text));

        ui.editText.setText(null);
        ui.editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(ui.buttons);

        //set button1 to prompt move direction
        ui.buttons.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                promptForDirection(ui);
            }
        });

        //set button5 to return to main menu
        ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(ui);
            }
        });

        //set button3 to display map
        ui.buttons.get(2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                displayMap(ui);
            }
        });
    }

    private void exitGame(final UI ui)
    {
        ui.textView.setText(R.string.exit_game_text);

        ui.editText.setText(null);
        ui.editText.setVisibility(View.GONE);

        Tools.clearButtonListeners(ui.buttons);

        //set exit game button5 to main menu
        ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(ui);
            }
        });
    }

    private void loadGame(final UI ui)
    {
        ui.textView.setText(R.string.load_game_text);

        ui.editText.setText(null);
        ui.editText.setText(R.string.location_field_text);
        ui.editText.setVisibility(View.VISIBLE);

        Tools.clearButtonListeners(ui.buttons);

        //set load game button5 to main menu
        ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(ui);
            }
        });
    }

    private void newGame(final UI ui)
    {
        ui.textView.setText(R.string.new_game_text);

        ui.editText.setText(null);
        ui.editText.setText(R.string.name_field_text);
        ui.editText.setVisibility(View.VISIBLE);

        Tools.clearButtonListeners(ui.buttons);

        //set new game button5 to main menu
        ui.buttons.get(4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mainMenu(ui);
            }
        });

        //set new game button1 to confirm
        ui.buttons.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //collect the name entered in the name field and store it as player name
                character_name = ui.editText.getText().toString();
                promptUserChoice(ui);
            }
        });
    }
}
