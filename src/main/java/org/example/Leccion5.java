package org.example;

public class Leccion5 {

    public static void main(String[] args) {
        String[] telas = {"Algodón", "Popelín", "Pana", "Lamé", "Rasete", "Raso"};
        double[] precios = {8.50, 6.0, 8.0, 5.0, 3.5, 5.0};
        double[] stockMetros = {15, 9.5, 9, 6.5, 25, 15.5};

        mostrarInventario(telas,precios,stockMetros);
        double valorAlmacen = calcularValorAlmacen(precios, stockMetros);
        System.out.println("En la tienda tengo en telas el importe de: " + formatearEuros(valorAlmacen) + ".");

        int indiceMasCaro = indiceDelMayor(precios);
        System.out.println("La tela "+ telas[indiceMasCaro] + " és la más cara y cuesta: " + formatearEuros(precios[indiceMasCaro]) + "/m");

        double telaConMasStock = stockMetros[indiceDelMayor(stockMetros)];
        System.out.println("Tengo una tela con " + String.format("%.2f",telaConMasStock) + " m; es la tela con más metros de mi stock.");

        int minimo = 10;
        int cuantasTelasPorReponer = contarPorReponer(stockMetros, minimo);
        System.out.println("Tenemos " + cuantasTelasPorReponer + " telas que tienen menos de " + minimo + " metros");

        int metrosTelaCliente = 6;
        double precioTela = calcularPrecio(metrosTelaCliente, precios[indiceMasCaro]);
        System.out.println(metrosTelaCliente + " m de tela cuesta: " + formatearEuros(precioTela));
    }

    public static void mostrarInventario(String[] telas, double[] precios, double[] stockMetros){
        for (int i=0; i<telas.length; i++){
            System.out.println("La tela de "+ telas[i] + " tiene un coste de: " + formatearEuros(precios[i])+ "/m. \n"
                    + "Tengo en stock: " + String.format("%.1f",stockMetros[i]) + " m de " + telas[i]);
        }
    }

    public static double calcularValorAlmacen(double[] precios, double[] stock){
        double valorAlmacen =  0.0;
        for (int i=0; i<precios.length; i++) {
            double precio = precios[i] * stock[i];
            valorAlmacen += precio;
        }

        return valorAlmacen;
    }

    public static int indiceDelMayor(double[] valores){
        int indiceDelMayor = 0;
        for (int i=0; i<valores.length; i++) {
            if (valores[i] >= valores[indiceDelMayor]){
                indiceDelMayor = i;
            }
        }

        return indiceDelMayor;
    }

    public static int contarPorReponer(double[] stock, double minimo){
        int cuantasTelas = 0;

        for (double metro:stock){
            if (metro < minimo){
                cuantasTelas++;
            }
        }

        return cuantasTelas;
    }

    public static double calcularPrecio(double metros, double precioMetro){
        double precio = metros * precioMetro;
        double descuento = 0.9;
        if (metros >= 5){
            precio = precio * descuento;
        }
        return precio;
    }

    public static String formatearEuros(double cantidad){
        String euros = String.format("%.2f",cantidad) + " €";
        return euros;
    }

}

