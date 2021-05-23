package com.kurs.iserbia.geoistorijskviz;

/**
 * Created by Uroš on 17-May-17.
 */

public class Pitanjaistorijalaksaverzija {
    //pitanja laksa verzija
    private String textQuestions[] = {
            "1.Ko se smatra ocem istorije?",
            "2.Od koje godine muslimani racunaju vreme?",
            "3.Periodizacija praistorije se deli na?",
            "4.Sta znaci grcka rec demos?",
            "5.Ko je bio vrhovni bog starog Rima?",
            "6.Sta su zitije?",
            "7.U kom veku su poceli Sloveni da naseljavaju Balkan?",
            "8.Izmedju koga su vodjeni krstaski ratovi?",
            "9.Kako se zvao engleski kralj u vreme kad su se vodili krstaski ratovi?",
            "10.Najmocniji turski sultan bio je?",
            "11.Ko je otkrio Ameriku?",
            "12.Ko je napisao 'Bozanstvenu komediju'?",
            "13.Ko je napravio parnu masinu?",
            "14.Ko je najpoznatiji francuski vojskovodja?",
            "15.Ko je bio vodja Prvog srpskog ustanka?",
            "16.Kad je odrzan Berlinski kongres?",
            "17.Kako se zvao koji je pruzao otpor Austougarskoj?",
            "18.Ko je vladao Srbijom za vreme Balkanskih ratova?",
            "19.Kojeg datuma je zapoceo Drugi svetski rat?",
            "20.Kojeg datuma je zavrsen Drugi svetski rat?"
    };
    //pa nizovi odgovora laksa verzija
    private String multipleChoice[][] = {
            {"Herodot", "Tit Livije", "Asurbanipal", "Kalmimah"},
            {"776.godine", "622.godine", "600.godine", "554.godine"},
            {"Gvozdeno i bakarno", "Metalno i plasticno", "Kameno i metalno", "Metalno i bakarno"},
            {"Starosedeoci", "Narod", "Robovi", "Mladi"},
            {"Minerva", "Mars", "Neptun", "Jupiter"},
            {"Spisi o svetcima", "Spisi o kmetovima", "Spisi o vladarskim porodicama", "Istorijski spisi"},
            {"VII", "VIII", "V", "VI"},
            {"Muslimana i jevreja", "Hriscana i jevreja", "Hriscana i muslimana", "Hriscana"},
            {"Fridrih Barbarosa", "Filip II Avgust", "Henri II", "Ricard I Lavlje Srce"},
            {"Mehmed II Osvajac", "Bajazit II Svetac", "Selim I Jaki", "Sulejman I Velicanstveni"},
            {"Kolumbo", "Vasko de Gama", "Bartolomeo Dijaz", "Amerigo Vespuci"},
            {"Dante Aligijeri", "Vilijem Sekspir", "Francesko Petrarka", "Fransoa Rable"},
            {"Dzejms Hargrivs", "Dzejms Vat", "Dzordz Stivenson", "Bendzamin Frenklin"},
            {"Mazaren", "Riselje", "Napoleon I Bonaparta", "Luj XVI"},
            {"Milos Obrenovic", "Stevan Sindjelic", "Tanasko Rajic", "Karadjordje"},
            {"1868", "1889", "1878", "1870"},
            {"Mlada Bosna", "Mlada Srbija", "Crna ruka", "Vidovdanski heroji"},
            {"Aleksandar Obrenovic", "Petar I Karadjordjevic", "Aleksandar Karadjordjevic", "Mihailo Obrenovic"},
            {"1.septembar 1940.godine", "1.avgust 1939.godine", "1.septembar 1939.godine", "1.septembar 1938.godine"},
            {"2.septembar 1945.godine", "1.avgust 1945.godine", "2.septembar 1943.godine", "2.septembar 1946.godine"}
    };
    //odgovori na pitanja
    private String mCorrectAnswers[] = {"Herodot", "622.godine", "Kameno i metalno", "Narod", "Jupiter", "Spisi o svetcima", "VI", "Hriscana i muslimana", "Ricard I Lavlje Srce", "Mehmed II Osvajac","Kolumbo","Dante Aligijeri","Dzejms Vat","Napoleon I Bonaparta","Karadjordje","1878","Mlada Bosna","Petar I Karadjordjevic","1.septembar 1939.godine","2.septembar 1945.godine"};


    //metoda vraca broj pitanja
    public int getLength() {
        return textQuestions.length;
    }

    //metoda za vracanje niza tekstPitanja na osnovu indeksa
    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num - 1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}