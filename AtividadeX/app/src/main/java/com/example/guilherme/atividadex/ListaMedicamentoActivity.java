package com.example.guilherme.atividadex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.guilherme.atividadex.RVAdapter.MedicamentoAdapter;
import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

import io.objectbox.Box;

public class ListaMedicamentoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMedicamentos;
    private Usuario usuario;
    private Box<Usuario> usuarioBox;
    private Box<Logado> usuarioLogadoBox;
    private Box<Medicamento> medicamentoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicamento);

        setupAll();
        reloadData();
    }

    @Override
    protected  void onResume(){
        super.onResume();
        reloadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_medicamento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_sair){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        usuarioLogadoBox.removeAll();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void setupAll() {

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        medicamentoBox = ((App) getApplication()).getBoxStore().boxFor(Medicamento.class);
        List<Logado> logados = usuarioLogadoBox.getAll();
        usuario = usuarioBox.get(logados.get(0).getIdLogado());
        TextView informacoesCalendario = findViewById(R.id.informacoes_calendario);
        //List<Medicamento> medicamentoList = medicamentoBox.getAll();

        recyclerViewMedicamentos = findViewById(R.id.recyclewView_principal);

        //Calendar calendar = Calendar.getInstance();

        //informacoesCalendario.setText(""+ calendar.getTime());
        informacoesCalendario.setText("TEMPORARIO");

    }

    public void novoMedicamento(View view){
        Intent intent = new Intent(this, FormularioMedicamentoActivity.class);
        startActivity(intent);
    }

    private void reloadData(){
        MedicamentoAdapter adapter = new MedicamentoAdapter(this, medicamentoBox);
        recyclerViewMedicamentos.setAdapter(adapter);
        recyclerViewMedicamentos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMedicamentos.setHasFixedSize(true);
    }
}
