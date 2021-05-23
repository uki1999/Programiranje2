package com.kurs.iserbia.geoistorijskviz;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kurs.iserbia.istorijskikviz.R;

import java.util.Random;

public class MaloTezaPitanja2 extends AppCompatActivity {
    private maloTezaPitanja mQuestionLibary2 = new maloTezaPitanja();
    private TextView mScoreView1;
    private TextView mQuestionView1;
    private Button mButtonChoice12;
    private Button mButtonChoice23;
    private Button mButtonChoice34;
    private Button mButtonChoice45;
    private TextView mScoreView3;

    private String mAnswer1;
    private int mScore1 = 0;
    private int mScore200 = 0;
    private int mQuestionNumber2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null)
            getSupportActionBar().

                    setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);
        Random rn = new Random();
        int question2 = rn.nextInt(10) + 1;
        setContentView(R.layout.activity_malo_teza_pitanja2);
        mScoreView1 = (TextView) findViewById(R.id.score2);
        mScoreView3 = (TextView) findViewById(R.id.score200);
        mQuestionView1 = (TextView) findViewById(R.id.question2);
        mButtonChoice12 = (Button) findViewById(R.id.choice12);
        mButtonChoice23 = (Button) findViewById(R.id.choice23);
        mButtonChoice34 = (Button) findViewById(R.id.choice34);
        mButtonChoice45 = (Button) findViewById(R.id.choice45);
        updateQuestion1();

        updateScore1(mScore1);
        updateScore1(mScore200);
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
    private void updateQuestion1() {

        if (mQuestionNumber2 < mQuestionLibary2.getLength()) {
            mQuestionView1.setText(mQuestionLibary2.getQuestions(mQuestionNumber2));
            mButtonChoice12.setText(mQuestionLibary2.getChoices(mQuestionNumber2, 1));
            mButtonChoice23.setText(mQuestionLibary2.getChoices(mQuestionNumber2, 2));
            mButtonChoice34.setText(mQuestionLibary2.getChoices(mQuestionNumber2, 3));
            mButtonChoice45.setText(mQuestionLibary2.getChoices(mQuestionNumber2, 4));
            mAnswer1 = mQuestionLibary2.getCorrectAnswers2(mQuestionNumber2);
            mQuestionNumber2++;
        } else {
            NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(MaloTezaPitanja2.this)
                    .setSmallIcon(android.R.drawable.stat_notify_error)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("Kako si uradio?")
                    .setContentText("Tvoj rezultat na ovom delu kviza je: " + mScore200);
                notificationBuilder.setAutoCancel(true);
            notificationBuilder.setDefaults(
                    Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MaloTezaPitanja2.this);
            notificationManager.notify(1, notificationBuilder.build());
            Intent toLaunch = new Intent(getApplicationContext(), Kviz1.class);
            toLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent intentBack =
                    PendingIntent.getActivity(getApplicationContext(), 0, toLaunch, 0);
            notificationBuilder.setContentIntent(intentBack);
            NotificationManager menadzer = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
            menadzer.notify(1, notificationBuilder.build());
            Toast.makeText(MaloTezaPitanja2.this, "Vas rezultat je:" + mScore1, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MaloTezaPitanja2.this, VeciSkorActivity.class);
            intent.putExtra("score", mScore1); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    private void updateScore1(int point) {
        mScoreView1.setText("" + mScore1 + "/" + mQuestionLibary2.getLength());
        mScoreView3.setText(String.valueOf(mScore200));

    }

    public void onClick(View view) {
        //Logic for all answers on quiz
        Button answers = (Button) view;
        final MediaPlayer mp = MediaPlayer.create(MaloTezaPitanja2.this, R.raw.true_sound);
        final MediaPlayer mp2 = MediaPlayer.create(MaloTezaPitanja2.this,R.raw.false_sound);

        if (answers.getText() == mAnswer1) {
            mScore1 = mScore1 + 1;
            mScore200 = mScore200 + 2;
            Toast.makeText(MaloTezaPitanja2.this, "Super!", Toast.LENGTH_SHORT).show();
            updateScore1(mScore1);
            mp.start();
            updateQuestion1();
        } else {
            Toast.makeText(MaloTezaPitanja2.this, "Greska!", Toast.LENGTH_SHORT).show();
            updateScore1(mScore1);
            mp2.start();
            updateQuestion1();
        }
    }
    public void rezultat2(View view){
        Intent inte = new Intent(this,MaloTezaPitanja2.class);
        startActivity(inte);
    }
}


