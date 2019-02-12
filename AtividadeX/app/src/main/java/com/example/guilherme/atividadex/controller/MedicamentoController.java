package com.example.guilherme.atividadex.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.guilherme.atividadex.model.Medicamento;

import java.util.Calendar;
import java.util.List;

public class MedicamentoController {

    //METODOS ESPECIFICOS PARA CRIAÇAO E EDIÇÃO DE MEDICAMENTOS
    //Este metodo recebe os dados entre eles um medicamento, pega-se a hora e minuto atual
    // e verifica-se se o medicamento recebido e nulo em caso de ser
    //nulo ele cria um novo medicamento com as informações recebidas se não ele atualiza
    //os dados do medicamento ja existente
    public static Medicamento criarMedicamento(String nome, String descricao,
                                               String validade, String periodo, long id, Medicamento medicamento){

        if(MedicamentoController.validarDados(nome,descricao,validade,periodo)) {
            Calendar hora_minuto = Calendar.getInstance();
            int hora = hora_minuto.get(Calendar.HOUR_OF_DAY);
            int minuto = hora_minuto.get(Calendar.MINUTE);
            int periodoInt = Integer.parseInt(periodo);

            if (medicamento == null) {
                medicamento = new Medicamento(nome, descricao, validade, periodoInt, hora, minuto, id);
                medicamento.atualizaHora();
                return medicamento;
            } else {
                medicamento.atualizaDados(nome, descricao, validade, periodoInt);
                return medicamento;
            }
        }
        else{
            return null;
        }

    }

    //Verifica se a algum campo vazio
    //O codigo está em escada, mas é por motivos de que quando estava fazendo as comparações em uma linha so
    //estava dando erro;
    private static boolean validarDados(String nome, String descricao, String validade, String periodo){

        if(!nome.isEmpty()){
            if (!descricao.isEmpty()){
                if (!validade.isEmpty()){
                    if(!periodo.isEmpty()){
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }


    //METODOS PARA LISTA MEDICAMENTO PARA ALTERAÇÕES DE ESTADO;

    //Recebe uma lista de medicamentos e repassa todos os elementos para o metodo verificaHorario de medicamento
    //E retorna uma lista atualizada
    public static List<Medicamento> verificarHorario(List<Medicamento> medicamentoList){
        Calendar hora_minuto = Calendar.getInstance();
        int hora = hora_minuto.get(Calendar.HOUR_OF_DAY);
        int minuto = hora_minuto.get(Calendar.MINUTE);

        for(int i = 0; i < medicamentoList.size(); i++){
            medicamentoList.get(i).verificarHorario(hora,minuto);
        }

        return medicamentoList;
    }

    //Recebe uma lista de medicamentos e repassa todos os elementos para o metodo verificaEsqueceu de medicamento
    //E retorna uma lista atualizada
    public static List<Medicamento> verificaEsqueceu(List<Medicamento> medicamentoList){
        Calendar hora_minuto = Calendar.getInstance();
        int hora = hora_minuto.get(Calendar.HOUR_OF_DAY);
        int minuto = hora_minuto.get(Calendar.MINUTE);

        for(int i = 0; i < medicamentoList.size(); i++){
            medicamentoList.get(i).esqueceuHorario(hora, minuto);
        }

        return medicamentoList;
    }

    //Recebe uma lista de medicamentos e repassa todos os elementos para o metodo lembraMedicamento de medicamento
    //E retorna uma lista atualizada
    public static List<Medicamento> lembrarMedicamento(List<Medicamento> medicamentoList){
        for(int i = 0; i < medicamentoList.size(); i++){
            medicamentoList.get(i).lembrarMedicamento();
        }

        return medicamentoList;
    }

    //Em caso de algum medicamento estiver em estado de lembrar true retorna true
    public static boolean medicamentoALembrar(List<Medicamento> medicamentoList, Context context){
        for(int i = 0; i < medicamentoList.size(); i++){
            if(medicamentoList.get(i).isLembrar()){
                return true;
            }
        }
        return false;
    }

    //Recebe a lista de medicamentos e em caso de ao menos um estiver em estado de lembrar como true,
    //retorna true
    public static boolean lembrar(List<Medicamento> medicamentoList) {
        for (int i = 0; i < medicamentoList.size(); i++) {
            if (medicamentoList.get(i).isLembrar()) {
                return true;
            }
        }
        return false;
    }
}
