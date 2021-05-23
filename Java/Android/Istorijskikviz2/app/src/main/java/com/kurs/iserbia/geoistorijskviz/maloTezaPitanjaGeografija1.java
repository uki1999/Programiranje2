package com.kurs.iserbia.geoistorijskviz;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 24-May-17.
 */

public class maloTezaPitanjaGeografija1 {
    Integer [] flags2 = {
            R.drawable.belorusija,
            R.drawable.indonezija,
            R.drawable.kipar,
            R.drawable.kenija,
            R.drawable.kuba,
            R.drawable.singapur,
            R.drawable.tunis,
            R.drawable.novizeland,
            R.drawable.bolivija,
            R.drawable.letonija,
            R.drawable.tajland,
            R.drawable.honduras
    };
    //pa nizovi odgovora laksa verzija
    private String multipleChoice4[][] = {
            {"Rusija", "Ukrajina", "Belorusija", "Estonija"},
            {"Mjanmar", "Poljska", "Monako", "Indonezija"},
            {"Kipar", "Grcka", "Bugarska", "Malta"},
            {"Etiopija", "Sijera Leone", "Kenija", "Mozambik"},
            {"Kuba", "Bahami", "Barbados", "Kosta Rika"},
            {"Kambodza", "Vijetnam", "Brunej", "Singapur"},
            {"Egipat", "Pakistan", "Tunis", "Turska"},
            {"Novi Zeland", "Velika Britanija", "Amerika", "Australija"},
            {"Cile", "Urugvaj", "Bolivija", "Cile"},
            {"Finska", "Letonija", "Estonija", "Litvanija"},
            {"Tajland", "Indija", "Norveska", "Filipini"},
            {"Dominikanska Republika", "Nikaragva", "Argentina", "Honduras"}
    };
    //odgovori na pitanja
    private String mCorrectAnswers4[] = {"Belorusija", "Indonezija", "Kipar", "Kenija", "Kuba","Singapur", "Tunis", "Novi Zeland", "Bolivija", "Letonija","Tajland","Honduras"};


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

