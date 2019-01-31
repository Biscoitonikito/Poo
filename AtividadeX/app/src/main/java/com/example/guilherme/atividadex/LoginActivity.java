package com.example.guilherme.atividadex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity {

    private EditText cpf;
    private EditText senha;
    Box<Usuario> usuarioBox;
    Box<Logado> usuarioLogadoBox;
    List<Logado> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);

        if(usuarioLogadoBox.isEmpty()){
            setupViews();
        }
        else{
            //list = usuarioLogadoBox.getAll();
            Intent intent = new Intent(this, ListaMedicamentoActivity.class);
            //intent.putExtra("usuarioId", list.get(0).getIdLogado());
            this.startActivity(intent);
            finish();
        }
    }

    private void setupViews() {
        cpf = findViewById(R.id.cpf_loguin);
        senha = findViewById(R.id.senha_login);
    }

    public void cadastrar(View view){
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }

    public void logar(View view){
        String cpf_login = cpf.getText().toString();
        String senha_login = senha.getText().toString();

        List<Usuario> list = usuarioBox.getAll();

        int tamanho = list.size()-1;

        for(int i = 0; i <= tamanho; i++) {
            if (!cpf_login.equals(list.get(i).getCpf()) && !senha_login.equals(list.get(i).getCpf())) {
                list.remove(i);
            }
        }

        tamanho = list.size();
        if(tamanho != 1){
            Toast.makeText(this, "Dados Incorretos", Toast.LENGTH_SHORT).show();
        }
        else{
            Logado logado = new Logado();
            logado.setIdLogado(list.get(0).getId());
            usuarioLogadoBox.put(logado);
            Intent intent = new Intent(this, ListaMedicamentoActivity.class);
            //intent.putExtra("usuarioId", list.get(0).getId());
            this.startActivity(intent);
            finish();
        }
    }
}


