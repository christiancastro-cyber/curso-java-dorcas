package org.example;

public class Leccion3 {


    public static void main(String[] args) {
        int numAlumnas = 10;
        double metroTela = 1.2;
        double regaloTelaExtra = 0.3;

        for (int alumna = 1; alumna<=numAlumnas; alumna++ ){
            if (alumna % 4 ==  0){
                System.out.println("Alumna " + alumna + ", se le regala "+ regaloTelaExtra + " m. \n" +
                        "Por lo tanto se le dará: " + (metroTela+regaloTelaExtra) + " m" );
            }else {
                System.out.println("Alumna " + alumna + " : " + metroTela + " m");
            }

        }


        String nombreTela = "Bámbula";
        double precioTela = 6.95;
        double descuento = 0.9;
        double precioFinalDescuento = 0.0;
        double precioFinal = 0.0;

        for (int metros = 1; metros<=10; metros++ ){
            double precio = metros * precioTela;
            if (metros >= 5){
                precio = precio * descuento;
                System.out.println( "A partir de " + metros +" metros de compra de " + nombreTela + ".\n" +
                        "Tienes un descuento del 10% por lo tanto el precio de la tela será: " + precioTela*descuento +" €/m");
            }
            System.out.println(metros + " m de " + nombreTela + ": " + String.format("%.2f",precio) + " €");

        }

        double metrosBobina = 16.0;
        double metroCliente = 2.5;
        int cliente = 0;

        while (metrosBobina >= metroCliente){
            metrosBobina -= metroCliente;
            cliente++;
            System.out.println("La clienta " + cliente + " ha comprado: " + metroCliente + " m");
            System.out.println("cuantos metros me quedan? "+ metrosBobina);

        }

        System.out.println("Hemos vendido la tela a "+ cliente +" clientes");
        System.out.println("Nos queda " + metrosBobina + " m sin vender");


    }





}
