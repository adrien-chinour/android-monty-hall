package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Collections;
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

        // récupération du choix de l'utilisateur
        int choosenDoor = getIntent().getIntExtra(getString(R.string.choice), 0);

        // calcul des portes à garder
        MontyHallApplication application = (MontyHallApplication) getApplication();
        List<Integer> doors = application.getDoors(choosenDoor);
        Collections.sort(doors); // pour afficher les portes dans le bon ordre


        // ajout du contenu a chaque porte
        addContentDoor(R.id.first_door, R.id.first_door_text, doors.get(0));
        addContentDoor(R.id.second_door, R.id.second_door_text, doors.get(1));
    }

    /**
     * Action du clic sur une porte, lance la troisième vue
     *
     * @param view le bouton cliqué
     */
    public void onDoorSelection(View view) {
        ImageButton porte = (ImageButton) view;
        String porteChoisie = porte.getTag().toString();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.choice), Integer.valueOf(porteChoisie));
        startActivity(intent);
        finish(); // evite le retour arrière dans l'application
    }

    /**
     * Permet de définir le contenu de chaque porte  lors du start de l'activité
     *
     * @param doorId     l'identifiant de l'élément ImageView de la porte
     * @param doorTextId l'identifiant de l'élément TextView de la porte
     * @param doorNumber le numéro de la porte
     */
    private void addContentDoor(int doorId, int doorTextId, int doorNumber) {
        MontyHallApplication application = (MontyHallApplication) getApplication();

        TextView doorText = findViewById(doorTextId);
        ImageButton door = findViewById(doorId);
        door.setTag(doorNumber);
        doorText.setText(application.getDoorText(doorNumber));

        if (doorNumber == getIntent().getIntExtra(getString(R.string.choice), 0)) {
            door.setImageResource(R.drawable.door_open);
        }
    }
}
