package com.tema7.tema7ejemplo2.Model;

public class Entrenamiento {

    private String id;
    private String nombre_entrenador;
    private String nombre_cliente;
    private String fecha;
    private String lugar;
    private double precio;

    public Entrenamiento(){

    }

    public Entrenamiento(String nombre_entrenador, String nombre_cliente, String fecha, String lugar){
        this.nombre_entrenador = nombre_entrenador;
        this.nombre_cliente = nombre_cliente;
        this.fecha = fecha;
        this.lugar = lugar;

    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNombre_entrenador() { return nombre_entrenador; }

    public void setNombre_entrenador(String nombre_entrenador) { this.nombre_entrenador = nombre_entrenador; }

    public String getNombre_cliente() { return nombre_cliente; }

    public void setNombre_cliente(String nombre_cliente) { this.nombre_cliente = nombre_cliente; }

    public String getFecha() { return fecha;}

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getLugar() { return lugar; }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
