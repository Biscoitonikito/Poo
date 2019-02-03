package com.example.guilherme.atividadex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.dao.FireStore;
import com.example.guilherme.atividadex.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;

public class CadastrarActivity extends AppCompatActivity {
    private EditText emailUsu;
    private EditText nomeUsu;
    private EditText senhaUsu;
    private EditText confimSenhaUsu;
    private EditText endeUsu;
    private EditText telUsu;
    private EditText cpfUsu;

    private FirebaseAuth auth;
    private Usuario usuario;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        setupAll();
    }

    private void setupAll(){
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuario = new Usuario();
        emailUsu = findViewById(R.id.email_usuario);
        nomeUsu = findViewById(R.id.nome_usuario);
        senhaUsu = findViewById(R.id.senha_usuario);
        confimSenhaUsu = findViewById(R.id.confirma_senha_usuario);
        endeUsu = findViewById(R.id.endereco_usuario);
        telUsu = findViewById(R.id.telefone_usuario);
        cpfUsu = findViewById(R.id.cpf_usuario);
        auth = FireStore.getAuth();

    }

    public void cadastrar(View view){

        if(validarDados()) {
            auth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(CadastrarActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        usuarioBox.put(usuario);
                        List<Usuario> users = usuarioBox.getAll();
                        usuario = users.get(0);
                        FirebaseUser user = Objects.requireNonNull(task.getResult()).getUser();
                        FireStore.salvarUsuario(usuario);
                        Toast.makeText(CadastrarActivity.this, "Cadastro Concluído", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        erroCadastro(task);
                    }
                }
            });
        }
        else {
            Toast.makeText(CadastrarActivity.this, "CAMPOS NÃO PREENCHIDOS CORRETAMENTE", Toast.LENGTH_SHORT).show();
        }
    }

    //Retorna true ou false para usuarios existentes
    private boolean validarDados(){

        if(!nomeUsu.getText().toString().isEmpty() || !senhaUsu.getText().toString().isEmpty() || !confimSenhaUsu.getText().toString().isEmpty()
                || !endeUsu.getText().toString().isEmpty()
                || !telUsu.getText().toString().isEmpty() || !cpfUsu.getText().toString().isEmpty() || !emailUsu.getText().toString().isEmpty()){

            if(senhaUsu.getText().toString().equals(confimSenhaUsu.getText().toString())){
                usuario.setEmail(emailUsu.getText().toString());
                usuario.setNome(nomeUsu.getText().toString());
                usuario.setSenha(senhaUsu.getText().toString());
                usuario.setEndereco(endeUsu.getText().toString());
                usuario.setTelefone(telUsu.getText().toString());
                usuario.setCpf(cpfUsu.getText().toString());
                return true;
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }
    }

    public void erroCadastro(Task<AuthResult> task){
        String erro = "";
        try{
            throw Objects.requireNonNull(task.getException());
        }catch (FirebaseAuthWeakPasswordException e){
            erro = "SENHA MUITO FRACA";
        }catch (FirebaseAuthInvalidCredentialsException e){
            erro =  "DADOS INCORRETOS";
        }catch (FirebaseAuthUserCollisionException e){
            erro = "ESSE EMAIL JÁ FOI CADASTRADO";
        }catch (FirebaseNetworkException e){
            erro = "DISPOSITIVO NÃO ESTÁ CONECTADO A UMA REDE";
        }catch (Exception e){
            erro = "ERRO NO SISTEMA";
            e.printStackTrace();
        }
        Toast.makeText(CadastrarActivity.this, ""+erro, Toast.LENGTH_SHORT).show();
    }
}
