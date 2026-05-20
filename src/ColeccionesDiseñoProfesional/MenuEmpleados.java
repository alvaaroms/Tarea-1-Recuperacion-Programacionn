package ColeccionesDiseñoProfesional;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = GestorEmpleados.getInstancia();
        boolean salir = false;

        System.out.println("=== SISTEMA PROFESIONAL DE GESTION DE EMPLEADOS ===");

        while (!salir) {
            System.out.println("\nQue deseas hacer?");
            System.out.println("1. Anadir empleado");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Filtrar por departamento");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Introduce el Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce el Departamento: ");
                    String dep = scanner.nextLine();
                    gestor.añadirEmpleado(id, nombre, dep);
                    break;
                case 2:
                    System.out.print("Introduce el ID a buscar: ");
                    int idBusqueda = Integer.parseInt(scanner.nextLine());
                    Empleado encontrado = gestor.buscarPorId(idBusqueda);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No se encontro ningun empleado con ese ID.");
                    }
                    break;
                case 3:
                    System.out.print("Introduce el ID a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    gestor.eliminarEmpleado(idEliminar);
                    break;
                case 4:
                    System.out.println("\n--- LISTA DE EMPLEADOS ---");
                    gestor.listarEmpleados();
                    break;
                case 5:
                    System.out.print("Introduce el departamento a filtrar: ");
                    String depFiltro = scanner.nextLine();
                    ArrayList<Empleado> filtrados = gestor.filtrarPorDepartamento(depFiltro);
                    System.out.println("\n--- EMPLEADOS DEL DEPARTAMENTO: " + depFiltro.toUpperCase() + " ---");
                    if (filtrados.isEmpty()) {
                        System.out.println("No hay empleados en ese departamento.");
                    } else {
                        for (Empleado emp : filtrados) {
                            System.out.println(emp);
                        }
                    }
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }
        scanner.close();
    }
}

