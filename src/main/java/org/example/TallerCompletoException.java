package org.example;

public class TallerCompletoException extends DorcasException {
    public TallerCompletoException(String nombreTaller, int plazas) {

        super("El " + nombreTaller + " está completo (" + plazas + " plazas).");
    }
}
