package org.example;

public class AlumnaYaApuntadaException extends DorcasException {
    public AlumnaYaApuntadaException(String nombreAlumna, String nombreTaller) {

        super(nombreAlumna + " ya está apuntada al " + nombreTaller);
    }
}
