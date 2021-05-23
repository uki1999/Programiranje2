package com.kurs.iserbia.geoistorijskviz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 24-May-17.
 */

public class VeciSkorActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veci_skor5);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtScore = (TextView) findViewById(R.id.textScore5);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore5);

        Intent intent = getIntent();
        int score8 = intent.getIntExtra("score", 0);
        txtScore.setText("Vas skor:" + score8);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore8 = mypref.getInt("highscore", 0);
        if (highscore8 >= score8) {
            txtHighScore.setText("Vas najbolji rezultat:" + highscore8);
        } else {
            txtHighScore.setText("Novi najbolji rezultat: " + score8);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score8);
            editor.apply();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meni, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent1 = new Intent(this, Kviz2.class);
            startActivity(intent1);
            this.finish();

            return super.onOptionsItemSelected(item);
        }
        switch (item.getItemId()) {
            case R.id.oKvizu:
                Intent intent1 = new Intent(this, oKvizu.class);
                startActivity(intent1);
                return true;
            case R.id.feedback:
                Intent intent2 = new Intent(this, feedback.class);
                startActivity(intent2);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick5(View view) {
        Intent intent = new Intent(VeciSkorActivity5.this, MaloTezaPitanjaGeografija.class);
        startActivity(intent);
    }

    public void onClick51(View view) {
        Intent intent = new Intent(VeciSkorActivity5.this, Kviz2.class);
        startActivity(intent);
    }
}


