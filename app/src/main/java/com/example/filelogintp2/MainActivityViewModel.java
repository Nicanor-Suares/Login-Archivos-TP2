package com.example.filelogintp2;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.filelogintp2.models.Usuario;
import com.example.filelogintp2.requests.ApiClient;
import com.example.filelogintp2.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login(String mail, String pass) {
        Usuario usuario = ApiClient.login(context, mail, pass);
        if (usuario == null) {
            Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(context, RegistroActivity.class);

//      Guardar el usuario en un Intent
        intent.putExtra("logeado", true);

//        Navegar a la actividad
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void registrar() {
        Intent intent = new Intent(context, RegistroActivity.class);
//        Guardar el usuario en un Intent
        intent.putExtra("logeado", false);

//        Navegar a la actividad
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}