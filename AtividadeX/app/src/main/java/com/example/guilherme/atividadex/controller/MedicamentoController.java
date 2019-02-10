package com.example.guilherme.atividadex.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.guilherme.atividadex.model.Medicamento;

import java.util.Calendar;
import java.util.List;

public class MedicamentoController {

    //METODOS ESPECIFICOS PARA CRIAÇAO DE REMEDIOS;
    public static Medicamento criarMedicamento(Context context, String nome, String descricao,
                                               String validade, String periodo, long id, Medicamento medicamento){

        switch (MedicamentoController.validarDados(nome,descricao,validade,periodo)){
            case 0:
                Calendar hora_minuto = Calendar.getInstance();
                int hora = hora_minuto.get(Calendar.HOUR_OF_DAY);
                int minuto = hora_minuto.get(Calendar.MINUTE);
                int periodoInt = Integer.parseInt(periodo);

                if(medicamento == null) {
                    medicamento = new Medicamento(nome, descricao, validade, periodoInt, hora, minuto, id);
                    medicamento.atualizaHora();
                    //Toast.makeText(context, ""+hora+ " " + minuto, Toast.LENGTH_LONG).show();
                    //Toast.makeText(context, "a"+teste.getHora()+ " " + teste.getMinuto(), Toast.LENGTH_LONG).show();
                    return medicamento;
                }
                else{
                    medicamento.atualizaDados(nome,descricao,validade,periodoInt);
                    return medicamento;
                }


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



    public static List<Medicamento> verificarHorario(List<Medicamento> medicamentoList, Context context){
        Calendar hora_minuto = Calendar.getInstance();
        int hora = hora_minuto.get(Calendar.HOUR_OF_DAY);
        int minutoInicio = hora_minuto.get(Calendar.MINUTE);

        for(int i = 0; i < medicamentoList.size(); i++){
            if(medicamentoList.get(i).getHora() >= hora){
                int medicamentoMinuto = medicamentoList.get(i).getMinuto();
                if(medicamentoMinuto >= minutoInicio){
                    medicamentoList.get(i).setLembrar();
                }
            }
        }

        return medicamentoList;
    }

}
