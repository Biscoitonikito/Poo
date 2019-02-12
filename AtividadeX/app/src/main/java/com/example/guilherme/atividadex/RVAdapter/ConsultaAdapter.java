package com.example.guilherme.atividadex.RVAdapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.activity.FormularioMedicamentoActivity;
import com.example.guilherme.atividadex.model.Consulta;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
public class ConsultaAdapter{}

/*public class ConsultaAdapter extends RecyclerView.Adapter<ConsultaAdapter.ViewHolder> {

    private Box<Consulta> consultaBox;
    private List<Consulta> consultaList;
    private Box<Logado> logadoBox;
    private Context context;

    public ConsultaAdapter(Context context, Box<Consulta> consultaBox, Box<Logado> logadoBox){
        this.context = context;
        this.consultaBox = consultaBox;
        this.logadoBox = logadoBox;
        this.consultaList = consultaDoUsuario();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        View linha = inflater.inflate(R.layout.item_medicamento_adapter, viewGroup, false);
        return new ViewHolder(linha);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Consulta consulta = consultaList.get(i);
        viewHolder.endeConsulta.setText(consulta.getEndereco());
        viewHolder.hospitalConsulta.setText(consulta.getHospital());
        viewHolder.medicoConsulta.setText(consulta.getMedico());
        viewHolder.dataehoraConsulta.setText(consulta.getHora()+ "hora(s)" + consulta.getData());

        configuraClick(viewHolder.itemView, consulta, i);
    }

    @Override
    public int getItemCount() {
        return this.consultaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView endeConsulta;
        private TextView hospitalConsulta;
        private TextView medicoConsulta;
        private TextView dataehoraConsulta;
        ViewHolder(View itemView) {
            super(itemView);

            endeConsulta = itemView.findViewById(R.id.endereco_consulta);
            hospitalConsulta = itemView.findViewById(R.id.hospital_consulta);
            medicoConsulta = itemView.findViewById(R.id.medico_consulta);
            dataehoraConsulta = itemView.findViewById(R.id.data_hora_consulta);
        }
    }

    private void configuraClick(View itemView, Consulta consulta, int position) {
        itemView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, FormularioMedicamentoActivity.class);
            intent.putExtra("medicamentoId", consulta.getId());
            context.startActivity(intent);
        });

        itemView.setOnLongClickListener((view) -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_item_medicamento, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener((item) -> {
                switch (item.getItemId()) {
                    case R.id.op_remover:
                        removerConsulta(consulta, position);
                        break;
                }
                return false;
            });
            popupMenu.show();
            return true;
        });

    }

    private void removerConsulta(Consulta consulta, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);

        builder.setTitle("Confirmação:");
        builder.setMessage("Desejar remover esta consulta ?");
        builder.setPositiveButton("Sim", (dialogInterface, i) -> {
            this.consultaList.remove(consulta);
            consultaBox.remove(consulta);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });
        builder.setNegativeButton("NÃO", null);
        builder.create().show();
    }

    private List<Consulta> consultaDoUsuario(){
        List<Consulta> consultaList = consultaBox.getAll();
        List<Consulta> tempList = new ArrayList<>();
        List<Logado> logado = logadoBox.getAll();

        for (int i = 0; i < consultaList.size(); i++) {
            if (consultaList.get(i).getIdUsuario() == logado.get(0).getIdLogado()) {
                tempList.add(consultaList.get(i));
            }
        }
        return tempList;
    }
}*/