package org.example;

public interface Vendible {
    String getNombre();
    double precioPara(double cantidad);
    String unidad();

    default String describir(double cantidad){
        return getNombre() + " · " + cantidad + " " + unidad();
    }

}
