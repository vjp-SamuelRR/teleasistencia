package com.example.teleappsistencia.clases;

import com.google.gson.annotations.SerializedName;

public class TipoSituacion {

    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;

    /**
     * Constructor para mostrar un TipoSituacion.
     * @param nombre
     */
    public TipoSituacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor para modificar o insertar un nuevo TipoSituacion.
     * @param nombre
     */
    public TipoSituacion(String nombre) {
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
