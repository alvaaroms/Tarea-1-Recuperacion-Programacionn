package ColeccionesDiseñoProfesional;

import java.util.ArrayList;

public class ListaEnlazada {
    // Referencia al primer elemento de la lista
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    // Método para añadir un empleado al final de la lista
    public void insertar(Empleado empleado) {
        Nodo nuevoNodo = new Nodo(empleado);

        // Si la lista está vacía, el nuevo nodo es la cabeza
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            // Si no, recorremos la lista hasta llegar al final
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            // Enlazamos el último nodo con el nuevo
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para eliminar un empleado por su ID
    public boolean eliminar(int id) {
        // Si la lista está vacía, no hay nada que eliminar
        if (cabeza == null) {
            return false;
        }

        // Si el elemento a eliminar es la cabeza
        if (cabeza.empleado.getId() == id) {
            cabeza = cabeza.siguiente; // La cabeza ahora es el segundo nodo
            return true;
        }

        // Recorremos buscando el nodo anterior al que queremos eliminar
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.empleado.getId() != id) {
            actual = actual.siguiente;
        }

        // Si encontramos el nodo
        if (actual.siguiente != null) {
            // Saltamos el nodo que queremos borrar
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }

        // No se encontró el ID
        return false;
    }

    // Método para extraer todos los empleados y pasarlos a un ArrayList
    // ¡Así cumplimos también con el requisito de usar ArrayList más adelante!
    public ArrayList<Empleado> obtenerTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        Nodo actual = cabeza;

        while (actual != null) {
            lista.add(actual.empleado);
            actual = actual.siguiente;
        }

        return lista;
    }
}
