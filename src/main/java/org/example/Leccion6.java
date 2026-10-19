package org.example;

import java.util.ArrayList;
import java.util.List;

public class Leccion6 {

    public static void main(String[] args) {

        Tela[] inventario = {
                new Tela("Algodón",Categoria.INFANTIL ,8.50, 15.0, true),
                new Tela("Loneta Lisa", Categoria.HOGAR,11.0, 6, true),
                new Tela("Loneta estampada",Categoria.HOGAR, 9.30, 5, true),
                new Tela("Lycra", Categoria.MODA,8.50, 15.5, false),
                new Tela("Strech", Categoria.MODA,4.5, 9, true),
                new Tela("Antelina", Categoria.HOGAR, 6.0, 12.5, false),
                new Tela ("Lamé", Categoria.FIESTA,5.0, 6.5, false)
        };

        double valorAlmacen = 0;
        Tela masCara = inventario[0];
        int contadorTelasReponer = 0;
        int minimoReponer = 10;
        List<String> alumnas  = new ArrayList<>();
        alumnas.add("Ana");
        Taller taller = new Taller("Taller de canastilla", Nivel.INICIACION, 10,50.0);

        for (Tela tela : inventario) {
            valorAlmacen += tela.valorEnStock();
            if(tela.getPrecioMetro() > masCara.getPrecioMetro()){
                masCara = tela;
            }

            if (tela.necesitaReponer(minimoReponer)){
                contadorTelasReponer++;
            }

            if(tela.esAptaPrincipiantes()){
                System.out.println("Esta " + tela.getNombre() + " es para principiantes. \n"
                + "Un consejo para esta tela sería el siguiente: " + tela.consejoCuidado());
            }

            if(tela.getCategoria() == Categoria.MODA){
                System.out.println(tela.getNombre() + " es de " + tela.getCategoria() + ".\n"
                        + "Un consejo para esta tela sería el siguiente: " + tela.consejoCuidado());
            }

            if(taller.esRecomendadaPara(tela)){
                System.out.println("Esta tela:" + tela.getNombre() +" es recomendada para el " + taller.getNombre());
            }

        }
        System.out.println("El valor de mi almacén es: " + String.format("%.2f", valorAlmacen) + " €");
        System.out.println("La tela más cara es: '" + masCara.getNombre() + "', un consejo sería el siguiente: "+ masCara.consejoCuidado() + ". \nTiene un precio de: " + String.format("%.2f", masCara.getPrecioMetro()) + " €/m");
        System.out.println(contadorTelasReponer + " telas se han de reponer.");

        Tela lame = inventario[6];
        lame.vender(4);
        lame.vender(10);

        for (int i= 1; i <= 12; i++){
            taller.apuntar("Carolina");
        }

        System.out.println("Quedan "+ taller.plazasLibres() + " plazas libres.");
        if (taller.estaCompleto()){
            System.out.println("Taller a full");
        }else {
            System.out.println("Taller aún no completo");
        }

        for (Categoria cat: Categoria.values()){
            int cuantas = 0;
            double valorStock = 0;
            for (Tela tela: inventario){
                if(tela.getCategoria() == cat){
                    cuantas++;
                    valorStock += tela.valorEnStock();
                }
            }
            System.out.println("De la categoria " + cat.getEtiqueta() + " hay " + cuantas + " telas. \n"
               + "El valor de todas las telas de esta categoria es de " + String.format("%.2f",valorStock) + " €");
        }



    }





}
