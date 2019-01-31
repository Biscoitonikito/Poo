package com.example.guilherme.atividadex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

import io.objectbox.Box;

public class CadastrarActivity extends AppCompatActivity {
    private EditText nomeUsu;
    private EditText senhaUsu;
    private EditText confimSenhaUsu;
    private EditText endeUsu;
    private EditText telUsu;
    private EditText cpfUsu;

    Usuario usuario;
    Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuario = new Usuario();
        setupViews();
    }

    public void cadastrar(View view){
        if(validarDados()) {
            usuario.setNome(nomeUsu.getText().toString());
            usuario.setEndereco(endeUsu.getText().toString());
            usuario.setTelefone(telUsu.getText().toString());
            usuario.setCpf(cpfUsu.getText().toString());

            usuarioBox.put(usuario);

            List<Usuario> list = usuarioBox.getAll();
            Toast.makeText(this, "Cadastro Concluído", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "Dados incompletos ou ja utilizados", Toast.LENGTH_SHORT).show();
        }

    }

    private void setupViews(){

        nomeUsu = findViewById(R.id.nome_usuario);
        senhaUsu = findViewById(R.id.senha_usuario);
        confimSenhaUsu = findViewById(R.id.confirma_senha_usuario);
        endeUsu = findViewById(R.id.endereco_usuario);
        telUsu = findViewById(R.id.telefone_usuario);
        cpfUsu = findViewById(R.id.cpf_usuario);

    }

    private boolean validarDados(){
        List<Usuario> list = usuarioBox.getAll();

        int tamanhoLista = list.size()-1;

        String nome = nomeUsu.getText().toString();
        String senha = senhaUsu.getText().toString();
        String confirmSenha = confimSenhaUsu.getText().toString();
        String endereco = endeUsu.getText().toString();
        String telefone = telUsu.getText().toString();
        String cpf = cpfUsu.getText().toString();

        if (nome.equals("") || senha.equals("") || confirmSenha.equals("") || endereco.equals("") || telefone.equals("") || cpf.equals("")) {
            return false;
        }
        else {
            if(senha.equals(confirmSenha)){
                for (int i = 0; i <= tamanhoLista-1 ; i++) {
                    if (!list.get(i).getCpf().equals(cpf)) {
                        list.remove(i);
                    }
                    if (!list.get(i).getNome().equals(nome) && !list.get(i).getEndereco().equals(endereco)) {
                        list.remove(i);
                    }
                }
                if(list.isEmpty()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }

    }
}
