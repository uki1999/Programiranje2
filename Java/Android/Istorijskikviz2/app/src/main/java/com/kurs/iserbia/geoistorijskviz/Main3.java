package com.kurs.iserbia.geoistorijskviz;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.AdapterView;

import com.kurs.iserbia.istorijskikviz.R;

import pl.droidsonroids.gif.GifTextView;


/**
 * Created by Uroš on 16-May-17.
 */

public class Main3 extends AppCompatActivity {

    ListView listView;
    String[] titles;
    String[] description;
    int[] imgs = {R.drawable.covek, R.drawable.zastava};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
if(getSupportActionBar()!=null)
        getSupportActionBar().

                setDisplayShowHomeEnabled(true);

        getSupportActionBar().

                setDisplayHomeAsUpEnabled(true);


        Resources res = getResources();

        titles = res.getStringArray(R.array.titles);
        description = res.getStringArray(R.array.description);

        listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, titles, imgs, description);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Kviz1.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Kviz2.class);
                    startActivityForResult(myIntent, 1);
                }
            }
        });
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
            Intent intent1 = new Intent(this, MainActivity.class);
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
        class MyAdapter extends ArrayAdapter<String> {

            Context context;
            int[] imgs;
            String myTitles[];
            String myDescription[];

            MyAdapter(Context c, String[] titles, int[] imgs, String[] description) {
                super(c, R.layout.row, R.id.text1, titles);
                this.context = c;
                this.imgs = imgs;
                this.myDescription = description;
                this.myTitles = titles;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row = layoutInflater.inflate(R.layout.row, parent, false);
                GifTextView images = (GifTextView) row.findViewById(R.id.icon);
                TextView myTitle = (TextView) row.findViewById(R.id.text1);
                TextView myDescription = (TextView) row.findViewById(R.id.text2);
                images.setBackgroundResource(imgs[position]);
                myTitle.setText(titles[position]);
                myDescription.setText(description[position]);
                return row;

            }
            public void setUpActionBar(){

                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.JELLY_BEAN){
                    ActionBar actionBar = getActionBar();
                    actionBar.setDisplayHomeAsUpEnabled(true);
                }

            }

        }
    }



