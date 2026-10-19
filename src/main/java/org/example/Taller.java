package org.example;

import java.util.*;

public class Taller {
    private String nombre;
    private Nivel nivel;
    private int plazas;
    private List<String> alumnas;
    private double precio;

    public Taller(String nombre, Nivel nivel, int plazas, double precio) {
        this.nombre = nombre;
        this.plazas = plazas;
        this.alumnas = new ArrayList<>();
        this.precio = precio;
        this.nivel = nivel;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPlazas() {
        return plazas;
    }

    public int getAlumnasApuntadas() {
        return alumnas.size();
    }

    public double getPrecio() {
        return precio;
    }

    public int plazasLibres() {
        return plazas - alumnas.size();
    }

    public boolean estaCompleto() {
        return alumnas.size() >= plazas;
    }

    public void apuntar(String nombreAlumna) {
        if (estaCompleto()) {
            throw new TallerCompletoException(nombre, plazas);
        }
        if (alumnas.contains(nombreAlumna)) {
            throw new AlumnaYaApuntadaException(nombreAlumna, nombre);
        }
        alumnas.add(nombreAlumna);
    }

    public boolean esRecomendadaPara(Tela tela) {
        if (nivel != Nivel.INICIACION) {
            return true;
        }

        return tela.esAptaPrincipiantes();
    }

    public List<String> alumnasOrdenadas(){
        return alumnas.stream()
                .sorted()
                .toList();
    }

    public long alumnasQueEmpiezanPor (String letra){
        return alumnas.stream()
                .filter(alumna -> alumna.startsWith(letra))
                .count();
    }



}




