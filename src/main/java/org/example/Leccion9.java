package org.example;

import java.util.ArrayList;
import java.util.List;


public class Leccion9 {
    public static void main(String[] args) {
        List<String> listadoMetros = new ArrayList<>();
        listadoMetros.add("3");
        listadoMetros.add("2.5");
        listadoMetros.add("dos");
        listadoMetros.add("1,5");
        listadoMetros.add("4");

        double metrosTotales = 0;

        for (String number : listadoMetros) {
            try {
                double metros = Double.parseDouble(number);
                System.out.println("Metros: " + metros);
                metrosTotales += metros;
            } catch (NumberFormatException e) {
                System.out.println("'" + number + "' no es un número válido.");
            }
        }
        System.out.println(metrosTotales + "metros");


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
            } catch (TelaNoEncontradaException e) {
                System.out.println("rechazado. " + e.getMessage());
                ventasFallidas++;
            } catch (StockInsuficienteException e) {
                System.out.println("rechazado. " + e.getMessage());
                ventasFallidas++;
            } catch (IllegalArgumentException e) {
                System.out.println("rechazado. " + e.getMessage());
                ventasFallidas++;
            }
        }

        System.out.println("Ventas correctas: " + ventasOk);
        System.out.println("Ventas fallidas: " + ventasFallidas);

        Taller canastilla = new Taller("Taller de Canastilla", Nivel.INICIACION, 8, 45.0);

        String[] alumnas = {"Rosa", "Macarena", "Evelyn", "Rebeca", "Carolina", "Maricielo", "Rosa", "Christian", "Elena", "Evelyn"};

        for (String alumna: alumnas){
            try{
                canastilla.apuntar(alumna);
                System.out.println(alumna + ": apuntada");
            }catch (AlumnaYaApuntadaException e){
                System.out.println("Rechazado. " + e.getMessage());
            }catch (TallerCompletoException e){
                System.out.println("Rechazado. " + e.getMessage());
            }
        }


    }
}
