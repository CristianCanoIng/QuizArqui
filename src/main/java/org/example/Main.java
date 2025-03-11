package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Auto> autos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("""
                    
                        \s
                                             __,                      ,__
                                          __/==+\\  MENU DE OPCIONES  /+==\\__
                                            "  "`   ===============   '"  "
                               \s
                    
                    """);
            System.out.println("[1] Ingresar auto al taller");
            System.out.println("[2] Mostrar detalles de todos los autos");
            System.out.println("[3] Actualizar kilometraje de un auto");
            System.out.println("[4] Verificar si un auto es antiguo");
            System.out.println("[5] Verificar si un auto necesita mantenimiento");
            System.out.println("[6] Calcular consumo de combustible");
            System.out.println("[7] Calcular combustible restante");
            System.out.println("[8] Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el año: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese el kilometraje: ");
                    double kilometraje = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese el estado: ");
                    String estado = scanner.nextLine();

                    autos.add(new Auto(marca, kilometraje, modelo, anio, estado));
                    System.out.println("Auto ingresado correctamente.");
                    break;

                case 2:
                    if (autos.isEmpty()) {
                        System.out.println("No hay autos registrados.");
                    } else {
                        System.out.println("\nLista de autos en el taller:\n");
                        for (int i = 0; i < autos.size(); i++) {
                            System.out.println("Auto "+"[" + (i + 1) + "] ");
                            autos.get(i).mostrarDetalles();
                        }
                    }
                    break;

                case 3:
                    if (autos.isEmpty()) {
                        System.out.println("No hay autos registrados.");
                        break;
                    }
                    System.out.print("Seleccione el numero del auto a actualizar kilometraje: ");
                    int buscarKm = scanner.nextInt();

                    if (buscarKm < 1 || buscarKm > autos.size()) {
                        System.out.println("Ese auto no esta");
                        break;
                    }
                    Auto autoKm = autos.get(buscarKm - 1);
                    System.out.print("Ingrese el nuevo kilometraje: ");
                    double nuevoKm = scanner.nextDouble();
                    autoKm.actualizarKilometraje(nuevoKm);
                    break;

                case 4:
                    if (autos.isEmpty()) {
                        System.out.println("No hay autos registrados.");
                        break;
                    }
                    System.out.println("\nLista de autos en el taller:");
                    for (int i = 0; i < autos.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + autos.get(i).getMarca() + " " + autos.get(i).getModelo());
                    }
                    System.out.print("Seleccione el numero del auto a verificar: ");
                    int buscarAntiguo = scanner.nextInt();
                    if (buscarAntiguo < 1 || buscarAntiguo > autos.size()) {
                        System.out.println("Ese auto no esta");
                        break;
                    }
                    Auto autoAntiguo = autos.get(buscarAntiguo - 1);
                    System.out.println("¿El auto es antiguo? " + (autoAntiguo.esAntiguo() ? "Sí" : "No"));
                    break;

                case 5:
                    if (autos.isEmpty()) {
                        System.out.println("No hay autos registrados.");
                        break;
                    }
                    System.out.print("Seleccione el número del auto a verificar: ");
                    int indexMantenimiento = scanner.nextInt();
                    if (indexMantenimiento < 1 || indexMantenimiento > autos.size()) {
                        System.out.println("Numero invalido.");
                        break;
                    }
                    Auto autoMantenimiento = autos.get(indexMantenimiento - 1);
                    System.out.println("¿El auto necesita mantenimiento? " + (autoMantenimiento.necesitaMantenimiento() ? "Sí" : "No"));
                    break;

                case 6:
                    System.out.print("Ingrese la distancia recorrida (km): ");
                    double distancia = scanner.nextDouble();
                    System.out.print("Ingrese el rendimiento del vehículo (km/litro): ");
                    double rendimiento = scanner.nextDouble();
                    System.out.println("Consumo de combustible: " + (distancia / rendimiento) + " litros");
                    break;
                case 7:
                    System.out.print("Ingrese la capacidad del tanque de combustible (litros): ");
                    double capacidadTanque = scanner.nextDouble();
                    System.out.print("Ingrese la distancia recorrida (km): ");
                    double distanciaViaje = scanner.nextDouble();
                    System.out.print("Ingrese el rendimiento del vehículo (km/litro): ");
                    double rendimientoVehiculo = scanner.nextDouble();
                    double combustibleRestante = new Auto().combustibleRestante(capacidadTanque, distanciaViaje, rendimientoVehiculo);
                    System.out.println("Combustible restante en el tanque: " + combustibleRestante + " litros");
                    break;
                case 8:
                    System.out.println("Chao");
                    break;

                default:
                    System.out.println("Esta opcion no esta en la lista");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
