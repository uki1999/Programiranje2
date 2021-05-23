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
import android.widget.ImageView;

import com.kurs.iserbia.istorijskikviz.R;

import java.util.Random;

public class NajtezaPitanjaIstorija2 extends AppCompatActivity {
    private najtezaPitanjaIstorija mQuestionLibary3 = new najtezaPitanjaIstorija();
    private TextView mScoreView3;
    private TextView mScoreView6;
    private ImageView imageView;
    private Button mButtonChoice13;
    private Button mButtonChoice24;
    private Button mButtonChoice35;
    private Button mButtonChoice46;

    private String mAnswer3;
    private int mScore3 = 0;
    private int mScore500 = 0;
    private int mQuestionNumber3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.najteza_pitanja);
        if (getSupportActionBar() != null)
            getSupportActionBar().

                    setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);
        Random rn = new Random();
        int random = rn.nextInt(5) + 1;
        mScoreView3 = (TextView) findViewById(R.id.score);
        mScoreView6 = (TextView) findViewById(R.id.score500);
        imageView = (ImageView)findViewById(R.id.imageView4);
        mButtonChoice13 = (Button) findViewById(R.id.choice13);
        mButtonChoice24 = (Button) findViewById(R.id.choice24);
        mButtonChoice35 = (Button) findViewById(R.id.choice35);
        mButtonChoice46 = (Button) findViewById(R.id.choice46);
        updateQuestion2();


        updateScore2(mScore3);
        updateScore2(mScore500);
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
    private void updateQuestion2() {
        if (mQuestionNumber3 < mQuestionLibary3.getLength()) {
            imageView.setImageResource(mQuestionLibary3.getFlags(mQuestionNumber3));
            mButtonChoice13.setText(mQuestionLibary3.getChoices2(mQuestionNumber3, 1));
            mButtonChoice24.setText(mQuestionLibary3.getChoices2(mQuestionNumber3, 2));
            mButtonChoice35.setText(mQuestionLibary3.getChoices2(mQuestionNumber3, 3));
            mButtonChoice46.setText(mQuestionLibary3.getChoices2(mQuestionNumber3, 4));
            mAnswer3 = mQuestionLibary3.getCorrectAnswers3(mQuestionNumber3);
            mQuestionNumber3++;
        }else{
            NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(NajtezaPitanjaIstorija2.this)
                    .setSmallIcon(android.R.drawable.stat_notify_error)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("Kako si uradio?")
                    .setContentText("Tvoj rezultat na ovom delu kviza je: " + mScore500);
            notificationBuilder.setAutoCancel(true);
            notificationBuilder.setDefaults(
                    Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(NajtezaPitanjaIstorija2.this);
            notificationManager.notify(1, notificationBuilder.build());
            Intent toLaunch = new Intent(getApplicationContext(), Kviz1.class);
            toLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent intentBack =
                    PendingIntent.getActivity(getApplicationContext(), 0, toLaunch, 0);
            notificationBuilder.setContentIntent(intentBack);
            NotificationManager menadzer = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
            menadzer.notify(1, notificationBuilder.build());

            Toast.makeText(NajtezaPitanjaIstorija2.this, "Vas rezultat je:"+ mScore3, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(NajtezaPitanjaIstorija2.this, VeciSkorActivity3.class);
            intent.putExtra("score", mScore3); // pass the current score to the second screen
            startActivity(intent);
        }
    }
    private void updateScore2(int point) {
        mScoreView3.setText("" + mScore3 + "/" + mQuestionLibary3.getLength());
        mScoreView6.setText(String.valueOf(mScore500));
    }

    public void onClick(View view) {
        final MediaPlayer mp = MediaPlayer.create(NajtezaPitanjaIstorija2.this, R.raw.true_sound);
        final MediaPlayer mp2 = MediaPlayer.create(NajtezaPitanjaIstorija2.this,R.raw.false_sound);
        //Logic for all answers on quiz
        Button answers = (Button) view;

        if (answers.getText()== mAnswer3) {
            mScore3 = mScore3 + 1;
            mScore500 = mScore500 + 3;
            Toast.makeText(NajtezaPitanjaIstorija2.this, "Super!", Toast.LENGTH_SHORT).show();
            mp.start();
            updateScore2(mScore3);
            updateQuestion2();
        } else {
            Toast.makeText(NajtezaPitanjaIstorija2.this, "Greska", Toast.LENGTH_SHORT).show();
            mp2.start();
            updateScore2(mScore3);
            updateQuestion2();
        }
    }
    public void rezultat3(View view){
        Intent inte = new Intent(this,NajtezaPitanjaIstorija2.class);
        startActivity(inte);
    }
}
