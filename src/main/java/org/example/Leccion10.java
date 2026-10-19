package org.example;

public class Leccion10 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregar(new Tela("Algodón", Categoria.INFANTIL, 8.50, 15.0, true));
        inventario.agregar(new Tela("Loneta Lisa", Categoria.HOGAR, 11.0, 6, true));
        inventario.agregar(new Tela("Loneta estampada", Categoria.HOGAR, 9.30, 5, true));
        inventario.agregar(new Tela("Lycra", Categoria.MODA, 8.50, 15.5, false));
        inventario.agregar(new Tela("Strech", Categoria.MODA, 4.5, 9, true));
        inventario.agregar(new Tela("Antelina", Categoria.HOGAR, 6.0, 12.5, false));
        inventario.agregar(new Tela("Lamé", Categoria.FIESTA, 5.0, 6.5, false));
        inventario.agregar(new Tela("Coralina", Categoria.ABRIGO, 11.50, 8, false));

        double minimo = 10.0;

        System.out.println("Telas Para principiantes");
        inventario.paraPrincipiantes().forEach(tela -> System.out.println("- "+tela.getNombre()));
        System.out.println("\nNombres de la más cara a la más barata: ");
        inventario.nombresPorPrecio().forEach(nombre -> System.out.println("- "+nombre));
        System.out.println("\n¿Cuál es la telá más cara? ");
        Tela masCara = inventario.masCara();
        System.out.println("Es "+masCara.getNombre() + " con un precio de " + String.format("%.2f",masCara.getPrecioMetro()) +"€/m");
        System.out.println("\n¿Alguna tela que tenga menos de: " +minimo +" m?");
        System.out.println(inventario.hayQueReponer(minimo));
        System.out.println("\nListado de telas por reponer, que tienen menos de " + minimo + " m:");
        inventario.listaDeReposicion(minimo).forEach(System.out::println);
        inventario.listaDeReposicion(5).forEach(System.out::println);


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

        System.out.println("\n--- Alumnas en orden alfabético ---");
        canastilla.alumnasOrdenadas()
                .forEach(alumna -> System.out.println(alumna));

        System.out.println("\nEmpiezan por M: " + canastilla.alumnasQueEmpiezanPor("M"));
        System.out.println("Empiezan por E: " + canastilla.alumnasQueEmpiezanPor("E"));


    }

}
