package com.kurs.iserbia.geoistorijskviz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.kurs.iserbia.istorijskikviz.R;


public class VeciSkorActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veci_skor2);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtScore = (TextView) findViewById(R.id.textScore2);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore2);

        Intent intent = getIntent();
        int score2 = intent.getIntExtra("score", 0);
        txtScore.setText("Vas skor:" + score2);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore2 = mypref.getInt("highscore", 0);
        if (highscore2 >= score2) {
            txtHighScore.setText("Vas najbolji rezultat:" + highscore2);
        } else {
            txtHighScore.setText("Novi najbolji rezultat" + score2);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score2);
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
            Intent intent1 = new Intent(this, Kviz1.class);
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

    public void onClick2(View view) {
        Intent intent = new Intent(VeciSkorActivity2.this, MaloTezaPitanja2.class);
        startActivity(intent);
    }

    public void onClick21(View view) {
        Intent intent = new Intent(VeciSkorActivity2.this, Kviz1.class);
        startActivity(intent);
    }
}