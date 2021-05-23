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

public class Kviz1 extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kviz1);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meni, menu);
        return true;

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.oKvizu:
                Intent intent1 = new Intent(this, oKvizu.class);
                startActivity(intent1);
                return true;
            case R.id.feedback:
                Intent intent2 = new Intent(this, feedback.class);
                startActivity(intent2);
                return true;
                default:
            return super.onOptionsItemSelected(item);
        } }
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
    public void easyMode(View view) {
        Intent intenti = new Intent(Kviz1.this, LakaPitanja.class);
        startActivity(intenti);
    }

    public void mediumMode(View view) {
        Intent intent2 = new Intent(Kviz1.this, MaloTezaPitanja2.class);
        startActivity(intent2);
    }

    public void hardMode(View view) {
        Intent intent2 = new Intent(Kviz1.this, NajtezaPitanjaIstorija2.class);
        startActivity(intent2);
    }
}

