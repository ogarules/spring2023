package com.example.demo.tarea3;

public class NumericalEsp implements INumerical {

    @Override
    public String getLanguage() {
        return "esp";
    }

    @Override
    public String[] getUnits() {
        return new String[]{ "", "un", "dos", "tres", "cuatro", "cinco",
        "seis", "siete", "ocho", "nueve" };
    }

    @Override
    public String[] getDozens() {
        return new String[] { "diez", "once", "doce", "trece",
        "catorce", "quince", "dieciseis", "diecisiete", "dieciocho",
        "diecinueve", "veinte", "treinta", "cuarenta", "cincuenta",
        "sesenta", "setenta", "ochenta", "noventa" };   
    }

    @Override
    public String[] geHundreds() {
        return new String[]{ "", "ciento", "doscientos",
        "trescientos", "cuatrocientos", "quinientos", "seiscientos",
        "setecientos", "ochocientos", "novecientos" };
    }

    @Override
    public String getZero() {
        return "cero";
    }

    @Override
    public String getOneHundred() {
        return "cien";
    }

    @Override
    public String getAnd() {
        return "y";
    }

    @Override
    public String getOneThousand() {
        return "mil";
    }

    @Override
    public String getOneMillion() {
        return "millon";
    }

    @Override
    public String getMillions() {
        return "millones";
    }
    
}
