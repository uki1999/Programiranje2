package com.kurs.iserbia.geoistorijskviz;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 24-May-17.
 */

public class lakaPitanjaGeografija1 {
    Integer [] flags2 = {
            R.drawable.engleska,
            R.drawable.srbija,
            R.drawable.argentina,
            R.drawable.australija,
            R.drawable.spanija,
            R.drawable.kanada,
            R.drawable.brazil,
            R.drawable.italija,
            R.drawable.egipat,
            R.drawable.rusija,
            R.drawable.amerika,
            R.drawable.indija,
            R.drawable.kina,
            R.drawable.meksiko,
            R.drawable.japan,
            R.drawable.portugal,
            R.drawable.nigerija,
            R.drawable.nemacka,
            R.drawable.maroko,
            R.drawable.turska
    };
    //pa nizovi odgovora laksa verzija
    private String multipleChoice4[][] = {
            {"Spanija", "Amerika", "Vels", "Velika Britanija"},
            {"Irska", "Srbija", "Rusija", "Francuska"},
            {"Argentina", "Salvador", "Nikaragva", "Honduras"},
            {"Rusija", "Kina", "Novi Zeland", "Australija"},
            {"Maroko", "Letonija", "Spanija", "Grcka"},
            {"Kanada", "Amerika", "Meksiko", "Ekvador"},
            {"Makedonija", "Japan", "Argentina", "Brazil"},
            {"Rumunija", "Italija", "Francuska", "Belgija"},
            {"Egipat", "Maroko", "Juzna Afrika", "Alzir"},
            {"Poljska", "Srbija", "Holandija", "Rusija"},
            {"Amerika", "Kanada", "Rusija", "Velika Britanija"},
            {"Irak", "Sirija", "Iran", "Indija"},
            {"Kina", "Mongolija", "Japan", "Laos"},
            {"Venecuela", "Kolumbija", "Meksiko", "Amerika"},
            {"Kina", "Severna Koreja", "Juzna Koreja", "Japan"},
            {"Srbija", "Maroko", "Portugal", "Spanija"},
            {"Nigerija", "Zimbabve", "Zambija", "DR Kongo"},
            {"Belgija", "Poljska", "Francuska", "Nemacka"},
            {"Maroko", "Egipat", "Kamerun", "Tunis"},
            {"Liban", "Irak", "Turska","Pakistan"}
    };
    //odgovori na pitanja
    private String mCorrectAnswers4[] = {"Velika Britanija", "Srbija", "Argentina", "Australija", "Spanija","Kanada", "Brazil", "Italija", "Egipat", "Rusija","Amerika","Indija","Kina","Meksiko","Japan","Portugal","Nigerija","Nemacka","Maroko","Turska"};


    //metoda vraca broj pitanja
    public int getLength() {
        return flags2.length;
    }

    //metoda za vracanje niza tekstPitanja na osnovu indeksa
    public Integer getFlags(int a) {
        Integer flags4 = flags2[a];
        return flags4;
    }

    public String getChoices4(int index, int num) {
        String choice4 = multipleChoice4[index][num - 1];
        return choice4;
    }

    public String getCorrectAnswers4(int a) {
        String answers4 = mCorrectAnswers4[a];
        return answers4;
    }
}


