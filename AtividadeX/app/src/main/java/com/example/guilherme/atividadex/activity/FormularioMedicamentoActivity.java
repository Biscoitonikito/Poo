package com.example.guilherme.atividadex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.controller.MedicamentoController;
import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import io.objectbox.Box;

//TUDO QUE ESTA COMENTADO SÃO MUDANÇAS QUE FIZ PRA PODER ADPTAR A MUDANÇA DO PROJETO
//RETIREI O FIREBASE E DEIXEI APENAS O OBJECT, PARA ASSIM PRIORIZAR SO A FUNCIONALIDADE DOS METODOS
public class FormularioMedicamentoActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editDescricao;
    private EditText editValidade;
    private EditText editPeriodo;

    //private DatabaseReference reference;

    private long medicamentoId;
    private Medicamento medicamento;
    private Box<Medicamento> medicamentoBox;
    private Box<Logado> logadoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_medicamento);

        setupAll();
        validarSeExiste();
    }

    private void setupAll(){
        //reference = FireStore.getReference();
        logadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        medicamentoBox = ((App)getApplication()).getBoxStore().boxFor(Medicamento.class);
        editNome = findViewById(R.id.novo_medicamento_nome);
        editDescricao = findViewById(R.id.novo_medicamento_descricao);
        editValidade = findViewById(R.id.novo_medicamento_validade);
        editPeriodo = findViewById(R.id.novo_medicamento_periodo);
        Intent intent = getIntent();
        medicamentoId = intent.getLongExtra("medicamentoId", -1);
    }

    public void criarMedicamento(View view){
        String nome = editNome.getText().toString();
        String descricao = editDescricao.getText().toString();
        String validade = editValidade.getText().toString();
        String periodo = editPeriodo.getText().toString();
        List<Logado> usuario = logadoBox.getAll();
        long id = usuario.get(0).getIdLogado();

        if(medicamentoId != -1){
            Medicamento remedio = medicamentoBox.get(medicamentoId);
            remedio = MedicamentoController.criarMedicamento(this, nome, descricao, validade, periodo, id, remedio);
            Toast.makeText(this, ""+remedio.getHora()+ " " + remedio.getMinuto(), Toast.LENGTH_LONG).show();
            medicamentoBox.put(remedio);
            finish();
        }
        else{
            Medicamento remedio = null;
            remedio = MedicamentoController.criarMedicamento(this, nome, descricao, validade, periodo, id, remedio);
            Toast.makeText(this, ""+remedio.getHora()+ " " + remedio.getMinuto(), Toast.LENGTH_LONG).show();
            medicamentoBox.put(remedio);
            finish();
        }


        /*if (MedicamentoController.criarMedicamento(this, nome, descricao, validade, periodo, id) != null) {
            if (medicamentoId != -1) {
                Medicamento remedio = medicamentoBox.get(medicamentoId);
                remedio.setId(medicamentoId);
                int periodoInt = Integer.parseInt(periodo);
                remedio.atualizaDados(nome, descricao, validade, periodoInt);
                Toast.makeText(this, ""+remedio.getHora()+ " " + remedio.getMinuto(), Toast.LENGTH_LONG).show();
                medicamentoBox.put(remedio);
                finish();
            } else {
                Medicamento remedio = MedicamentoController.criarMedicamento(this, nome, descricao, validade, periodo, id);
                Toast.makeText(this, ""+remedio.getHora()+ " " + remedio.getMinuto(), Toast.LENGTH_LONG).show();
                medicamentoBox.put(remedio);
                finish();
            }
        }*/
    }

    private void validarSeExiste(){
        if(medicamentoId  != -1){
            medicamento = medicamentoBox.get(medicamentoId);
            preencerCampos();
        }
    }

    private void preencerCampos(){
        editNome.setText(medicamento.getNome());
        editDescricao.setText(medicamento.getDescricao());
        editValidade.setText(medicamento.getValidade());
        String periodo = String.valueOf(medicamento.getPeriodo());
        editPeriodo.setText(periodo);
    }
}

/*
try {
        reference.child("usuario/medicamentos").child(medicamento.getNome()).setValue(medicamento);
        Toast.makeText(this, "DEU CERTO", Toast.LENGTH_LONG).show();
        }catch (Exception e){
        e.printStackTrace();
        Toast.makeText(this, "ERRO AO TENTA CRIAR/NO MEDICAMENTO", Toast.LENGTH_LONG).show();
        }
*/