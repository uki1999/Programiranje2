package com.kurs.iserbia.geoistorijskviz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.kurs.iserbia.istorijskikviz.R;

import br.com.bloder.magic.view.MagicButton;

/**
 * Created by Uroš on 22-May-17.
 */

public class oKvizu extends AppCompatActivity {

    MagicButton magicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okvizu);

        magicButton = (MagicButton)findViewById(R.id.magic_button);

        magicButton.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iserbia.rs/"));
                startActivity(in);
                 }
            });

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}