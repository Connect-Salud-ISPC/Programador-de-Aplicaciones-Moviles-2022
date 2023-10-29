package com.example.connectsalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroPaciente extends AppCompatActivity {
    EditText agregardnipaciente, agregarnombrepaciente, agregarapellidopaciente, agregartelefonopaciente, agregarnacimientopaciente, agregarmailpaciente, agregarpasspaciente, agregarpassagainpaciente, agregartipousuariopaciente;

    private DataBaseHelper dbHelper;

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
    }

    public void agregarPaciente(View view) {
        ContentValues registro = new ContentValues();
        registro.put(DataBaseHelper.COL_IDDNI,agregardnipaciente.getText().toString());
        registro.put(DataBaseHelper.COL_NOMBRE,agregarnombrepaciente.getText().toString());
        registro.put(DataBaseHelper.COL_APELLIDO,agregarapellidopaciente.getText().toString());
        registro.put(DataBaseHelper.COL_TELEFONO,agregartelefonopaciente.getText().toString());
        registro.put(DataBaseHelper.COL_NACIMIENTO,agregarnacimientopaciente.getText().toString());
        registro.put(DataBaseHelper.COL_EMAIL,agregarmailpaciente.getText().toString());
        registro.put(DataBaseHelper.COL_PASS,agregarpasspaciente.getText().toString());
        registro.put(DataBaseHelper.COL_TIPOUSUARIO,agregartipousuariopaciente.getText().toString());

        dbHelper = new DataBaseHelper(this);

        agregardnipaciente.setText("");
        agregarnombrepaciente.setText("");
        agregarapellidopaciente.setText("");
        agregartelefonopaciente.setText("");
        agregarnacimientopaciente.setText("");
        agregarmailpaciente.setText("");
        agregarpasspaciente.setText("");
        agregartipousuariopaciente.setText("paciente");
        dbHelper.close();
        Toast.makeText(this, "Se almacenó el usuario", Toast.LENGTH_SHORT).show();
    }

}