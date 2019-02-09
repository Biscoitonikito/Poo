package com.example.guilherme.atividadex.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.controller.UsuarioController;
import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;

//TUDO QUE ESTA COMENTADO SÃO MUDANÇAS QUE FIZ PRA PODER ADPTAR A MUDANÇA DO PROJETO
//RETIREI O FIREBASE E DEIXEI APENAS O OBJECT, PARA ASSIM PRIORIZAR SO A FUNCIONALIDADE DOS METODOS
public class CadastrarActivity extends AppCompatActivity {

    //private DatabaseReference reference;
    //private FirebaseAuth auth;
    //App app = (App) getApplication();

    private EditText emailUsu;
    private EditText nomeUsu;
    private EditText senhaUsu;
    private EditText confirmSenhaUsu;
    private EditText telUsu;
    private EditText endeUsu;

    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        setupAll();
    }


    //Inicializa todas as variaveis que irão ser utilizadas
    private void setupAll(){
        //reference = FireStore.getReference();
        //auth = FireStore.getAuth();

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        emailUsu = findViewById(R.id.email_usuario);
        nomeUsu = findViewById(R.id.nome_usuario);
        senhaUsu = findViewById(R.id.senha_usuario);
        confirmSenhaUsu = findViewById(R.id.confirma_senha_usuario);
        endeUsu = findViewById(R.id.endereco_usuario);
        telUsu = findViewById(R.id.telefone_usuario);
    }

    //Coloca o usuario dentro da box e encerra a activity
    public void cadastrar(View view){
        String email = emailUsu.getText().toString();
        String nome = nomeUsu.getText().toString();
        String senha = senhaUsu.getText().toString();
        String confirmSenha = confirmSenhaUsu.getText().toString();
        String endereco = endeUsu.getText().toString();
        String telefone = telUsu.getText().toString();
        List<Usuario> usuarioList = usuarioBox.getAll();

        if(UsuarioController.cadastrarUsuario(this,usuarioList,email,senha,confirmSenha,nome, endereco,telefone)!= null){
            Toast.makeText(this, "CADASTRO CONCLUIDO", Toast.LENGTH_LONG).show();
            usuarioBox.put(Objects.requireNonNull(UsuarioController.cadastrarUsuario(this, usuarioList, email, senha, confirmSenha, nome,
                    endereco, telefone)));
            finish();
        }
    }


    /*public void erroCadastro(Task<AuthResult> task){
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
                        reference.child("usuario").child(usuario.getNome()).setValue(usuario);
                        //Toast.makeText(this, "DEU CERTO", Toast.LENGTH_LONG).show();
                        //referenceUsuario.child("usuario").child(usuario.getEmail()).setValue(usuario);
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
    }*/
}
