package org.example;

public class Leccion4 {

    public static void main(String[] args) {

        String[] telas = {"Algodón", "Popelín", "Pana", "Lamé", "Rasete", "Raso"};
        double[] precios = {8.50, 6.0, 8.0, 5.0, 3.5, 5.0};
        double[] stockMetros = {15, 9.5, 9, 6.5, 25, 15.5};
        double costeTotal = 0.0;

        double precioMaximo = 0.0;
        int telaPorReponer = 0;
        int indicadorMasCara = 0;

        for (int i=0; i<telas.length; i++){
            if (precios[i] >= precioMaximo){
                precioMaximo = precios[i];
                indicadorMasCara = i;
            }
            double valor = precios[i] * stockMetros[i];
            costeTotal +=valor;
            System.out.println("La tela de "+ telas[i] + " tiene un coste de: " + String.format("%.2f",precios[i]) + " €/m. \n"
                              + "Tengo en stock: " + String.format("%.1f",stockMetros[i]) + " m de " + telas[i]);
        }
        System.out.println("El dinero total que tengo en telas es de: " + String.format("%.2f",costeTotal) + " €");
        System.out.println("La tela de " +telas[indicadorMasCara] + " es la más cara porque el precio del metro es de: "+ String.format("%.2f",precios[indicadorMasCara]) + " €/m.");

        for (double metro:stockMetros){
            if (metro < 10.0){
                telaPorReponer++;
            }
        }
        System.out.println("Tenemos " + telaPorReponer + " telas que tienen menos de 10 stockMetros");
    }

}
