package com.example.connectsalud;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroPaciente extends AppCompatActivity {

    EditText agregardnipaciente, agregarnombrepaciente, agregarapellidopaciente,
            agregartelefonopaciente, agregarnacimientopaciente, agregarmailpaciente,
            agregarpasspaciente, agregarpassagainpaciente;
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registropaciente);

        agregardnipaciente = findViewById(R.id.agregardnipaciente);
        agregarnombrepaciente = findViewById(R.id.agregarnombrepaciente);
        agregarapellidopaciente = findViewById(R.id.agregarapellidopaciente);
        agregartelefonopaciente = findViewById(R.id.agregartelefonopaciente);
        agregarnacimientopaciente = findViewById(R.id.agregarnacimientopaciente);
        agregarmailpaciente = findViewById(R.id.agregarmailpaciente);
        agregarpasspaciente = findViewById(R.id.agregarpasspaciente);
        agregarpassagainpaciente = findViewById(R.id.agregarpassagainpaciente);

        admin = new AdminSQLiteOpenHelper(this);
    }

    public void agregarPaciente(View view) {
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dni", agregardnipaciente.getText().toString());
        registro.put("nombre", agregarnombrepaciente.getText().toString());
        registro.put("apellido", agregarapellidopaciente.getText().toString());
        registro.put("telefono", agregartelefonopaciente.getText().toString());
        registro.put("fecha_nacimiento", agregarnacimientopaciente.getText().toString());
        registro.put("email", agregarmailpaciente.getText().toString());
        registro.put("pass", agregarpasspaciente.getText().toString());
        registro.put("passagain", agregarpassagainpaciente.getText().toString());

        // Insertar datos en la base de datos
        db.insert("usuarios", null, registro);

        // Guardar datos en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("dni", agregardnipaciente.getText().toString());
        editor.putString("nombre", agregarnombrepaciente.getText().toString());
        editor.putString("apellido", agregarapellidopaciente.getText().toString());
        editor.putString("telefono", agregartelefonopaciente.getText().toString());
        editor.putString("fecha_nacimiento", agregarnacimientopaciente.getText().toString());
        editor.putString("email", agregarmailpaciente.getText().toString());
        //
        editor.apply();

        // Limpiar campos de entrada y mostrar mensaje de éxito
        limpiarCampos();
        db.close();
        Toast.makeText(this, "Se almacenó el usuario", Toast.LENGTH_SHORT).show();
    }

    private void limpiarCampos() {
        // Limpiar campos de entrada
        agregardnipaciente.setText("");
        agregarnombrepaciente.setText("");
        agregarapellidopaciente.setText("");
        agregartelefonopaciente.setText("");
        agregarnacimientopaciente.setText("");
        agregarmailpaciente.setText("");
        agregarpasspaciente.setText("");
        agregarpassagainpaciente.setText("");
    }
}




/*package com.example.connectsalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroPaciente extends AppCompatActivity {

    EditText agregardnipaciente, agregarnombrepaciente, agregarapellidopaciente, agregartelefonopaciente, agregarnacimientopaciente, agregarmailpaciente, agregarpasspaciente, agregarpassagainpaciente, agregartipousuariopaciente;

    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registropaciente);

        agregardnipaciente = findViewById(R.id.agregardnipaciente);
        agregarnombrepaciente = findViewById(R.id.agregarnombrepaciente);
        agregarapellidopaciente = findViewById(R.id.agregarapellidopaciente);
        agregartelefonopaciente = findViewById(R.id.agregartelefonopaciente);
        agregarnacimientopaciente = findViewById(R.id.agregarnacimientopaciente);
        agregarmailpaciente = findViewById(R.id.agregarmailpaciente);
        agregarpasspaciente = findViewById(R.id.agregarpasspaciente);
        agregarpassagainpaciente = findViewById(R.id.agregarpassagainpaciente);
        admin = new AdminSQLiteOpenHelper(this, "db1", null, 1);
    }

    public void agregarPaciente(View view)
    {
        SQLiteDatabase db =admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("iddni",agregardnipaciente.getText().toString());
        registro.put("nombre",agregarnombrepaciente.getText().toString());
        registro.put("apellido",agregarapellidopaciente.getText().toString());
        registro.put("telefono",agregartelefonopaciente.getText().toString());
        registro.put("nacimiento",agregarnacimientopaciente.getText().toString());
        registro.put("email",agregarmailpaciente.getText().toString());
        registro.put("pass",agregarpasspaciente.getText().toString());
        registro.put("tipousuario",agregartipousuariopaciente.getText().toString());
        db.insert("usuarios",null, registro);

        agregardnipaciente.setText("");
        agregarnombrepaciente.setText("");
        agregarapellidopaciente.setText("");
        agregartelefonopaciente.setText("");
        agregarnacimientopaciente.setText("");
        agregarmailpaciente.setText("");
        agregarpasspaciente.setText("");
        agregartipousuariopaciente.setText("paciente");
        db.close();
        Toast.makeText(this, "Se almacenó el usuario", Toast.LENGTH_SHORT).show();
    }
}*/