package com.tema7.tema7ejemplo2.Model;

public class Usuario {

    private String id;
    private String foto;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String sexo;
    private String email;
    private String ciudad;
    private String ubicacion;

    public Usuario() {
    }

    public Usuario(String id, String foto, String nombre, String apellidos, int telefono, String sexo,
                   String email, String ciudad, String ubicacion) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.sexo = sexo;
        this.email = email;
        this.ciudad = ciudad;
        this.ubicacion = ubicacion;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getFoto() {return foto;}

    public void setFoto(String foto) {this.foto = foto;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public int getTelefono() {return telefono;}

    public void setTelefono(int telefono) {this.telefono = telefono;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getCiudad() {return ciudad;}

    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public String getUbicacion() {return ubicacion;}

    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", foto='" + foto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", sexo='" + sexo + '\'' +
                ", email='" + email + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}