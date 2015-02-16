package com.example.jeremy.comp7481_as5;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CustomView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new XView(this, null));
    }

}
