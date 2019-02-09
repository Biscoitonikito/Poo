package com.example.guilherme.atividadex.bd;

import com.example.guilherme.atividadex.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

//ESSE PACOTE SERIA PARA O FIREBASE E COMO ESTOU RETIRANDO, NÃO PRECISA DELE, MAS VOU MANTE-LO PQ FUTURAMENTE PENSO EM IMPLANTA-LO
//ENTAO E COMO SE ELE NEM ESTIVESSE NO APP;
public class FireStore {

    private static DatabaseReference reference;
    private static FirebaseAuth auth;

    public static void salvarUsuario(Usuario usuario){
        DatabaseReference referenceUsuario = FireStore.getReference();
        referenceUsuario.child("usuario").child(String.valueOf(usuario.getEmail())).setValue(usuario);
    }

    @Exclude
    public static Map<String, Object> toMap(Usuario usuario){
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("id",usuario.getId());
        hashMap.put("email",usuario.getEmail());
        hashMap.put("senha", usuario.getSenha());
        hashMap.put("nome",usuario.getEndereco());
        hashMap.put("endereco",usuario.getEndereco());
        hashMap.put("telefone",usuario.getTelefone());

        return hashMap;
    }

    public static DatabaseReference getReference() {
        if(reference == null){
            reference = FirebaseDatabase.getInstance().getReference();
        }
        return reference;
    }

    public static FirebaseAuth getAuth() {
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

}
