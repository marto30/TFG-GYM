package com.tema7.tema7ejemplo2.Model;

public class Instructor extends Usuario{

    private String horarDisponib;
    private String descripPorfesional;
    private String disciplinas;
    private String precioHora;
    private String valoraciones;
    private String descripValoraciones;

    public Instructor() {
    }

    public Instructor(String id, String foto, String nombre, String apellidos, int telefono, String sexo, String email, String ciudad, String ubicacion, String horarDisponib, String descripPorfesional, String disciplinas, String precioHora, String valoraciones, String descripValoraciones) {
        super(id, foto, nombre, apellidos, telefono, sexo, email, ciudad, ubicacion);
        this.horarDisponib = horarDisponib;
        this.descripPorfesional = descripPorfesional;
        this.disciplinas = disciplinas;
        this.precioHora = precioHora;
        this.valoraciones = valoraciones;
        this.descripValoraciones = descripValoraciones;
    }

    public String getHorarDisponib() {return horarDisponib;}

    public void setHorarDisponib(String horarDisponib) {this.horarDisponib = horarDisponib;}

    public String getDescripPorfesional() {return descripPorfesional;}

    public void setDescripPorfesional(String descripPorfesional) { this.descripPorfesional = descripPorfesional;}

    public String getDisciplinas() {return disciplinas;}

    public void setDisciplinas(String disciplinas) {this.disciplinas = disciplinas;}

    public String getPrecioHora() {return precioHora;}

    public void setPrecioHora(String precioHora) {this.precioHora = precioHora;}

    public String getValoraciones() {return valoraciones;}

    public void setValoraciones(String valoraciones) {this.valoraciones = valoraciones;}

    public String getDescripValoraciones() {return descripValoraciones;}

    public void setDescripValoraciones(String descripValoraciones) {this.descripValoraciones = descripValoraciones;}

    @Override
    public String toString() {
        return "Instructores{" +
                "horarDisponib='" + horarDisponib + '\'' +
                ", descripPorfesional='" + descripPorfesional + '\'' +
                ", disciplinas='" + disciplinas + '\'' +
                ", precioHora='" + precioHora + '\'' +
                ", valoraciones='" + valoraciones + '\'' +
                ", descripValoraciones='" + descripValoraciones + '\'' +
                '}';
    }
}
