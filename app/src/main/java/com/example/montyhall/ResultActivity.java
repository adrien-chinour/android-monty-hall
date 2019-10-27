package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Écran final affichant le résultat : gagnant ou perdant
 */
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView title = findViewById(R.id.title_result);
        ImageView image = findViewById(R.id.image_result);
        MontyHallApplication application = (MontyHallApplication) getApplication();

        if (getIntent().getIntExtra(getString(R.string.choice), 0) == application.getWinningDoor()) {
            title.setText(getString(R.string.win_message));
            image.setImageResource(R.drawable.jeep);
        } else {
            title.setText(getString(R.string.lose_message));
            image.setImageResource(R.drawable.chevre);

        }
    }

    public void replay(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
