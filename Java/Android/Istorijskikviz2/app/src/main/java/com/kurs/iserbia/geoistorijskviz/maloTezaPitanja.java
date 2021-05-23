package com.kurs.iserbia.geoistorijskviz;

/**
 * Created by Uroš on 17-May-17.
 */

public class maloTezaPitanja {
    //pitanja laksa verzija
    private String textQuestions2[] = {
            "1.Ko je napravio stamparsku masinu?",
            "2.Petar II Petrovic Njegos je napisao?",
            "3.Ko je nazvan \"srpska majka",
            "4.Kako se zvao kralj ostrva Krit?",
            "5.Kako se zvao otac Aleksandra Velikog?",
            "6.Ko je osnovao Rimsko carstvo?",
            "7.Kada je izvrsen napad na Tokio?",
            "8.Koliko godina je trajala Aneksiona kriza?",
            "9.Kada je objavljen ultimatum za Prvi svetski rat?",
            "10.Koliko je bilo krstaskih ratova?",
            "11.Kako se zvala druga dinastija Franackog carstva?",
            "12.Ko je bila zena cara Dusana Silnog?"
    };
    //pa nizovi odgovora laksa verzija
    private String multipleChoice2[][] = {
            {"Johan Gutenberg", "Albert Filster", "Fust", "Pantaleon"},
            {"Zivot i prilkjucenije", "Pismo Haralampiju", "Luca Mikrokozma", "Pesme domovini"},
            {"Mula Jusuf", "Hadzi Mustafa Pasa", "Kudzuk Alija", "Mehmed Aga"},
            {"Minos", "Klisten", "Solon", "Tezej"},
            {"Filip III", "Aleksandar IV", "Perdika III", "Filip II"},
            {"Dioklecijan", "Trajan", "Oktavijan Avgust", "Julije Cezar"},
            {"9 i 10.marta 1945.godine", "9 i 10.marta 1944.godine", "4.marta 1944.godine", "15.maja 1945.godine"},
            {"4", "5", "2", "3"},
            {"28.jul 1914.godine", "28.jun 1914.godine", "28.avgust 1914.godine", "28.jul 1915.godine"},
            {"10", "6", "2", "8"},
            {"Karoling", "Tjudor", "Meroling", "Romanov"},
            {"Milica", "Jelena", "Ljubica", "Marija"}
    };
    //odgovori na pitanja
    private String mCorrectAnswers2[] = {"Johan Gutenberg", "Luca Mikrokozma", "Hadzi Mustafa Pasa", "Minos", "Filip II","Oktavijan Avgust","9 i 10.marta 1945.godine","5","28.jul 1914.godine","8","Karoling","Jelena"};


    //metoda vraca broj pitanja
    public int getLength() {
        return textQuestions2.length;
    }

    //metoda za vracanje niza tekstPitanja na osnovu indeksa
    public String getQuestions(int a) {
        String questions = textQuestions2[a];
        return questions;
    }

    public String getChoices(int index, int num) {
        String choice0 = multipleChoice2[index][num - 1];
        return choice0;
    }

    public String getCorrectAnswers2(int a) {
        String answers = mCorrectAnswers2[a];
        return answers;
    }
}
