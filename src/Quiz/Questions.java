package Quiz;

public class Questions {
    String[] questions = {
            "During the 10th and 11th centuries, Ukraine was the centre of powerful and prestigious state in Europe. What was it called at the time?",
            "Which two countries was Ukraine ruled by during 1300-1600?",
            "What was established during the mid of seventeenth century by Dnieper Cossacks?",
            "Who led the largest of Cossack uprising against Commonwealth and the Polish king in 1648?",
            "Which country oppressed Ukrainians in Galicia who sympathized with Russia during WW1?",
            "Ukraine became independent in 1917, but that was short-lived when who invaded the city during the January Uprising in 1918?",
            "Who did some elements of the Ukrainian nationalist underground fight against during World War II?",
            "Where did a nuclear reactor explode on 26th April 1986 sending out in the air more radioactivity than Hiroshima and Nagasaki combined?",
            "When did the Ukrainian Parliament proclaim Ukraine's Independence from the USSR?",
            "When was the new Constitution of Ukraine adopted?"
    };
    String[][] options = {
            {"Muscovy","Volhynia","Poland","Kievan Rus"},
            {"Germany and France","Poland and Lithuania","Russia and Hungary","Romania and Turkey"},
            {"Ukraine", "Kievan Rus", "Rukraine", "Zaporozhian Sich"},
            {"Bohdan Khmelnytsky", "Boghdan Chernivetski", "Oleg Stupka", "Taras Bulba"},
            {"Romania", "Austria", "Austria-Hungary", "Russia"},
            {"Americans", "Nazis", "Bolsheviks", "The Black Hand"},
            {"Nazi", "Both Nazi and Soviet Army", "Soviet Army", "France"},
            {"Chernivtsi", "Kiev Nuclear Power Plant", "Chernobyl Nuclear Power Plant", "Nuclear Power Plant in Lviv"},
            {"December 12, 1991", "August 24, 1991", "November 23, 1990", "May 1, 1992"},
            {"1991", "1994", "1992", "1996"}
    };
    char[] answers = {
            'D',
            'B',
            'D',
            'A',
            'C',
            'C',
            'B',
            'C',
            'B',
            'D'
    };

    public Questions() {}

    public String[] getQuestions() {
        return questions;
    }

    public String[][] getOptions() {
        return options;
    }

    public char[] getAnswers() {
        return answers;
    }
}
