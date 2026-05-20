package ColeccionesDiseñoProfesional;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorEmpleados {

    // 1. PATRÓN SINGLETON: Instancia estática privada
    private static GestorEmpleados instancia;

    // Colecciones requeridas
    private ListaEnlazada listaEmpleados;
    private HashMap<Integer, Empleado> mapaEmpleados;

    // 2. PATRÓN SINGLETON: Constructor privado (nadie más puede hacer 'new')
    private GestorEmpleados() {
        listaEmpleados = new ListaEnlazada();
        mapaEmpleados = new HashMap<>();
    }

    // 3. PATRÓN SINGLETON: Método para obtener la única instancia
    public static GestorEmpleados getInstancia() {
        if (instancia == null) {
            instancia = new GestorEmpleados();
        }
        return instancia;
    }

    // --- MÉTODOS DEL SISTEMA ---

    // Añadir empleado
    public void añadirEmpleado(int id, String nombre, String departamento) {
        if (mapaEmpleados.containsKey(id)) {
            System.out.println("Error: Ya existe un empleado con el ID " + id);
            return;
        }

        // Usamos el Factory para crear el objeto
        Empleado nuevo = EmpleadoFactory.crearEmpleado(id, nombre, departamento);

        // Lo guardamos en ambas estructuras
        listaEmpleados.insertar(nuevo);
        mapaEmpleados.put(id, nuevo);
        System.out.println("Empleado añadido con éxito.");
    }

    // Buscar por ID (usamos HashMap porque es instantáneo)
    public Empleado buscarPorId(int id) {
        return mapaEmpleados.get(id); // Devuelve el empleado o null si no existe
    }

    // Eliminar empleado
    public void eliminarEmpleado(int id) {
        if (mapaEmpleados.containsKey(id)) {
            // Lo borramos de ambas estructuras para mantener sincronía
            mapaEmpleados.remove(id);
            listaEmpleados.eliminar(id);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró un empleado con el ID " + id);
        }
    }

    // Listar todos los empleados
    public void listarEmpleados() {
        ArrayList<Empleado> todos = listaEmpleados.obtenerTodos();
        if (todos.isEmpty()) {
            System.out.println("No hay empleados en el sistema.");
        } else {
            for (Empleado emp : todos) {
                System.out.println(emp.toString());
            }
        }
    }

    // Filtrar por departamento (Usamos ArrayList como pide el requisito)
    public ArrayList<Empleado> filtrarPorDepartamento(String departamento) {
        ArrayList<Empleado> filtrados = new ArrayList<>();
        // Obtenemos todos de nuestra lista artesanal y filtramos
        for (Empleado emp : listaEmpleados.obtenerTodos()) {
            // Ignoramos mayúsculas/minúsculas al comparar
            if (emp.getDepartamento().equalsIgnoreCase(departamento)) {
                filtrados.add(emp);
            }
        }
        return filtrados;
    }
}
