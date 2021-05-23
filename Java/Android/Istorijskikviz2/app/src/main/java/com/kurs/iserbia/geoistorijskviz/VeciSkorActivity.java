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


public class VeciSkorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veci_skor);
        if (getSupportActionBar() != null)
            getSupportActionBar().

                    setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);

        TextView txtScore = (TextView) findViewById(R.id.textScore);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);

        Intent intent = getIntent();
        int score1 = intent.getIntExtra("score", 0);
        txtScore.setText("Vas skor:" + score1);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore1 = mypref.getInt("highscore", 0);
        if (highscore1 >= score1) {
            txtHighScore.setText("Vas najbolji rezultat:" + highscore1);
        } else {
            txtHighScore.setText("Novi najbolji rezultat: " + score1);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score1);
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

    public void onClick(View view) {
        Intent intent = new Intent(VeciSkorActivity.this, LakaPitanja.class);
        startActivity(intent);
    }

    public void onClick1(View view) {
        Intent intent = new Intent(VeciSkorActivity.this, Kviz1.class);
        startActivity(intent);
    }
}