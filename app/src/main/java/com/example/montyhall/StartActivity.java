package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Écran d'accueil l'utilisateur peut choisir une des trois portes
 */
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // permet de redéfinir la porte gagnante à chaque début de l'activité
        MontyHallApplication application = (MontyHallApplication) getApplication();
        application.setWinningDoor();
    }

    /**
     * Action du clic sur une porte, lance la deuxième vue
     *
     * @param view le bouton cliqué
     */
    public void onDoorSelection(View view) {
        ImageButton porte = (ImageButton) view;
        String porteChoisie = porte.getTag().toString();

        Intent intent = new Intent(this, ChoiceActivity.class);
        intent.putExtra(getString(R.string.choice), Integer.valueOf(porteChoisie));
        startActivity(intent);
        finish();
    }

    /**
     * Action du bouton à propos : ouvre la page wikipedia Monty Hall
     */
    public void getInformationLink(View view) {
        Uri wikipedia = Uri.parse(getString(R.string.wikipedia_monty_hall));
        Intent intent = new Intent(Intent.ACTION_VIEW, wikipedia);
        startActivity(intent);
    }

}
