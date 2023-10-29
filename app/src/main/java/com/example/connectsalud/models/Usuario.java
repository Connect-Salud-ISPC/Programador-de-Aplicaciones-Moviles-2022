package com.example.connectsalud.models;

public class Usuario {
    private String iddni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String nacimiento;
    private String email;
    private String pass;
    private String tipo;

    public Usuario() {}

    public Usuario(String iddni, String nombre, String apellido, String telefono, String nacimiento, String email, String pass, String tipo) {
        this.iddni = iddni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.email = email;
        this.pass = pass;
        this.tipo = tipo;
    }

    public String getIddni() {
        return iddni;
    }
    public void setIddni(String iddni) {
        this.iddni = iddni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
