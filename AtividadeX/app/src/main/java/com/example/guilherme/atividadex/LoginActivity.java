package com.example.guilherme.atividadex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.dao.FireStore;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;

    private FirebaseAuth auth;
    private Box<Usuario> usuarioBox;
    private Box<Logado> usuarioLogadoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioLogado();

    }

    private void setupAll() {
        auth = FireStore.getAuth();
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        email = findViewById(R.id.email_loguin);
        senha = findViewById(R.id.senha_login);
    }

    private void usuarioLogado(){
        setupAll();
        if(!usuarioLogadoBox.isEmpty()){
            Intent intent = new Intent(this, ListaMedicamentoActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    public void cadastrar(View view){
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }

    public void logar(View view){
        String email_login = email.getText().toString();
        String senha_login = senha.getText().toString();


        if(!email_login.isEmpty() || !senha_login.isEmpty()){
            validarLogin(email_login,senha_login);
        }
        else{
            Toast.makeText(LoginActivity.this, "Preencha os campos adequadamente", Toast.LENGTH_LONG).show();
        }

        /*List<Usuario> list = usuarioBox.getAll();

        int tamanho = list.size()-1;

        for(int i = 0; i <= tamanho; i++) {
            if (!email_login.equals(list.get(i).getCpf()) && !senha_login.equals(list.get(i).getCpf())) {
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
            this.startActivity(intent);
            finish();
        }*/
    }

    private void validarLogin(String email, String senha){
        /*List<Usuario> list = usuarioBox.getAll();
        int tamanho = list.size()-1;

        for(int i = 0; i <= tamanho; i++) {
            if (!email.equals(list.get(i).getEmail()) && !senha.equals(list.get(i).getSenha())) {
                list.remove(i);
            }
        }
        tamanho = list.size();
        if(tamanho != 1){
            Toast.makeText(this, "Dados Incorretos", Toast.LENGTH_SHORT).show();
        }*/

        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login concluido", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, ListaMedicamentoActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Dados incorretos", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}


