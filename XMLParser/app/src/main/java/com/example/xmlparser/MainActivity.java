package com.example.xmlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txt);
        parseXML();
    }

    private void parseXML(){
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is,null);
            proccessParsing(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
    private void proccessParsing(XmlPullParser parser) throws IOException, XmlPullParserException{
        ArrayList<Player> players = new ArrayList<>();
        int eventType = parser.getEventType();
        Player currentPlayer = null;

        while(eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG;
                    eltName = parser.getName();

                    if("player".equals(eltName)) {
                        currentPlayer = new Player();
                        players.add(currentPlayer);
                    }else if(currentPlayer != null){
                        if("player".equals(eltName)) {
                            currentPlayer.name = parser.getText();
                        }else if("age".equals(eltName)){
                            currentPlayer.age = parser.getText();
                        }else if("position".equals(eltName)){
                            currentPlayer.position = parser.getText();
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        printPlayers(players);
    }
    private void printPlayers(ArrayList<Player> players){
        StringBuilder builder = new StringBuilder();

        for(Player player: players){
            builder.append(player.name).append('\n').append(player.age).append('\n').append(player.position).append("\n\n");
        }
        txt.setText(builder.toString());
    }
}