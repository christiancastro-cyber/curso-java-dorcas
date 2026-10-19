package org.example;


public class Main {
    public static void main(String[] args) {
        String nombreTaller = "Canastillas de Dorcas";
        int numPlazas = 10;
        int alumnasApuntadas = 11;
        double precioTaller = 45.5;
        boolean incluyeMateriales = true;

        int numPlazasRestantes = numPlazas - alumnasApuntadas;
        System.out.println("¿Cuantas plazas hay libres?: " + numPlazasRestantes);

        double ingresoTotal = alumnasApuntadas * precioTaller;
        System.out.println("Facturación taller: " + ingresoTotal + " €");

        String nombreTela = "Muselina";
        double precioTela = 8.5;
        double metrosTelaAlumna = 1.2;

        double metrosTelaTaller = alumnasApuntadas * metrosTelaAlumna;
        double precioTotalTelaTaller = metrosTelaTaller * precioTela;

        System.out.println("El taller se llama: " + nombreTaller);
        System.out.println("¿Cuántas plazas hay para apuntarse? " + numPlazas);
        System.out.println("Tenemos " + alumnasApuntadas + " alumnas apuntadas, quedan: " + numPlazasRestantes + " libres");
        System.out.println("El precio del taller por persona es: " + precioTaller + " €");
        System.out.println("¿El taller incluye materiales?: " + incluyeMateriales);
        System.out.println("¿Con qué material se hará el taller?: " + nombreTela);
        System.out.println("¿Cuántos metros hará falta para las " + alumnasApuntadas + " alumnas?: " + metrosTelaTaller + " m");
        System.out.println("¿Qué coste tendrían estos " + metrosTelaTaller + " m?: " + precioTotalTelaTaller + " €");

        //Según las plazas
        if (numPlazasRestantes <= 0){
            System.out.println("Taller completo");
        }else if (numPlazasRestantes >= 3){
            System.out.println("Aún quedan " + numPlazasRestantes + " plazas disponibles");
        }else if (numPlazasRestantes == 1 || numPlazasRestantes == 2){
            System.out.println("¡Últimas Plazas");
        }

        //El taller incluye materiales
        if (incluyeMateriales){
            System.out.println("Dorcas prepara "+ metrosTelaAlumna + " m de tela. Coste total del taller para Dorcas: "+ precioTotalTelaTaller + " €");
        } else {
            System.out.println("Cada alumna trae su tela: " + metrosTelaAlumna + " m");
        }

        int alumnasPrincipiantes = 4;
        if (alumnasPrincipiantes > 0 && incluyeMateriales){
            System.out.println("Prepara telas fáciles: muselina o algodón");
        }

        String proyecto = "toalla";
        String recomendacion = switch (proyecto){
            case "vestido de verano" -> "bambula, viscosa o lino";
            case "canastillas" -> "muselina, gofre o piqué";
            case "disfraz" -> "lamé, rasete o tela brillante";
            case "cortinas" -> "tela de cortina o loneta";
            case "toalla" -> "genero de rizo de toalla";
            default -> "Ven a la tienda y te asesoramos";
        };

        System.out.println("Si vas a crear este proyecto: " + proyecto + ", te recomiendo usar este género: " + recomendacion);




    }
}
