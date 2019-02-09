package com.example.guilherme.atividadex.controller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.guilherme.atividadex.RVAdapter.MedicamentoAdapter;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MedicamentoController {

    //METODOS ESPECIFICOS PARA CRIAÇAO DE REMEDIOS;
    public static Medicamento criarMedicamento(Context context, String nome, String descricao,
                                               String validade, String periodo, long id){

        switch (MedicamentoController.validarDados(nome,descricao,validade,periodo)){
            case 0:
                Calendar hora_minuto = Calendar.getInstance();
                int hora = hora_minuto.get(Calendar.HOUR_OF_DAY);
                int minuto = hora_minuto.get(Calendar.MINUTE);
                int periodoInt = Integer.parseInt(periodo);
                return new Medicamento(nome,descricao,validade,periodoInt,hora,minuto, id);


            case 1:
                Toast.makeText(context, "PREENCHA OS CAMPOS", Toast.LENGTH_LONG).show();
                break;
        }
        return null;
    }

    private static int validarDados(String nome, String descricao, String validade, String periodo){

        if(!nome.isEmpty()){
            if (!descricao.isEmpty()){
                if (!validade.isEmpty()){
                    if(!periodo.isEmpty()){
                        return 0;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

}
