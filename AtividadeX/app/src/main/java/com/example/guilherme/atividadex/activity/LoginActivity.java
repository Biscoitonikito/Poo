package com.example.guilherme.atividadex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.controller.UsuarioController;
import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Usuario;
import com.example.guilherme.atividadex.model.UsuarioCursor;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;

//TUDO QUE ESTA COMENTADO NO FIM DO CODIGO SÃO MUDANÇAS QUE FIZ PRA PODER ADPTAR A MUDANÇA DO PROJETO
//RETIREI O FIREBASE E DEIXEI APENAS O OBJECT, PARA ASSIM PRIORIZAR SO A FUNCIONALIDADE DOS METODOS
public class LoginActivity extends AppCompatActivity {

    private EditText emailLogin;
    private EditText senhaLogin;

    private Box<Usuario> usuarioBox;
    private Box<Logado> logadoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioLogado();
    }

    private void setupAll() {

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        logadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        emailLogin = findViewById(R.id.email_loguin);
        senhaLogin = findViewById(R.id.senha_login);
    }

    //Caso tenha algum usuario logado ele ja inicia a lista do medicamento com os dados dele
    private void usuarioLogado(){
        setupAll();
        if(!logadoBox.isEmpty()){
            Intent intent = new Intent(this, ListaMedicamentoActivity.class);
            this.startActivity(intent);
            finish();
        }
    }

    //Inicia a tela de cadastro
    public void cadastrar(View view){
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }

    //Passa o email e senha para o metodo login da classe  UsuarioController, em caso de existir Usuario
    //Com aquela informações e retornado o Id dele e colocado na Box de Logado se não e retornado null e um Toast
    //exibido
    public void logar(View view) {
        String email = emailLogin.getText().toString();
        String senha = senhaLogin.getText().toString();
        List<Usuario> usuarioList = usuarioBox.getAll();

        if (UsuarioController.loginUsuario(usuarioList, email, senha) != null) {
            logadoBox.put(Objects.requireNonNull(UsuarioController.loginUsuario(usuarioList, email, senha)));
            Toast.makeText(this, "LOGIN CONCLUIDO", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, ListaMedicamentoActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "DADOS INCORRETOS OU \n USUARIO NÃO EXISTE", Toast.LENGTH_LONG).show();
        }
    }

}


/*
    private FirebaseAuth auth;
    auth = FireStore.getAuth();

    private void validarLogin(String email, String senha){

        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    List<Usuario> a = usuarioBox.getAll();
                    Logado b = new Logado();
                    b.setIdLogado(a.get(0).getId());
                    usuarioLogadoBox.put(b);
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
*/