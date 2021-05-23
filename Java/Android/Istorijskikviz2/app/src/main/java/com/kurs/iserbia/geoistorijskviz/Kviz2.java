package com.kurs.iserbia.geoistorijskviz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 16-May-17.
 */

public class Kviz2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kviz2);
        if(getSupportActionBar()!=null)
            getSupportActionBar().

                    setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);
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
            Intent intent1 = new Intent(this, Main3.class);
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
    public void easyMode2(View view) {
        Intent intent = new Intent(Kviz2.this,LakaPitanjaGeografija.class);
        startActivity(intent);
    }

    public void mediumMode2(View view) {
        Intent intent2 = new Intent(Kviz2.this,MaloTezaPitanjaGeografija.class);
        startActivity(intent2);
    }

    public void hardMode2(View view) {
        Intent intent3 = new Intent(Kviz2.this,NajtezaPitanjaGeografija.class);
        startActivity(intent3);
    }
}

