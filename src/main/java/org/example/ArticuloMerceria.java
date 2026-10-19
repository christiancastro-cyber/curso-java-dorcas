package org.example;

public class ArticuloMerceria implements Vendible{
    private String nombre;
    private double precioUnidad;
    private int stockUnidades;

    public ArticuloMerceria(String nombre, double precioUnidad, int stockUnidades) {
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.stockUnidades = stockUnidades;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double precioPara(double cantidad) {
        if(cantidad %1 != 0){
            throw new IllegalArgumentException("La mercería se vende por unidades enteras: " + cantidad);
        }
        return cantidad * precioUnidad;
    }

    @Override
    public String unidad() {
        return "ud";
    }
}

