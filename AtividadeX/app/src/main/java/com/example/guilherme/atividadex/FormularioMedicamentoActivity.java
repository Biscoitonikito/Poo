package com.example.guilherme.atividadex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

import io.objectbox.Box;

public class FormularioMedicamentoActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editDescricao;
    private EditText editValidade;
    private EditText editPeriodo;

    private long medicamentoId;
    private Usuario usuario;
    private Medicamento medicamento;
    private Box<Medicamento> medicamentoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_medicamento);

        setupAll();
        validarSeExiste();
    }

    private void setupAll(){
        medicamentoBox = ((App)getApplication()).getBoxStore().boxFor(Medicamento.class);
        Box<Logado> logadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        Box<Usuario> usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        List<Logado> logadoList = logadoBox.getAll();
        usuario = usuarioBox.get(logadoList.get(0).getIdLogado());
        editNome = findViewById(R.id.novo_medicamento_nome);
        editDescricao = findViewById(R.id.novo_medicamento_descricao);
        editValidade = findViewById(R.id.novo_medicamento_validade);
        editPeriodo = findViewById(R.id.novo_medicamento_periodo);
        Intent intent = getIntent();
        medicamentoId = intent.getLongExtra("medicamentoId", -1);
    }

    public void criarMedicamento(View view){

        this.medicamento.setNome(editNome.getText().toString());
        medicamento.setDescricao(editDescricao.getText().toString());
        medicamento.setValidade(editValidade.getText().toString());
        int periodo = Integer.parseInt(editPeriodo.getText().toString());
        medicamento.setPeriodo(periodo);
        medicamento.setIdUsuario(usuario.getId());

        this.medicamentoBox.put(medicamento);

        Toast.makeText(this, "Salvo", Toast.LENGTH_LONG).show();
        finish();
    }

    private void validarSeExiste(){
        if(medicamentoId  != -1){
            medicamento = medicamentoBox.get(medicamentoId);
            preencerCampos();
        }
        else{
            medicamento = new Medicamento();
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
