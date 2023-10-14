package com.example.demo.tarea3;

public class NumericalEng implements INumerical {

    @Override
    public String getLanguage() {
        return "eng";
    }

    @Override
    public String[] getUnits() {
        return new String[] { "", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine" };
    }

    @Override
    public String[] getDozens() {
        return new String[]{ "ten", "eleven", "twlve", "thirteen",
        "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen", "twenty", "thirty", "fourty", "fifty",
        "sixty", "seventy", "eighty", "ninety" };
    }

    @Override
    public String[] geHundreds() {
        return new String[]{ "", "one hundred", "two hundred",
        "three hundred", "four hundred", "five hundred", "six hundred",
            "seven hundred", "eight hundred", "nine hundred" };
    }

    @Override
    public String getZero() {
        return "zero";
    }

    @Override
    public String getOneHundred() {
        return "hundred";
    }

    @Override
    public String getAnd() {
        return "";
    }

    @Override
    public String getOneThousand() {
        return "thousend";
    }

    @Override
    public String getOneMillion() {
        return "million";
    }

    @Override
    public String getMillions() {
        return "millions";
    }
    
}
