package com.kurs.iserbia.geoistorijskviz;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 24-May-17.
 */

public class najtezaPitanjaGeografija1 {
    Integer [] flags2 = {
            R.drawable.andora,
            R.drawable.sentkits,
            R.drawable.palau,
            R.drawable.lesoto,
            R.drawable.eritreja,
            R.drawable.sudan,
            R.drawable.gvajana,
            R.drawable.hongkong,
            R.drawable.nepal,
            R.drawable.banglades
    };
    //pa nizovi odgovora laksa verzija
    private String multipleChoice4[][] = {
            {"Lihenstajn", "Luksemburg", "Andora", "Vatikan"},
            {"Belize", "Haiti", "Panama", "Sent Kits i Nevis"},
            {"Palau", "Tonga", "Marsalska ostrva", "Zelentroska ostrva"},
            {"Svaziland", "Lesoto", "Burundi", "Ruanda"},
            {"Uganda", "Somalija", "Etiopija", "Eritreja"},
            {"Jemen", "Kuvajt", "Sudan", "Palestina"},
            {"Gvajana", "Francuska Gvajana", "Tridinad i Tobago", "Dominika"},
            {"Tajvan", "Japan", "Juzna Koreja", "Hong Kong"},
            {"Nepal", "Butan", "Maldivi", "Sri Lanka"},
            {"Bahrein", "Banglades", "Oman", "Avganistan"}
    };
    //odgovori na pitanja
    private String mCorrectAnswers4[] = {"Andora", "Sent Kits i Nevis", "Palau", "Lesoto", "Eritreja","Sudan", "Gvajana", "Hong Kong", "Nepal", "Banglades"};


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

