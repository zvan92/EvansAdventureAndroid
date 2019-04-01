package com.example.evansadventureandroid;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class UI {
    UI(final Resources r,
       final TextView tv,
       final EditText et,
       final Button b1,
       final Button b2,
       final Button b3,
       final Button b4,
       final Button b5)
    {
        res = r;
        textView = tv;
        editText = et;
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
    }

    ArrayList<Button> buttons= new ArrayList();
    Resources res;
    TextView textView;
    EditText editText;
}
