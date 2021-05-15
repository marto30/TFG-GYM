package com.example.tfg_gym.Models;

public class Usuario {

    private String ID;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String ubicacion;
    private String sexo;
    private String objetivos;
    private String contraseña;
    private String foto;

    public Usuario(String ID,String nombre, String apellidos, String correo,String contraseña, String telefono,
                   String ubicacion, String sexo, String objetivos,String foto) {
        this.foto=foto;
        this.contraseña=contraseña;
        this.ID= ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.sexo = sexo;
        this.objetivos = objetivos;
    }

    public Usuario(){
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
}
