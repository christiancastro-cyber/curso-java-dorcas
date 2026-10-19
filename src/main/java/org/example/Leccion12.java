package org.example;

public class Leccion12 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregar(new Tela("Algodón", Categoria.INFANTIL, 8.50, 15.0, true));
        inventario.agregar(new Tela("Lamé", Categoria.FIESTA, 5.0, 6.5, false));

        String[] busquedas = {"algodon", "ALGODÓN", "Algodón", "lame", "polar"};

        for (String busqueda : busquedas) {
            try {
                Tela tela = inventario.buscarPorNombre(busqueda);
                System.out.println("'" + busqueda + "' → encontrada: " + tela.getNombre());
            } catch (TelaNoEncontradaException e) {
                System.out.println("'" + busqueda + "' → " + e.getMessage());
            }
        }


    }

}
