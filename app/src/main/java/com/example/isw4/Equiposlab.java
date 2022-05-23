package com.example.isw4;

public class Equiposlab {
    private String equiposid, equipo, peso, masa, densidad;

    public Equiposlab(String equiposid, String equipo, String peso, String masa, String densidad) {
        this.equiposid = equiposid;
        this.equipo = equipo;
        this.peso = peso;
        this.masa = masa;
        this.densidad = densidad;
    }

    public Equiposlab(){

    }

    public String getEquiposid() {
        return equiposid;
    }

    public void setId(String id) {
        this.equiposid = equiposid;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getDensidad() {
        return densidad;
    }

    public void setDensidad(String densidad) {
        this.densidad = densidad;
    }

    @Override
    public String toString() {
        return "Equiposlab: \n" +
                "  id=" + equiposid + "\n" +
                "  nombre_equipo=" + equipo + "\n" +
                "  peso=" + peso + "\n" +
                "  masa=" + masa + "\n" +
                "  densidad=" + densidad + "\n";
    }
}
