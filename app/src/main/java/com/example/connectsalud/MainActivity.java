package com.example.connectsalud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import com.example.connectsalud.Adaptadores;
import com.example.connectsalud.Adaptadores.ListaUsuariosAdapter;
import com.example.connectsalud.db.DbUsuarios;
import com.example.connectsalud.db.DbHelper;
import com.example.connectsalud.Entidades.Usuarios;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaUsuarios;
    ArrayList<Usuarios> listaArrayUsuarios;
    ListaUsuariosAdapter adapter;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBuscar = findViewById(R.id.txtBuscar);
        listaUsuarios = findViewById(R.id.listaUsuarios);
        fabNuevo = findViewById(R.id.favNuevo);
        listaUsuarios.setLayoutManager(new LinearLayoutManager(this));

        DbUsuarios dbUsuarios = new DbUsuarios(MainActivity.this);

        listaArrayUsuarios = new ArrayList<>();

        adapter = new ListaUsuariosAdapter(dbUsuarios.mostrarUsuarios());
        listaUsuarios.setAdapter(adapter);

        fabNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoRegistro();
            }
        });

        txtBuscar.setOnQueryTextListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void launchRegister(View view) {
        Intent intent = new Intent(this, RegistroPaciente.class);
        startActivity(intent);
    }
}