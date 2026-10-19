package org.example;

import java.util.List;

public class Leccion11 {

    public static void main(String[] args) {
        Tela algodon = new Tela("Algodon", Categoria.INFANTIL,8.50,10,true);
        Tela algodonPopelin = new Tela("Popelin", Categoria.INFANTIL, 6.0, 10, true);

        ArticuloMerceria cremallera15 = new ArticuloMerceria("Cremallera normal 15 cm", 1.50, 12);
        ArticuloMerceria boton = new ArticuloMerceria("Botón", 0.80,15);

        Pedido pedido1 = new Pedido("Ana");
        pedido1.agregar(algodon, 3);
        pedido1.agregar(algodonPopelin, 6);
        pedido1.agregar(cremallera15, 2);
        pedido1.agregar(boton, 1);

        System.out.println("Pedido de: " + pedido1.getCliente());
        List<LineaPedido> articulos = pedido1.getLineas();

        for (LineaPedido articulo:articulos){
            System.out.println(articulo.producto().describir(articulo.cantidad()) + " · " + String.format("%.2f",articulo.subtotal()) +" €");
        }
        System.out.println("TOTAL: " + String.format("%.2f",pedido1.total()) +" €" );

        try{
            pedido1.agregar(algodon, 0);
        } catch (IllegalArgumentException  e){
            System.out.println("Rechazado: "+ e.getMessage());
        }

        try {
            pedido1.agregar(cremallera15, 2.5);
        }catch (IllegalArgumentException  e){
            System.out.println("Rechazado: " + e.getMessage());
        }

        System.out.println("TOTAL después de los intentos: " + String.format("%.2f", pedido1.total()) + " €");

        Inventario inventario = new Inventario();
        inventario.agregar(new Tela("Algodón", Categoria.INFANTIL, 8.50, 15.0, true));
        inventario.agregar(new Tela("Loneta Lisa", Categoria.HOGAR, 11.0, 6, true));
        inventario.agregar(new Tela("Loneta estampada", Categoria.HOGAR, 9.30, 5, true));
        inventario.agregar(new Tela("Lycra", Categoria.MODA, 8.50, 15.5, false));
        inventario.agregar(new Tela("Strech", Categoria.MODA, 4.5, 9, true));
        inventario.agregar(new Tela("Antelina", Categoria.HOGAR, 6.0, 12.5, false));
        inventario.agregar(new Tela("Lamé", Categoria.FIESTA, 5.0, 6.5, false));
        inventario.agregar(new Tela("Coralina", Categoria.ABRIGO, 11.50, 8, false));

        String[] telasPedidas = {"Algodón", "Loneta Lisa", "Lycra", "Polar", "Coralina"};
        double[] metrosPedidos = {3, 20, -2, 1, 2};
        int ventasOk = 0;
        int ventasFallidas = 0;
        for (int i = 0; i < telasPedidas.length; i++) {
            String tela = telasPedidas[i];
            double metros = metrosPedidos[i];

            System.out.print("Pedido " + (i + 1) + " (" + metros + " m de " + tela + "): ");

            try {
                inventario.vender(tela, metros);
                System.out.println("Venta realizada.");
                ventasOk++;
            } catch (DorcasException e) {
                System.out.println("rechazado. " + e.getMessage());
                ventasFallidas++;
            } catch (IllegalArgumentException e) {
                System.out.println("rechazado. " + e.getMessage());
                ventasFallidas++;
            }
        }
        System.out.println("Ventas correctas: " + ventasOk);
        System.out.println("Ventas fallidas: " + ventasFallidas);
    }


}
