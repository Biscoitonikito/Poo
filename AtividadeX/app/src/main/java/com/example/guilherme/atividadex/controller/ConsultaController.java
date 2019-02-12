package com.example.guilherme.atividadex.controller;

import com.example.guilherme.atividadex.model.Consulta;

public class ConsultaController {
    public static Consulta criarConsulta(String endereco, String hospital,
                                         String medico, String data, String hora, long id, Consulta consulta){

        if(ConsultaController.validarDados(endereco, hospital,medico,data,hora)) {
            if(consulta == null){
                consulta = new Consulta(endereco, hospital,medico,data,hora,id);
                return consulta;
            }
            else{
                consulta.atualizaDados(endereco, hospital,medico,data,hora);
                return  consulta;
            }
        }
        return null;
    }

    private static boolean validarDados(String endereco, String hospital,
                                        String medico, String data, String hora){

        if(!endereco.isEmpty()){
            if (!hospital.isEmpty()){
                if (!medico.isEmpty()){
                    if(!data.isEmpty()){
                        return !hora.isEmpty();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
