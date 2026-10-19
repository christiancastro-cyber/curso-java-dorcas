package org.example;

public class TelaNoEncontradaException extends DorcasException {
    public TelaNoEncontradaException(String nombre) {
        super("No existe la tela " + nombre);
    }
}
