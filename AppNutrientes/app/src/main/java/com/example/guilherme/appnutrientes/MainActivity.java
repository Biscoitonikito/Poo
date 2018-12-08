package com.example.guilherme.appnutrientes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    protected Intent information;
    protected Intent details;
    private EditText editName;
    private Button buttonConfirm;
    private Button buttonDetails;
    private View viewName;
    private TextView txtName;
    private TextView txtWeight;
    private TextView txtHeight;
    private TextView txtTmb;
    private TextView txtGet;
    private String namePerson = "";
    private Spinner style;
    private Double tmb;
    private Double get;

    public static final String NAME = "name";
    public static final String GET = "get";
    public static final int RESQUEST_CODE = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.person_name);
        viewName = findViewById(R.id.view_name);
        txtName = findViewById(R.id.name_user);
        txtHeight = findViewById(R.id.height);
        txtWeight = findViewById(R.id.weight);
        txtTmb = findViewById(R.id.tmb);
        txtGet = findViewById(R.id.get);
        style = findViewById(R.id.style_life);
        style.setOnItemSelectedListener(this);
        buttonConfirm = findViewById(R.id.get_information);
        buttonDetails = findViewById(R.id.details);


    }

    public void obter_informacao(View view) {

        information = new Intent(this, InformationActivity.class);
        namePerson = editName.getText().toString();
        information.putExtra(NAME, namePerson);

        startActivityForResult(information, RESQUEST_CODE);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                viewName.setVisibility(View.GONE);
                buttonConfirm.setVisibility(View.GONE);
                double height = data.getDoubleExtra(InformationActivity.HEIGHT, 0.0);
                double weight = data.getDoubleExtra(InformationActivity.WEIGHT, 0.0);
                namePerson = data.getStringExtra(InformationActivity.NAME);
                txtName.setVisibility(View.VISIBLE);
                txtHeight.setVisibility(View.VISIBLE);
                txtWeight.setVisibility(View.VISIBLE);
                txtTmb.setVisibility(View.VISIBLE);
                style.setVisibility(View.VISIBLE);
                txtGet.setVisibility(View.VISIBLE);
                buttonDetails.setVisibility(View.VISIBLE);
                txtName.setText(namePerson);
                txtHeight.setText("Altura: " + height + " " + "m");
                txtWeight.setText("Peso: " + weight + " " + "Kg");
                tmb = (11.3 * weight) + (16 * height) + 901;
                //get = tmb;
                txtTmb.setText(String.format("TMB: %.2f ", (tmb)));

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.life_style,R.layout.support_simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                style.setAdapter(adapter);


            }
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selecionado = parent.getItemAtPosition(position).toString();
        get = tmb;
        if(selecionado.equals("Sedentário")){
            txtGet.setText(String.format("GET: %.2f", (get)));
        }
        if(selecionado.equals("Levemente Ativo")){
            txtGet.setText(String.format("GET: %.2f", (get*1.11)));
        }
        if(selecionado.equals("Moderamente Ativo")){
            txtGet.setText(String.format("GET: %.2f", (get*1.25)));
        }
        if(selecionado.equals("Muito Ativo")){
            txtGet.setText(String.format("GET: %.2f", (get*1.48)));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getDetails(View view) {
        details = new Intent(this, DetailsActivity.class);
        details.putExtra(NAME,namePerson);
        details.putExtra(GET, get);
        startActivity(details);
    }
}