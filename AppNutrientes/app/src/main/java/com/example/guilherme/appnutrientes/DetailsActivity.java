package com.example.guilherme.appnutrientes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    protected TextView txtName;
    protected TextView gGordura;
    protected TextView dGordura;
    protected TextView gCarbo;
    protected TextView dCarbo;
    protected TextView gProteina;
    protected TextView dProteina;

    private String namePerson = "";
    private Double get;
    private Double getG;
    private Double getC;
    private Double getP;



    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        namePerson = intent.getStringExtra(MainActivity.NAME);
        get = intent.getDoubleExtra(MainActivity.GET,0);
        getC = get*0.6;
        getG = get*0.25;
        getP = get*0.15;
        txtName = findViewById(R.id.detail_name);
        gGordura = findViewById(R.id.gorduras_gramas);
        dGordura = findViewById(R.id.details_gordura);
        gCarbo = findViewById(R.id.carbo_gramas);
        dCarbo = findViewById(R.id.details_carbo);
        gProteina = findViewById(R.id.proteina_gramas);
        dProteina = findViewById(R.id.details_proteina);

        txtName.setText(namePerson);
        gGordura.setText(String.format("Gramas: %.2f g", (getG/9)));
        gCarbo.setText(String.format("Gramas: \n%.2f g", (get/4)));
        gProteina.setText(String.format("Gramas: %.2f g", (get/4)));
        dProteina.setText(String.format("Calorias: %.2f ", (getP)));
        dCarbo.setText(String.format("Calorias: \n  %.2f", (getC)));
        dGordura.setText(String.format("Calorias: %.2f", (getG)));
    }
}
