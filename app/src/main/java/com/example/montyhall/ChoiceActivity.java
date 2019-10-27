package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Écran permettant de choisir entre les deux portes restantes : on garde ou on change de porte.
 */
public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    @Override
    protected void onStart() {
        super.onStart();

        int choosenDoor = getIntent().getIntExtra("porte_choisie", 0);

        MontyHallApplication application = (MontyHallApplication) getApplication();
        List<Integer> doors = application.getDoors(choosenDoor);

        TextView firstDoorText = findViewById(R.id.first_door_text);
        ImageButton firstDoor = findViewById(R.id.first_door);
        firstDoor.setTag(doors.get(0));
        firstDoorText.setText(application.getDoorText(doors.get(0)));

        TextView secondDoorText = findViewById(R.id.second_door_text);
        ImageButton secondDoor = findViewById(R.id.second_door);
        secondDoor.setTag(doors.get(1));
        secondDoorText.setText(application.getDoorText(doors.get(1)));
    }

    public void onDoorSelection(View view) {
        ImageButton porte = (ImageButton) view;
        String porteChoisie = porte.getTag().toString();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("porte_choisie", Integer.valueOf(porteChoisie));
        startActivity(intent);
        finish();
    }
}
