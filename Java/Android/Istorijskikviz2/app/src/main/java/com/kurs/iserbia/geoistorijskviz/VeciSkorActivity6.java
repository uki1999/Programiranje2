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

public class VeciSkorActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veci_skor6);
        if (getSupportActionBar() != null)
            getSupportActionBar().

                    setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);

        TextView txtScore = (TextView) findViewById(R.id.textScore6);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore6);

        Intent intent = getIntent();
        int score7 = intent.getIntExtra("score", 0);
        txtScore.setText("Vas skor:" + score7);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore7 = mypref.getInt("highscore", 0);
        if (highscore7 >= score7) {
            txtHighScore.setText("Vas najbolji rezultat:" + highscore7);
        } else {
            txtHighScore.setText("Novi najbolji rezultat: " + score7);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score7);
            editor.commit();
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

    public void onClick6(View view) {
        Intent intent = new Intent(VeciSkorActivity6.this, NajtezaPitanjaGeografija.class);
        startActivity(intent);
    }

    public void onClick61(View view) {
        Intent intent = new Intent(VeciSkorActivity6.this, Kviz2.class);
        startActivity(intent);
    }
}

