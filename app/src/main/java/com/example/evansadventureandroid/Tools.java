package com.example.evansadventureandroid;

import android.widget.Button;

import java.util.ArrayList;

public class Tools {
    public static void clearButtonListeners(ArrayList<Button> buttons)
    {
        for (int i = 0; i < buttons.size(); i++)
        {
            buttons.get(i).setOnClickListener(null);
        }
    }
}
