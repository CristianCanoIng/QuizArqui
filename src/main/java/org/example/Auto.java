package org.example;

import java.util.Calendar;

public class Auto {
    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;
    private String estado;

    public Auto() {}

    public Auto(String marca, double kilometraje, String modelo, int anio, String estado) {
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.modelo = modelo;
        this.anio = anio;
        this.estado = estado;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getKilometraje() { return kilometraje; }
    public void setKilometraje(double kilometraje) { this.kilometraje = kilometraje; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public void mostrarDetalles() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Kilometraje: " + kilometraje + " km");
        System.out.println("Estado: " + estado);
    }

    public void actualizarKilometraje(double nuevoKilometraje) {
        if (nuevoKilometraje > kilometraje) {
            kilometraje = nuevoKilometraje;
            System.out.println("Nuevo kilometraje:  " + kilometraje + " km.");
        } else {
            System.out.println("El nuevo kilometraje debe ser mayor");
        }
    }

    public boolean esAntiguo() {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return (anioActual - anio) > 15;
    }

    public boolean necesitaMantenimiento() {
        return kilometraje > 100000;
    }

    public double calcularConsumoCombustible(double distanciaRecorrida, double rendimiento) {
        return distanciaRecorrida / rendimiento;
    }

    public double combustibleRestante(double capacidadTanque, double distanciaRecorrida, double rendimiento) {
        double consumo = calcularConsumoCombustible(distanciaRecorrida, rendimiento);
        return capacidadTanque - consumo;
    }
}