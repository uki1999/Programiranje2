package com.kurs.iserbia.geoistorijskviz;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kurs.iserbia.istorijskikviz.R;

import java.util.Random;

/**
 * Created by Uroš on 21-May-17.
 */

public class LakaPitanjaGeografija extends AppCompatActivity {
    private lakaPitanjaGeografija1 mQuestionLibary4 = new lakaPitanjaGeografija1();
    private TextView mScoreView;
    private TextView mScoreView2;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private ImageView imageView4;

    private String mAnswer4;
    private int mScore700 = 0;
    private int mScore7 = 0;
    private int mQuestionNumber4 = 0;
    Random rn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laka_pitanja_geografija);
        rn = new Random();
        int rn = (int)(Math.random()*10);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mScoreView = (TextView) findViewById(R.id.score7);
        mScoreView2 = (TextView) findViewById(R.id.score700);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        mButtonChoice1 = (Button) findViewById(R.id.choice131);
        mButtonChoice2 = (Button) findViewById(R.id.choice241);
        mButtonChoice3 = (Button) findViewById(R.id.choice351);
        mButtonChoice4 = (Button) findViewById(R.id.choice461);
        updateQuestion();

        updateScore(mScore7);
        updateScore(mScore700);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meni, menu);
        return true;

    }

    private void updateQuestion() {
        if (mQuestionNumber4 < mQuestionLibary4.getLength()) {
            imageView4.setImageResource(mQuestionLibary4.getFlags(mQuestionNumber4));
            mButtonChoice1.setText(mQuestionLibary4.getChoices4(mQuestionNumber4, 1));
            mButtonChoice2.setText(mQuestionLibary4.getChoices4(mQuestionNumber4, 2));
            mButtonChoice3.setText(mQuestionLibary4.getChoices4(mQuestionNumber4, 3));
            mButtonChoice4.setText(mQuestionLibary4.getChoices4(mQuestionNumber4, 4));
            mAnswer4 = mQuestionLibary4.getCorrectAnswers4(mQuestionNumber4);
            mQuestionNumber4++;
        }else{
            NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(LakaPitanjaGeografija.this)
                    .setSmallIcon(android.R.drawable.stat_notify_error)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("Kako si uradio?")
                    .setContentText("Tvoj rezultat na ovom delu kviza je: " + mScore700);
            notificationBuilder.setAutoCancel(true);
            notificationBuilder.setDefaults(
                    Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(LakaPitanjaGeografija.this);
            notificationManager.notify(1, notificationBuilder.build());
            Intent toLaunch = new Intent(getApplicationContext(), Kviz2.class);
            toLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent intentBack =
                    PendingIntent.getActivity(getApplicationContext(), 0, toLaunch, 0);
            notificationBuilder.setContentIntent(intentBack);
            NotificationManager menadzer = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
            menadzer.notify(1, notificationBuilder.build());

            Toast.makeText(LakaPitanjaGeografija.this, "Vas rezultat je:"+ mScore7, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LakaPitanjaGeografija.this, VeciSkorActivity4.class);
            intent.putExtra("score", mScore7); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore7 + "/" + mQuestionLibary4.getLength());
        mScoreView2.setText(String.valueOf(mScore700));

    }

    public void onClick(View view) {
        //Logic for all answers on quiz
        Button answer = (Button) view;
        final MediaPlayer mp = MediaPlayer.create(LakaPitanjaGeografija.this, R.raw.true_sound);
        final MediaPlayer mp2 = MediaPlayer.create(LakaPitanjaGeografija.this,R.raw.false_sound);

        if (answer.getText() == mAnswer4) {
            mScore7 = mScore7 + 1;
            mScore700 = mScore700 + 1;
            Toast.makeText(LakaPitanjaGeografija.this, "Super!", Toast.LENGTH_SHORT).show();
            updateScore(mScore7);
            mp.start();
            updateQuestion();
        } else {
            Toast.makeText(LakaPitanjaGeografija.this, "Greska!", Toast.LENGTH_SHORT).show();
            updateScore(mScore7);
            mp2.start();
            updateQuestion();
        }
    }
    public void rezultat(View view){
        Intent inte = new Intent(this,LakaPitanja.class);
        startActivity(inte);
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
}
