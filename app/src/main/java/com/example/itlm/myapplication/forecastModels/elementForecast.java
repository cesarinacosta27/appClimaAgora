package com.example.itlm.myapplication.forecastModels;

public class elementForecast {
    String fecha,icono,temperatura,pronostico,probablluvia;

    public elementForecast() {
    }

    public elementForecast(String fecha, String icono, String temperatura, String pronostico, String probablluvia) {
        this.fecha = fecha;
        this.icono = icono;
        this.temperatura = temperatura;
        this.pronostico = pronostico;
        this.probablluvia = probablluvia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPronostico() {
        return pronostico;
    }

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    public String getProbablluvia() {
        return probablluvia;
    }

    public void setProbablluvia(String probablluvia) {
        this.probablluvia = probablluvia;
    }
}
