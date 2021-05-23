package com.kurs.iserbia.geoistorijskviz;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 20-May-17.
 */

public class najtezaPitanjaIstorija {
    //pitanja laksa verzija
    Integer [] flags = {
            R.drawable.iliri,
            R.drawable.gamzigrad,
            R.drawable.kongres,
            R.drawable.vasington,
            R.drawable.veliki,
            R.drawable.srbija2,
            R.drawable.milankovic,
            R.drawable.decanski,
            R.drawable.dubrovnik,
            R.drawable.ruzvelt
    };
    //pa nizovi odgovora laksa verzija
    private String multipleChoice3[][] = {
            {"Tracanski ratnik", "Ilirski ratnik", "Keltski ratnik", "Dorski ratnik"},
            {"Caricin Grad", "Viminacijum", "Damastion", "Gamzigrad"},
            {"Sanstefanski mir", "Berlinski kongres", "Bukureski mir", "Mir u Brest-Litovsku"},
            {"Dzon Adams", "Tomas Dzeferson", "Dzejms Monro", "Dzordz Vasington"},
            {"Aleksandar III", "Filip III", "Filip II", "Aleksandar Veliki"},
            {"Teritorija Srbije u periodu od 1817-1913", "Teritorija Srbije u periodu od 1717-1813", "Teritorija Srbije u periodu od 1800-1896", "Teritorija Srbije u periodu od 1818-1913"},
            {"Slobodan Jovanovic", "Paja Jovanovic", "Milutin Milankovic", "Jovan Sterija Popovic"},
            {"Kralj Dragutin", "Kralj Milutin", "Dusan Silni", "Stefan Decanski"},
            {"Dubrovnik", "Segedin", "Zagreb", "Split"},
            {"Hari Truman", "Frenklin Ruzvelt", "Teodor Ruzvelt", "Vudro Vilson"}
    };
    //odgovori na pitanja
    private String mCorrectAnswers3[] = {"Ilirski ratnik", "Gamzigrad", "Berlinski kongres", "Dzordz Vasington", "Aleksandar Veliki","Teritorija Srbije u periodu od 1817-1913", "Milutin Milankovic", "Stefan Decanski", "Dubrovnik", "Frenklin Ruzvelt"};


    //metoda vraca broj pitanja
    public int getLength() {
        return flags.length;
    }

    //metoda za vracanje niza tekstPitanja na osnovu indeksa
    public Integer getFlags(int a) {
        Integer flags2 = flags[a];
        return flags2;
    }

    public String getChoices2(int index, int num) {
        String choice2 = multipleChoice3[index][num - 1];
        return choice2;
    }

    public String getCorrectAnswers3(int a) {
        String answers2 = mCorrectAnswers3[a];
        return answers2;
    }
}


