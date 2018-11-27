package com.example.itlm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.ForecastConfiguration;
import android.zetterstrom.com.forecast.models.Forecast;
import android.zetterstrom.com.forecast.models.Language;
import android.zetterstrom.com.forecast.models.Unit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   public final String DarkSkyApiKey="0c85ad6335ef817555fb40166282a8e7";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ForecastConfiguration configuration=
                new ForecastConfiguration.Builder(DarkSkyApiKey)
                        .setDefaultLanguage(Language.SPANISH)
                        .setDefaultUnit(Unit.SI)
                        .setCacheDirectory(getCacheDir())
                        .build();

        ForecastClient.create(configuration);

        ObtenerClima();


    }

    public void ObtenerClima() {
        ForecastClient.getInstance()
                .getForecast(25.790466, -108.985886, new Callback<Forecast>() {
                    @Override
                    public void onResponse(Call<Forecast> forecastCall, Response<Forecast> response) {
                        if (response.isSuccessful()) {
                            Forecast forecast = response.body();
                            Toast.makeText(MainActivity.this, "forecast"+forecast.getDaily().getSummary(), Toast.LENGTH_SHORT).show();
                            Log.d("_____clima______", "onResponse: "+forecast);
                            /*lisaclima   = Utils.pronosticoPorHoras(forecast,getApplicationContext());
                            AdaptadorClima adaptadorClima = new AdaptadorClima(getApplicationContext(), lisaclima);
                            lv.setAdapter(adaptadorClima);*/
                        }
                    }
                    @Override
                    public void onFailure(Call<Forecast> forecastCall, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error de forecast: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}

