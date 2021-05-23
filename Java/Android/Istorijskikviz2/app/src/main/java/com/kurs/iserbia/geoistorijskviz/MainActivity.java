package com.kurs.iserbia.geoistorijskviz;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kurs.iserbia.istorijskikviz.R;

import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity implements DijalogFramgent.Interfejs {

    GifTextView logoView;
    Button izadji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoView = (GifTextView) findViewById(R.id.logo);
        logoView.setOnClickListener(imgButtonHandler);

        izadji = (Button) findViewById(R.id.button35);
        izadji.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DijalogFramgent df = new DijalogFramgent();
                df.show(getFragmentManager(), "Dijalog");
            }
        });
    }

    @Override
    public void kliknoOk() {
        Toast.makeText(this, "Izasli ste iz aplikacije", Toast.LENGTH_LONG).show();
        /**izaci iz igrice ovako
         * pomocu metode intent i dodajemo CATEGORY_HOME
         * postavljamo flag i intent setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
         * I samo zapoceti aktivnost
         * ali prvo finish();
         * i System.exit(0);
         */
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);

    }
    @Override
    public void kliknoJok() {
        Toast.makeText(this, "Niste napustili aplikaciju", Toast.LENGTH_LONG).show();
    }
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            logoView.setBackgroundResource(R.drawable.potpis);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meni, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
    public void pocnikviz(View view) {
        Intent i = new Intent(MainActivity.this, Main3.class);
        startActivity(i);
    }
    public void zanimljivosti(View view) {
        Intent intent = new Intent(MainActivity.this,Zanimljivosti.class);
        startActivity(intent);
    }

    }

}




