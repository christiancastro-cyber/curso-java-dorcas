package org.example;

import java.util.*;

public class Leccion8 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregar(new Tela("Algodón",Categoria.INFANTIL ,8.50, 15.0, true));
        inventario.agregar(new Tela("Loneta Lisa", Categoria.HOGAR,11.0, 6, true));
        inventario.agregar(new Tela("Loneta estampada",Categoria.HOGAR, 9.30, 5, true));
        inventario.agregar(new Tela("Lycra", Categoria.MODA,8.50, 15.5, false));
        inventario.agregar(new Tela("Strech", Categoria.MODA,4.5, 9, true));
        inventario.agregar(new Tela("Antelina", Categoria.HOGAR, 6.0, 12.5, false));
        inventario.agregar(new Tela ("Lamé", Categoria.FIESTA,5.0, 6.5, false));
        inventario.agregar(new Tela("Coralina", Categoria.ABRIGO, 11.50, 8, false));


        try{
            Tela lame = inventario.buscarPorNombre("lamé");
            lame.vender(6.5);
            System.out.println("Vendido. Quedan " + lame.getStockMetros() +" m de " +lame.getNombre());
        } catch (TelaNoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        try{
            inventario.buscarPorNombre("polar");
        } catch (TelaNoEncontradaException e){
            System.out.println(e.getMessage());
        }



        System.out.println("--- Telas de hogar ---");
        List<Tela> categoriaHogar = inventario.filtrarPorCategoria(Categoria.HOGAR);
        double valorTotalInventario = inventario.valorTotal();

        for(Tela tela:categoriaHogar){
            System.out.println(tela);
        }
        System.out.println("El valor total de telas de mi inventario es de " + String.format("%.2f", valorTotalInventario) + " €.");

        Map<Categoria, Long> recuentoCategoriaAntes = inventario.contarPorCategoria();
        System.out.println(recuentoCategoriaAntes);

        int eliminadas = inventario.eliminarSinStock();
        System.out.println("Se ha quitado " + eliminadas + " telas");
         System.out.println("Quedan "+ inventario.cantidad() + " telas ");

        Map<String, Taller> talleres = new HashMap<>();
        Taller canastilla = new Taller("Taller de Canastilla",Nivel.INICIACION,8,45.0);
        canastilla.apuntar("Rosa");
        canastilla.apuntar("Macarena");
        canastilla.apuntar("Evelyn");

        talleres.put("patronaje", new Taller("Patronaje Básico", Nivel.INICIACION, 5, 50.0));
        talleres.put("costura", new Taller("Costura Básica", Nivel.INICIACION, 5, 55.0));


        Taller taller = talleres.get("canastilla");
        if (taller == null){
            System.out.println("No tenemos este taller");
        }else{
            taller.apuntar("Maraca");

        }



    }

}
