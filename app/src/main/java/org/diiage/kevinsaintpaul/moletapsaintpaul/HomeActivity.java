package org.diiage.kevinsaintpaul.moletapsaintpaul;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Model.Score;
import Model.Session;

public class HomeActivity extends AppCompatActivity {

    private Score score;
    private Session session;
    private EditText namePlayer;
    private Button newGameButton;
    private Button scoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newGameButton = findViewById(R.id.btnNewGame);
        scoreButton = findViewById(R.id.btnScores);

        namePlayer = findViewById(R.id.txtName);

        session = new Session();
    }

    public void BtnNewPartie_OnClick(View view) {
        if(namePlayer.getText().toString() == ""){
            AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
            builder.setTitle("Erreur")
                    .setMessage("Veuillez mettre votre nom")
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
            return;
        }

        score = new Score(namePlayer.getText().toString());

        Intent intent = new Intent(this, GameActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("score", score);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void ScoreButton_OnClick(View view) {
        Intent intent = new Intent(this, ScoreActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("session", session);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
