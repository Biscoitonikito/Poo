package com.example.guilherme.atividadex.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.RVAdapter.MedicamentoAdapter;
import com.example.guilherme.atividadex.controller.MedicamentoController;
import com.example.guilherme.atividadex.controller.NotificacaoController;
import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

import io.objectbox.Box;

//TUDO QUE ESTA COMENTADO SÃO MUDANÇAS QUE FIZ PRA PODER ADPTAR A MUDANÇA DO PROJETO
//RETIREI O FIREBASE E DEIXEI APENAS O OBJECT, PARA ASSIM PRIORIZAR SO A FUNCIONALIDADE DOS METODOS
public class ListaMedicamentoActivity extends AppCompatActivity {

    /*private FirebaseAuth auth;
    private DatabaseReference reference;
    private ValueEventListener valueEventListener;
    private Usuario usuario;*/

    private RecyclerView recyclerViewMedicamentos;
    private Box<Usuario> usuarioBox;
    private Box<Logado> logadoBox;
    private Box<Medicamento> medicamentoBox;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicamento);

        setupAll();
        verificarHorario();
        notificar();
        reloadData();
        /*List<Logado> logado = logadoBox.getAll();
        Usuario usuario = usuarioBox.get(logado.get(0).getIdLogado());
        Toast.makeText(this, ""+ usuario.getTelefone(), Toast.LENGTH_LONG).show();*/

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
        //auth.signOut();
        logadoBox.removeAll();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void setupAll() {
        /*auth = FireStore.getAuth();
        reference = FireStore.getReference();*/

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        logadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        medicamentoBox = ((App) getApplication()).getBoxStore().boxFor(Medicamento.class);
        recyclerViewMedicamentos = findViewById(R.id.recyclewView_principal);

    }

    public void novoMedicamento(View view){
        Intent intent = new Intent(this, FormularioMedicamentoActivity.class);
        startActivity(intent);
    }

    private void reloadData(){
        MedicamentoAdapter adapter = new MedicamentoAdapter(this, medicamentoBox, logadoBox);
        recyclerViewMedicamentos.setAdapter(adapter);
        recyclerViewMedicamentos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMedicamentos.setHasFixedSize(true);
    }

    public void verificarHorario(){
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        List<Medicamento> newMedicamentoList = MedicamentoController.verificarHorario(medicamentoList, this);
        //medicamentoBox.removeAll();
        medicamentoBox.put(newMedicamentoList);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void notificar(){
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        NotificacaoController.notificar(medicamentoList,this, "Está na hora de olhar seus medicamentos", mNotifyMgr, notificationManager);
        }
}
