package com.example.connectsalud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.connectsalud.models.Usuario;
import com.example.connectsalud.models.Turno;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DBNOMBRE = "dbconnectsalud";
    private static final int DBVERSION = 1;

    public static final String TABLAUSUARIOS = "Usuarios";

    // Columnas de la tabla
    public static final String COL_IDDNI = "iddni";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APELLIDO = "apellido";
    public static final String COL_TELEFONO = "telefono";
    public static final String COL_NACIMIENTO = "nacimiento";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASS = "pass";
    public static final String COL_TIPOUSUARIO = "tipousuario";

    private static final String CREARTABLA_USUARIO =
            "CREATE TABLE " + TABLAUSUARIOS + " (" +
                    COL_IDDNI + " INTEGER PRIMARY KEY, " +
                    COL_NOMBRE + " TEXT, " +
                    COL_APELLIDO + " TEXT, " +
                    COL_TELEFONO + " INTEGER, " +
                    COL_NACIMIENTO + " TEXT, " +
                    COL_EMAIL + " TEXT, " +
                    COL_PASS + " TEXT, " +
                    COL_TIPOUSUARIO + " TEXT " +
                    ")";

    public static final String TABLATURNOS = "Turnos";
    public static final String COL_IDTURNO ="idturno";
    public static final String COL_ESPECIALIDAD = "especialidad";
    public static final String COL_PROFESIONAL = "profesional";
    public static final String COL_DIATURNO = "horaturno";
    public static final String COL_HORATURNO = "horaturno";
    public static final String COL_MENSAJE = "mensaje";
    public static final String COL_IDUSUARIO = "iddni";

    private static final String CREARTABLA_TURNO =
            "CREATE TABLE " + TABLATURNOS + " (" +
                    COL_IDTURNO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ESPECIALIDAD + " TEXT, " +
                    COL_PROFESIONAL + " TEXT, " +
                    COL_DIATURNO + " TEXT, " +
                    COL_HORATURNO + " TEXT, " +
                    COL_MENSAJE + " TEXT, " +
                    COL_IDUSUARIO + " TEXT " +
                    ")";

    public DataBaseHelper(Context context) {
        super(context, DBNOMBRE, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREARTABLA_USUARIO); // Crear tabla Usuarios
        db.execSQL(CREARTABLA_TURNO); // Crear tabla Turnero
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLAUSUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLATURNOS);
        onCreate(db);
    }

    public boolean insertarUsuario(Usuario usuario){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_IDDNI, usuario.getIddni());
        contentValues.put(COL_NOMBRE, usuario.getNombre());
        contentValues.put(COL_APELLIDO, usuario.getApellido());
        contentValues.put(COL_TELEFONO, usuario.getTelefono());
        contentValues.put(COL_NACIMIENTO, usuario.getNacimiento());
        contentValues.put(COL_EMAIL, usuario.getEmail());
        contentValues.put(COL_PASS, usuario.getPass());
        contentValues.put(COL_TIPOUSUARIO, usuario.getTipo());
        db.insert(TABLAUSUARIOS, null, contentValues);
        return true;
    }

    /*
    public boolean insertarTurno(Turno turno){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_IDTURNO, turno.getIdturno());
        contentValues.put(COL_ESPECIALIDAD, turno.getEspecialidad());
        contentValues.put(COL_PROFESIONAL, turno.getProfesional());
        contentValues.put(COL_DIATURNO, turno.getDiaturno());
        contentValues.put(COL_HORATURNO, turno.getHoraturno());
        contentValues.put(COL_MENSAJE, turno.getMensaje());
        contentValues.put(COL_IDUSUARIO, turno.getIddni());
        db.insert(TABLATURNOS, null, contentValues);
        return true;
    }
    */

}

