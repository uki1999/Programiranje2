package com.kurs.iserbia.geoistorijskviz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 23-May-17.
 */

public class Zanimljivosti extends AppCompatActivity {

    TextView textZanim;
    RelativeLayout bg;
    zanimljivosti1 zanimljivosti12 = new zanimljivosti1();
    background back = new background();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zanimljivosti);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        textZanim = (TextView) findViewById(R.id.textZanim);
        bg = (RelativeLayout) findViewById(R.id.bg2);
        bg.setBackgroundColor(getResources().getColor(back.getBackground()));
        bg.setOnTouchListener(new OnSwipeTouchListener(this) {

            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                prev();
            }

            public void onSwipeLeft() {
                next();
            }

            public void onSwipeBottom() {

            }

            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
    }


    private void prev() {
        textZanim.setText(zanimljivosti12.prevFact());
        bg.setBackgroundColor(getResources().getColor(back.getBackground()));
    }

    private void next() {
        textZanim.setText(zanimljivosti12.nextFacts());
        bg.setBackgroundColor(getResources().getColor(back.getBackground()));
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
    public void klik1(View view) {
        next();
        }
    }