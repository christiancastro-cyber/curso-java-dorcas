package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Inventario {
    private List<Tela> telas;

    public Inventario() {
        this.telas = new ArrayList<>();
    }

    public void agregar(Tela tela){
        telas.add(tela);
    }

    public int cantidad(){
        return telas.size();
    }

    public Tela buscarPorNombre(String nombre){
       return telas.stream()
                .filter(t -> t.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow( () -> new TelaNoEncontradaException(nombre));
    }

    public List<Tela> filtrarPorCategoria(Categoria categoria){
        return telas.stream()
                .filter(t -> t.getCategoria() == categoria)
                .toList();
    }

    public double valorTotal(){
        return telas.stream()
                .mapToDouble(Tela::valorEnStock)
                .sum();
    }

    public int eliminarSinStock(){
        int antes = telas.size();
        telas.removeIf(tela ->tela.getStockMetros() == 0);
        int despues = telas.size();

        return antes - despues;
    }

    public Map<Categoria, Long> contarPorCategoria(){
        return telas.stream()
                .collect(Collectors.groupingBy(Tela::getCategoria, Collectors.counting()));
    }

    public void vender(String nombreTela, double metros){
        Tela tela = buscarPorNombre(nombreTela);
        tela.vender(metros);
    }

    public List<Tela> paraPrincipiantes(){
        return telas.stream()
                .filter(Tela::esAptaPrincipiantes)
                .toList();
    }

    public List<String> nombresPorPrecio(){
        return telas.stream()
                .sorted(Comparator.comparing(Tela::getPrecioMetro).reversed())
                .map(Tela::getNombre)//Para transformar algo a esto
                .toList();
    }

    public Tela masCara(){
        return telas.stream()
                .max(Comparator.comparing(Tela::getPrecioMetro))
                .orElseThrow();
    }

    public boolean hayQueReponer(double minimo){
        return telas.stream()
                .anyMatch(t->t.getStockMetros() < minimo);
    }

    public List<String> listaDeReposicion(double minimo){
        return telas.stream()
                .filter(t->t.getStockMetros() < minimo)
                .sorted(Comparator.comparing(Tela::getStockMetros))
                .map(tela -> tela.getNombre() + " ("+ String.format("%.2f",tela.getStockMetros()) + " m)")
                .toList();
    }


}
