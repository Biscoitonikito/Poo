package com.example.guilherme.atividadex.RVAdapter;

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

import com.example.guilherme.atividadex.activity.FormularioMedicamentoActivity;
import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;


public class MedicamentoAdapter extends RecyclerView.Adapter<MedicamentoAdapter.ViewHolder> {

    private Box<Medicamento> medicamentoBox;
    private List<Medicamento> medicamentoList;
    private Box<Logado> logadoBox;
    private Context context;

    public MedicamentoAdapter(Context context, Box<Medicamento> medicamentoBox, Box<Logado> logadoBox) {
        this.context = context;
        this.medicamentoBox = medicamentoBox;
        this.logadoBox = logadoBox;
        this.medicamentoList = remedioDoUsuario();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final LayoutInflater inflater = LayoutInflater.from(context);
        View linha = inflater.inflate(R.layout.item_medicamento_adapter, parent, false);
        return new ViewHolder(linha);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicamento medicamento = this.medicamentoList.get(position);

        holder.nomeMedicamento.setText(medicamento.getNome());
        holder.descricaoMedicamento.setText(medicamento.getDescricao());
        holder.validadeMedicamento.setText(medicamento.getValidade());

        configuraClick(holder.itemView, medicamento, position);
    }

    @Override
    public int getItemCount() {
        return this.medicamentoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeMedicamento;
        private TextView descricaoMedicamento;
        private TextView validadeMedicamento;

        ViewHolder(View itemView) {
            super(itemView);

            nomeMedicamento = itemView.findViewById(R.id.nome_medicamento);
            descricaoMedicamento = itemView.findViewById(R.id.descricao_medicamento);
            validadeMedicamento = itemView.findViewById(R.id.validade_medicamento);

        }
    }

    private void configuraClick(View itemView, Medicamento medicamento, int position) {

        itemView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, FormularioMedicamentoActivity.class);
            intent.putExtra("medicamentoId", medicamento.getId());
            context.startActivity(intent);
        });

        itemView.setOnLongClickListener((view) -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_item_medicamento, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener((item) -> {
                switch (item.getItemId()) {
                    case R.id.op_remover:
                        removerMedicamento(medicamento, position);
                        break;
                }
                return false;
            });
            popupMenu.show();
            return true;
        });
    }

    private void removerMedicamento(Medicamento medicamento, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);

        builder.setTitle("Confirmação:");
        builder.setMessage("Desejar remover o medicamento " + medicamento.getNome() + "?");
        builder.setPositiveButton("Sim", (dialogInterface, i) -> {
            this.medicamentoList.remove(medicamento);
            medicamentoBox.remove(medicamento);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });
        builder.setNegativeButton("NÃO", null);
        builder.create().show();
    }

    private List<Medicamento> remedioDoUsuario(){
        List<Medicamento> medicamentoList = medicamentoBox.getAll();
        List<Medicamento> tempList = new ArrayList<>();
        List<Logado> logado = logadoBox.getAll();

        for (int i = 0; i < medicamentoList.size(); i++) {
            if (medicamentoList.get(i).getIdUsuario() == logado.get(0).getIdLogado()) {
                tempList.add(medicamentoList.get(i));
            }
        }
        return tempList;
    }
}