package org.example;

public record LineaPedido(Vendible producto, double cantidad) {

    public LineaPedido{
        if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser positiva: " + cantidad);
        }
    }

    public double subtotal(){
        return producto.precioPara(cantidad);
    }

}
