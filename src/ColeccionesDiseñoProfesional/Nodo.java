package ColeccionesDiseñoProfesional;

public class Nodo {
    // El dato que guardamos
    public Empleado empleado;
    // El "puntero" hacia el siguiente nodo de la cadena
    public Nodo siguiente;

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.siguiente = null; // Al crearse, aún no apunta a nadie
    }
}
