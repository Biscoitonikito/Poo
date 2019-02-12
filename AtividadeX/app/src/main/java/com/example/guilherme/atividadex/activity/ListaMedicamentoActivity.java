package com.example.guilherme.atividadex.activity;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.RVAdapter.MedicamentoAdapter;
import com.example.guilherme.atividadex.controller.MedicamentoController;
import com.example.guilherme.atividadex.controller.NotificacaoController;
import com.example.guilherme.atividadex.controller.UsuarioController;
import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Notificacao;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;

//TUDO QUE ESTA COMENTADO NO FIM DO CODIGO SÃO MUDANÇAS QUE FIZ PRA PODER ADPTAR A MUDANÇA DO PROJETO
//RETIREI O FIREBASE E DEIXEI APENAS O OBJECT, PARA ASSIM PRIORIZAR SO A FUNCIONALIDADE DOS METODOS
public class ListaMedicamentoActivity extends AppCompatActivity {

    private Box<Usuario> usuarioBox;
    private Usuario usuario;
    private Box<Logado> logadoBox;
    private Box<Medicamento> medicamentoBox;
    private Box<Notificacao> notificacaoBox;
    BottomNavigationView navigation;
    private View fabButton;
    private View fabButtonConfirm;
    private TextView information_txt_one;
    private TextView information_txt_two;
    private TextView informacao_nome;
    private TextView informacao_ende;
    private TextView informacao_tel;
    private TextView informacao_id;
    private View informatio_id_confirm;
    private EditText information_id_usuario;
    private RecyclerView recyclerViewMedicamentos;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicamento);

        setupAll();
        buscarUsuario();
        verificarHorarioMedicamento();
        verificarEsqueceuMedicamento();
        ativarFab();
        notificar();
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

    //Zera o Bd que guardava o usuario logado
    private void logout() {
        logadoBox.removeAll();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void setupAll() {
        Objects.requireNonNull(getSupportActionBar()).setTitle("Lista de Medicamentos");
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        logadoBox = ((App) getApplication()).getBoxStore().boxFor(Logado.class);
        medicamentoBox = ((App) getApplication()).getBoxStore().boxFor(Medicamento.class);
        notificacaoBox = ((App) getApplication()).getBoxStore().boxFor(Notificacao.class);
        recyclerViewMedicamentos = findViewById(R.id.recyclewView_principal);
        navigation = findViewById(R.id.navigation_list_medicamento);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fabButton = findViewById(R.id.confirma_medicamento);
        fabButtonConfirm = findViewById(R.id.fab_add_medicamento);
        informacao_nome = findViewById(R.id.informatio_name_usuario);
        informacao_ende = findViewById(R.id.information_ende_usuario);
        informacao_tel = findViewById(R.id.information_tel_usuario);
        informacao_id = findViewById(R.id.informatio_id_usuario);
        information_txt_one = findViewById(R.id.information_text_one);
        information_txt_two = findViewById(R.id.information_text_two);
        informatio_id_confirm = findViewById(R.id.confirma_id_usuario);
        information_id_usuario = findViewById(R.id.id_usuario_monitor);

    }

    //Inicia a tela de formulario de medicamento
    public void novoMedicamento(View view){
        Intent intent = new Intent(this, FormularioMedicamentoActivity.class);
        startActivity(intent);
        finish();
    }

    //Metodo do Fab que se mantem Gone até o momento que se tem medicamento a ser utilizado
    //Esse metodo torna todos os medicamentos utilizados e atualiza o banco
    public void lembrarMedicamento(View view){
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        List<Medicamento> newMedicamentoList = MedicamentoController.lembrarMedicamento(medicamentoList);
        medicamentoBox.removeAll();
        medicamentoBox.put(newMedicamentoList);
        reloadData();
        ativarFab();
    }

    public void criarVinculo(View view){
        long idUsuarioTwo = Long.parseLong(information_id_usuario.getText().toString());
        notificacaoBox.put(NotificacaoController.gerarNovoVinculo(usuario.getId(),idUsuarioTwo,usuario.getNome()));
    }

    private void reloadData(){
        MedicamentoAdapter adapter = new MedicamentoAdapter(this, medicamentoBox, logadoBox);
        recyclerViewMedicamentos.setAdapter(adapter);
        recyclerViewMedicamentos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMedicamentos.setHasFixedSize(true);
    }

    //Verifica se o Medicamento está na hora de ser utilizado, se tiver modifica o layout
    //do medicamento selecionado para que possa se identificar mais facilmente qual deve ser utilizado
    //e atualiza o banco
    public void verificarHorarioMedicamento(){
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        List<Medicamento> newMedicamentoList = MedicamentoController.verificarHorario(medicamentoList);
        medicamentoBox.removeAll();
        medicamentoBox.put(newMedicamentoList);
    }

    //Apos se passar o periodo determinado o medicamento se torna inutilizavel
    //Podendo so ser removido e atualiza o banco
    public void verificarEsqueceuMedicamento(){
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        List<Medicamento> newMedicamentoList = MedicamentoController.verificaEsqueceu(medicamentoList);
        medicamentoBox.removeAll();
        medicamentoBox.put(newMedicamentoList);
    }

    //Notifica caso tenha algum remedio a ser utilizado
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void notificar(){
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        NotificacaoController.notificar(medicamentoList,this, "Está na hora de olhar seus medicamentos", mNotifyMgr, notificationManager);
    }

    //Caso tenha algum medicamento a ser utilizado ativa o fab que contem a função de afirma que ja foi utilizado
    public void ativarFab(){
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        if(MedicamentoController.lembrar(medicamentoList)){
            fabButton.setVisibility(View.VISIBLE);
        }
        else{
            fabButton.setVisibility(View.GONE);
        }
    }

    private void buscarUsuario(){
        List<Logado> logadoList = logadoBox.getAll();
        List<Usuario> usuarioList = usuarioBox.getAll();
        usuario = UsuarioController.buscarUsuarioId(usuarioList,logadoList);
    }

    private void listaSelected(){
        fabButtonConfirm.setVisibility(View.VISIBLE);
        recyclerViewMedicamentos.setVisibility(View.VISIBLE);
        informacao_nome.setVisibility(View.GONE);
        informacao_ende.setVisibility(View.GONE);
        informacao_tel.setVisibility(View.GONE);
        informacao_id.setVisibility(View.GONE);
        information_txt_one.setVisibility(View.GONE);
        information_txt_two.setVisibility(View.GONE);
        informatio_id_confirm.setVisibility(View.GONE);
        information_id_usuario.setVisibility(View.GONE);
        reloadData();
        ativarFab();
    }

    private void usuarioSelected(){
        fabButton.setVisibility(View.GONE);
        fabButtonConfirm.setVisibility(View.GONE);
        recyclerViewMedicamentos.setVisibility(View.GONE);
        informacao_nome.setVisibility(View.VISIBLE);
        informacao_ende.setVisibility(View.VISIBLE);
        informacao_tel.setVisibility(View.VISIBLE);
        informacao_id.setVisibility(View.VISIBLE);
        information_txt_one.setVisibility(View.VISIBLE);
        information_txt_two.setVisibility(View.VISIBLE);
        informatio_id_confirm.setVisibility(View.VISIBLE);
        information_id_usuario.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    private void preencherCampos(){
        informacao_nome.setText("Nome: "+usuario.getNome());
        informacao_ende.setText("Endereço: "+usuario.getEndereco());
        informacao_tel.setText("Telefone: "+ usuario.getTelefone());
        informacao_id.setText("Código: "+usuario.getId());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = (item) ->  {
            switch (item.getItemId()) {
                case R.id.navigation_lista:
                    listaSelected();
                    return true;
                case R.id.navigation_usuario:
                    usuarioSelected();
                    preencherCampos();
                    return true;

            }
            return true;
    };
}

 /*private FirebaseAuth auth;
    private DatabaseReference reference;
    private ValueEventListener valueEventListener;
    private Usuario usuario;

 auth = FireStore.getAuth();
        reference = FireStore.getReference();*/

//auth.signOut();
