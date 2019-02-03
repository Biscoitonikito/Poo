package com.example.guilherme.atividadex.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.guilherme.atividadex.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.HashMap;
import java.util.Map;

public class FireStore {

    //private static DatabaseReference referenceUsuario;
    private static DatabaseReference reference;
    private static FirebaseAuth auth;

    public static void salvarUsuario(Usuario usuario){
        DatabaseReference referenceUsuario = FireStore.getReference();
        referenceUsuario.child("usuario").child(String.valueOf(usuario.getId())).setValue(usuario);
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
        hashMap.put("cpf",usuario.getCpf());

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



    /*@SuppressLint("StaticFieldLeak")
    private static  FirebaseFirestore firestore;
    private static Map<Long, Usuario> usuarioMap;
    private  static  DocumentReference usuarioDocument;

    @SuppressLint("UseSparseArrays")
    public FireStore() {
        firestore =FirebaseFirestore.getInstance();
        usuarioMap = new HashMap<>();
        usuarioDocument = FirebaseFirestore.getInstance().document("usuariosData/usuarios");
    }

    public static void criarUsuario(Context context,long id, Usuario usuario){
        usuarioMap.put(id,usuario);
        firestore.collection("usuarios").add(usuarioMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(context, "Usuário Cadastrado", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Dados Incorretos", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public static void puxarUsuario(Context context){
        firestore.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documente : task.getResult()){
                                Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(context, "Not Ok", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }*/


}
