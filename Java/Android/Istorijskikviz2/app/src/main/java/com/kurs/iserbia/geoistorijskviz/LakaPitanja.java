package com.kurs.iserbia.geoistorijskviz;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import com.kurs.iserbia.istorijskikviz.R;

import java.util.Random;

/**
 * Created by Uroš on 17-May-17.
 */

public class LakaPitanja extends AppCompatActivity {

    private Pitanjaistorijalaksaverzija mQuestionLibary = new Pitanjaistorijalaksaverzija();
    private TextView mScoreView;
    private TextView mScoreView2;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;


    private String mAnswer;
    private int mScore100 = 0;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    Random rn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laksa_pitanja);
        rn = new Random();
        if (getSupportActionBar() != null)
            getSupportActionBar().

                    setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);

        mScoreView = (TextView) findViewById(R.id.score);
        mScoreView2 = (TextView) findViewById(R.id.score100);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        updateQuestion();

        updateScore(mScore);
        updateScore(mScore100);

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

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibary.getLength()) {
            mQuestionView.setText(mQuestionLibary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }else{
            NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(LakaPitanja.this)
                    .setSmallIcon(android.R.drawable.stat_notify_error)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("Kako si uradio?")
                    .setContentText("Tvoj rezultat na ovom delu kviza je: " + mScore100);
            notificationBuilder.setAutoCancel(true);
            notificationBuilder.setDefaults(
                    Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(LakaPitanja.this);
            notificationManager.notify(1, notificationBuilder.build());
            Intent toLaunch = new Intent(getApplicationContext(), Kviz1.class);
            toLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent intentBack =
                    PendingIntent.getActivity(getApplicationContext(), 0, toLaunch, 0);
            notificationBuilder.setContentIntent(intentBack);
            NotificationManager menadzer = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
            menadzer.notify(1, notificationBuilder.build());

            Toast.makeText(LakaPitanja.this, "Vas rezultat je:"+ mScore, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LakaPitanja.this, VeciSkorActivity.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
    }
}

    private void updateScore(int point) {
        mScoreView.setText("" + mScore + "/" + mQuestionLibary.getLength());
        mScoreView2.setText(String.valueOf(mScore100));


    }

    public void onClick(View view) {
        //Logic for all answers on quiz
        Button answer = (Button) view;
        final MediaPlayer mp = MediaPlayer.create(LakaPitanja.this, R.raw.true_sound);
        final MediaPlayer mp2 = MediaPlayer.create(LakaPitanja.this,R.raw.false_sound);

        if (answer.getText() == mAnswer) {
            mScore = mScore + 1;
            mScore100 = mScore100 + 1;
            Toast.makeText(LakaPitanja.this, "Super!", Toast.LENGTH_SHORT).show();
            updateScore(mScore);
            mp.start();
            updateQuestion();
        } else {
            Toast.makeText(LakaPitanja.this, "Greska!", Toast.LENGTH_SHORT).show();
            updateScore(mScore);
            mp2.start();
            updateQuestion();
        }
    }
    public void rezultat(View view){
        Intent inte = new Intent(this,LakaPitanja.class);
        startActivity(inte);
    }
}