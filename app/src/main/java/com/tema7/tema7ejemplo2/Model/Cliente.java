package com.tema7.tema7ejemplo2.Model;

public class Cliente extends Usuario{

    private String descPersonal;
    private String resultBuscar;
    private String objetivos;

    public Cliente() {
    }

    public Cliente(String id, String foto, String nombre, String apellidos, int telefono, String sexo, String email, String ciudad, String ubicacion, String descPersonal, String resultBuscar, String objetivos) {
        super(id, foto, nombre, apellidos, telefono, sexo, email, ciudad, ubicacion);
        this.descPersonal = descPersonal;
        this.resultBuscar = resultBuscar;
        this.objetivos = objetivos;
    }

    public String getDescPersonal() {
        return descPersonal;
    }

    public void setDescPersonal(String descPersonal) {
        this.descPersonal = descPersonal;
    }

    public String getResultBuscar() {
        return resultBuscar;
    }

    public void setResultBuscar(String resultBuscar) {
        this.resultBuscar = resultBuscar;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "descPersonal='" + descPersonal + '\'' +
                ", resultBuscar='" + resultBuscar + '\'' +
                ", objetivos='" + objetivos + '\'' +
                '}';
    }
}
