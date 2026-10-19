package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String cliente;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public void agregar(Vendible producto, double cantidad){
        LineaPedido linea = new LineaPedido(producto, cantidad);
        linea.subtotal();
        lineas.add(linea);
    }

    public double total(){
        return lineas.stream()
                .mapToDouble(LineaPedido::subtotal)
                .sum();
    }

    public List<LineaPedido> getLineas(){
        return lineas;
    }

    public String getCliente(){
        return cliente;
    }
}
