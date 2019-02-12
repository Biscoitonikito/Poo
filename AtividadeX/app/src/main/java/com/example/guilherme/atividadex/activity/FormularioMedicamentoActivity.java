package com.example.guilherme.atividadex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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

//TUDO QUE ESTA COMENTADO NO FIM DO CODIGO SÃO MUDANÇAS QUE FIZ PRA PODER ADPTAR A MUDANÇA DO PROJETO
//RETIREI O FIREBASE E DEIXEI APENAS O OBJECT, PARA ASSIM PRIORIZAR SO A FUNCIONALIDADE DOS METODOS
public class FormularioMedicamentoActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editDescricao;
    private EditText editValidade;
    private EditText editPeriodo;

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

    //Este metodo e o abaixo dele sobreescrevem o metodo de volta, para que quando ele pare de criar um
    //Medicamento a tela que lista os medicamento seja atualizada
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(medicamentoId == -1) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    startActivity(new Intent(this, ListaMedicamentoActivity.class));
                    finish();
                    break;
                default:
                    break;
            }
        }
        else{
            finish();
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        if(medicamentoId == -1) {
            startActivity(new Intent(this, ListaMedicamentoActivity.class));
            finish();
        }
        else{
            finish();
        }
    }

    //Inicializa todas as variaveis que irão ser utilizadas
    private void setupAll(){
        logadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        medicamentoBox = ((App)getApplication()).getBoxStore().boxFor(Medicamento.class);
        editNome = findViewById(R.id.novo_medicamento_nome);
        editDescricao = findViewById(R.id.novo_medicamento_descricao);
        editValidade = findViewById(R.id.novo_medicamento_validade);
        editPeriodo = findViewById(R.id.novo_medicamento_periodo);
        Intent intent = getIntent();
        medicamentoId = intent.getLongExtra("medicamentoId", -1);
    }

    //Verifica primeiro se chegou a essa tela por clica em um medicamento ja existente
    //Trazendo o Id do medicamento que foi clicado, se não foi por clica em um ja existente ele retorna -1
    //Em caso de medicamento ja existente ele pega o remedio que foi clicado se não ele cria um medicamento nulo
    //e passa o medicamento para o metodo criarMedicamento, apos o metodo um medicamento é retornado
    //se for nulo e exibido um toast se não e cadastrado o medicamento
    public void criarMedicamento(View view){
        Medicamento medicamento;
        String nome = editNome.getText().toString();
        String descricao = editDescricao.getText().toString();
        String validade = editValidade.getText().toString();
        String periodo = editPeriodo.getText().toString();
        List<Logado> usuario = logadoBox.getAll();
        long id = usuario.get(0).getIdLogado();

        if(medicamentoId != -1){
            medicamento = medicamentoBox.get(medicamentoId);
        }
        else{
            medicamento = null;
        }

        medicamento = MedicamentoController.criarMedicamento(nome, descricao, validade, periodo, id, medicamento);

        if(medicamento == null){
            Toast.makeText(this, "PREENCHA OS CAMPOS", Toast.LENGTH_LONG).show();
        }
        else{
            medicamentoBox.put(medicamento);
            startActivity(new Intent(this, ListaMedicamentoActivity.class));
            finish();
        }
    }

    //Verifica se clicou em um medicamento ja existente e chama preencherCampos
    private void validarSeExiste(){
        if(medicamentoId  != -1){
            medicamento = medicamentoBox.get(medicamentoId);
            preencerCampos();
        }
    }

    //preenche os campos da activity
    private void preencerCampos(){
        editNome.setText(medicamento.getNome());
        editDescricao.setText(medicamento.getDescricao());
        editValidade.setText(medicamento.getValidade());
        String periodo = String.valueOf(medicamento.getPeriodo());
        editPeriodo.setText(periodo);
    }
}

/*
private DatabaseReference reference;
reference = FireStore.getReference();

try {
        reference.child("usuario/medicamentos").child(medicamento.getNome()).setValue(medicamento);
        Toast.makeText(this, "DEU CERTO", Toast.LENGTH_LONG).show();
        }catch (Exception e){
        e.printStackTrace();
        Toast.makeText(this, "ERRO AO TENTA CRIAR/NO MEDICAMENTO", Toast.LENGTH_LONG).show();
        }
*/