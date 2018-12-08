package com.example.guilherme.appnutrientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String NAME = MainActivity.NAME;

    protected TextView personName;
    private String name;
    private EditText personHeight;
    private EditText personWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.NAME);

        personHeight = findViewById(R.id.person_height);
        personWeight = findViewById(R.id.person_weight);
        personName = findViewById(R.id.name);
        personName.setText(name);
    }

    public void confirmar(View view) {
        double height = Double.parseDouble(personHeight.getText().toString());
        double weight = Double.parseDouble(personWeight.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(HEIGHT,height);
        intent.putExtra(WEIGHT,weight);
        intent.putExtra(NAME,name);

        setResult(RESULT_OK, intent);
        finish();
    }
}
