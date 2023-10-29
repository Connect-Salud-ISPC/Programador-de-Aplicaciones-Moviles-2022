package com.example.connectsalud.models;

public class Turno {
    private String idturno;
    private String especialidad;
    private String profesional;
    private String diaturno;
    private String horaturno;
    private String mensaje;
    private String iddni;

    public Turno() {}

    public Turno(String idturno, String especialidad, String profesional, String diaturno, String horaturno, String mensaje, String iddni) {
        this.idturno = idturno;
        this.especialidad = especialidad;
        this.profesional = profesional;
        this.diaturno = diaturno;
        this.horaturno = horaturno;
        this.mensaje = mensaje;
        this.iddni = iddni;
    }

    public String getIdturno() {
        return idturno;
    }
    public void setIdturno(String idturno) {
        this.idturno = idturno;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getProfesional() {
        return profesional;
    }
    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public String getDiaturno() {
        return diaturno;
    }
    public void setDiaturno(String diaturno) {
        this.diaturno = diaturno;
    }

    public String getHoraturno() {
        return horaturno;
    }
    public void setHoraturno(String horaturno) {
        this.horaturno = horaturno;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIddni() {
        return iddni;
    }
    public void setIddni(String iddni) {
        this.iddni = iddni;
    }
}